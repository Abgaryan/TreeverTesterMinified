package common.Injection.module;

import com.treever_template_tester.comman.API;
import com.treever_template_tester.ui.main_screen.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class PresenterModule {
    @Provides
    @Singleton
    public MainPresenter MainPresenter(API api) {
        return new MainPresenter(api);
    }
}
