package com.treever_template_tester.ui.player_screen;

import com.treever_template_tester.ui.base.BasePresenter;
import com.treever_template_tester.ui.base.BaseView;
import com.treever_template_tester.ui.main_screen.MainContract;

/**
 * Created by Abgaryan on 3/24/18.
 */

public class PlayerContract {

    public interface View extends BaseView<MainContract.Presenter> {

        void showProgress();

        void hideProgress();

        void showError();


    }

    public interface Presenter extends BasePresenter<MainContract.View> {

        void playAnimation();

        void endAnimation();

        void pauseAnimation();
    }

}
