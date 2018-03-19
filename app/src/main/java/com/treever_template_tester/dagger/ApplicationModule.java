package com.treever_template_tester.dagger;

import android.content.Context;

import com.treever_template_tester.TreeverTesterApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Abgaryan on 3/12/18.
 *
 * This is where you will inject application-wide dependencies.
 */
@Module
public class ApplicationModule {

   private Context mApplication;

    public ApplicationModule(TreeverTesterApplication application) {
        mApplication = application;
    }

//    @Provides
//    @Singleton
//    TreeverTesterApplication providesApplication() {
//        return mApplication;
//    }

    @Provides
    @Singleton
    public Context getContext() {
        return mApplication;
    }

}
