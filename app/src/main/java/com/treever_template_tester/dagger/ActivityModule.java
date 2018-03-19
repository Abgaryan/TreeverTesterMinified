package com.treever_template_tester.dagger;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Abgaryan on 3/12/18.
 */

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @PerActivity
    Activity getActivity() {
        return this.mActivity;
    }

}
