package com.treever_template_tester;

import com.treever_template_tester.comman.API;
import com.treever_template_tester.model.ModelTemplate;
import com.treever_template_tester.model.ModelTimeStamp;
import com.treever_template_tester.model.ServerResponseModel;
import com.treever_template_tester.ui.main_screen.MainContract;
import com.treever_template_tester.ui.main_screen.MainPresenter;
import com.treever_template_tester.util.RxSchedulersOverrideRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import common.TestDataFactory;
import io.reactivex.Observable;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Abgaryan on 3/18/18.
 */

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {
    @Mock
    MainContract.View  mMainView;
    @Mock
    API mApi;

    private MainPresenter mMainPresenter;

    @Rule
    public final RxSchedulersOverrideRule mOverrideSchedulersRule = new RxSchedulersOverrideRule();

    @Before
    public void setUp() {
        mMainPresenter = new MainPresenter(mApi);
        mMainPresenter.attachView(mMainView);
    }

    @After
    public void tearDown() {
        mMainPresenter.detachView();
    }



    @Test
    public void loadTemplatesReturnsTemplates() {
        ModelTimeStamp modelTimeStamp = new ModelTimeStamp();
        modelTimeStamp.setLast_request(0);
        ServerResponseModel serverResponseModel = TestDataFactory.makeSereverResponesModel();

        when(mApi.getAssets(modelTimeStamp))
                .thenReturn(Observable.just(serverResponseModel));

        mMainPresenter.loadTemplateModels();
        ArrayList<ModelTemplate> templates = serverResponseModel.getServerDataModel().getModelTemplates();
        ArrayList<ModelTemplate>  toBeTestedTemplates = new ArrayList<>(templates);
        ArrayList<ModelTemplate>  reviewedTemplates = new ArrayList<>(templates);

        toBeTestedTemplates.removeIf(t -> t.getStatus() == 1);
        reviewedTemplates. removeIf(t -> t.getStatus() == 2);

        verify(mMainView).loadToBeTested(toBeTestedTemplates);
        verify(mMainView).loadToReviewed(reviewedTemplates);
        verify(mMainView, never()).showError();


    }





}
