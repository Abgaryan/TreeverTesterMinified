package common.Injection.module;

import android.content.Context;

import com.treever_template_tester.TreeverTesterApplication;
import com.treever_template_tester.comman.API;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

/**
 * Created by Abgaryan on 3/18/18.
 ** Provides application-level dependencies for an app running on a testing environment
 * This allows injecting mocks if necessary.
 */
@Module
public class ApplicationTestModule {

    private Context mApplication;
    public ApplicationTestModule(TreeverTesterApplication application) {
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

    /************* MOCk *************/

    @Provides
    @Singleton
    API provideAPI() {
        return mock(API.class);
    }
}