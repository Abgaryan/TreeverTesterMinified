package com.treever_template_tester;

import android.app.Application;
import android.content.Context;

import com.treever_template_tester.dagger.ApplicationComponent;
import com.treever_template_tester.dagger.ApplicationModule;
import com.treever_template_tester.dagger.DaggerApplicationComponent;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Abgaryan on 3/11/18.
 */

public class TreeverTesterApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();

    }


    /**
     * Initialize Realm
     * Init's realm in app. Also drops DB in case of migration required.
     * https://realm.io/docs/java/latest/
     */
    private void initRealm(){
        Realm.init(this);

        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm realm = Realm.getInstance(config);

        realm.close();
    }

    private void initAppComponent(){
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getAppComponent(){
        if (applicationComponent == null) {
            initAppComponent();
        }

        return applicationComponent;
    }



    public static TreeverTesterApplication get(Context context) {
        return (TreeverTesterApplication) context.getApplicationContext();
    }



    public void setComponent(ApplicationComponent applicationComponent) {
        applicationComponent = applicationComponent;
    }
}
