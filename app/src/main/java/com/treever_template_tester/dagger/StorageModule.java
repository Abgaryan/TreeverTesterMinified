package com.treever_template_tester.dagger;

import android.content.Context;
import android.content.SharedPreferences;

import com.treever_template_tester.comman.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Abgaryan on 3/12/18.
 */

@Module
public class  StorageModule {

    @Provides
    @Singleton
    public SharedPreferences getSharedPreferences(Context context){
        return context.getSharedPreferences(Constants.SHARED_PREFERENCE, Context.MODE_PRIVATE);
    }
}
