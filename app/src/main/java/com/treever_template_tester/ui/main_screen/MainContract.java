package com.treever_template_tester.ui.main_screen;

import com.treever_template_tester.model.ModelTemplate;
import com.treever_template_tester.ui.base.BasePresenter;
import com.treever_template_tester.ui.base.BaseView;

import java.util.List;

/**
 * Created by Abgaryan on 3/16/18.
 * This specifies the contract between the view and the presenter.
 */

public class MainContract {

    public interface View extends BaseView<Presenter> {

        void showProgress();

        void hideProgress();

        void showError();

        void loadToBeTested(List<ModelTemplate> templates);

        void loadToReviewed(List<ModelTemplate> templates);

        void navigateToBeTested();

        void navigateToReViewed();

    }

    public  interface Presenter extends BasePresenter<View> {

        void loadTemplateModels();
    }


}
