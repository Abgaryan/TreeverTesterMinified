package com.treever_template_tester.ui.player_screen;

import com.treever_template_tester.comman.API;
import com.treever_template_tester.dagger.ConfigPersistent;
import com.treever_template_tester.ui.main_screen.MainActivity;
import com.treever_template_tester.ui.main_screen.MainContract;

import javax.inject.Inject;
import javax.inject.Provider;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Created by Abgaryan on 3/16/18.
 * Listens to user actions from the UI ({@link MainActivity}), retrieves the data and updates the
 * UI as required.
 */
@ConfigPersistent
public class PlayerPresenter implements PlayerContract.Presenter, Provider<PlayerPresenter> {

    //    @Inject
    API mApi;

    private Disposable mDisposable;

    @NonNull
    private MainContract.View mMainView;


    @Inject
    public PlayerPresenter(API api) {
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
    public PlayerPresenter get() {
        return this;
    }

    @Override
    public void playAnimation() {

    }

    @Override
    public void endAnimation() {

    }

    @Override
    public void pauseAnimation() {

    }
}
