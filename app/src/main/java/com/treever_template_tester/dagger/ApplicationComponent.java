package com.treever_template_tester.dagger;

import android.content.Context;

import com.treever_template_tester.comman.API;
import com.treever_template_tester.ui.main_screen.MainActivity;
import com.treever_template_tester.ui.main_screen.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Abgaryan on 3/12/18.
 */
@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                NetModule.class,
                StorageModule.class,
                PresenterModule.class
        }
)
public interface ApplicationComponent {
    Context context();
    API api();



    void inject(MainActivity mainActivity);

    void inject(MainPresenter mainPresenter);


}
