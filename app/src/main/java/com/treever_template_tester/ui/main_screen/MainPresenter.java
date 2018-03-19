package com.treever_template_tester.ui.main_screen;

import android.annotation.TargetApi;
import android.os.Build;

import com.treever_template_tester.comman.API;
import com.treever_template_tester.dagger.ConfigPersistent;
import com.treever_template_tester.model.ModelTemplate;
import com.treever_template_tester.model.ModelTimeStamp;
import com.treever_template_tester.model.ServerResponseModel;
import com.treever_template_tester.rx.RxUtils;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Provider;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Created by Abgaryan on 3/16/18.
 * Listens to user actions from the UI ({@link MainActivity}), retrieves the data and updates the
 * UI as required.
 */
@ConfigPersistent
public class MainPresenter implements MainContract.Presenter, Provider<MainPresenter> {

    //    @Inject
    API mApi;

    private Disposable mDisposable;

    @NonNull
    private MainContract.View mMainView;


    @Inject
    public MainPresenter(API api) {
        mApi = api;
    }


    @Override
    public void attachView(@NonNull MainContract.View mainView) {
        mMainView = checkNotNull(mainView, "mainView cannot be null!");
    }


    @Override
    public void detachView() {
        if (mDisposable != null) mDisposable.dispose();

    }

    @Override
    public void loadTemplateModels() {
        mMainView.showProgress();
        ModelTimeStamp modelTimeStamp = new ModelTimeStamp();
        modelTimeStamp.setLast_request(0);
        RxUtils.dispose(mDisposable);

        mApi.getAssets(modelTimeStamp)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ServerResponseModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                    }

                    @TargetApi(Build.VERSION_CODES.N)
                    @Override
                    public void onNext(ServerResponseModel serverResponseModel) {
                        mMainView.hideProgress();
                        if (serverResponseModel.getStatus() == 1) {
                            if(serverResponseModel.getServerDataModel().getModelTemplates().size()>0){
                                ArrayList<ModelTemplate> templates = serverResponseModel.getServerDataModel().getModelTemplates();
                                ArrayList<ModelTemplate>  toBeTestedTemplates = new ArrayList<>(templates);
                                ArrayList<ModelTemplate>  reviewedTemplates = new ArrayList<>(templates);

                                toBeTestedTemplates.removeIf(t -> t.getStatus() == 1);
                                reviewedTemplates. removeIf(t -> t.getStatus() == 2);

                                mMainView.loadToReviewed(reviewedTemplates);
                                mMainView.loadToBeTested(toBeTestedTemplates);



                            }


                        } else {
                            mMainView.showError();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mMainView.hideProgress();
                        mMainView.showError();
                    }

                    @Override
                    public void onComplete() {
                        mMainView.hideProgress();
                    }
                });


    }

    @Override
    public MainPresenter get() {
        return this;
    }
}
