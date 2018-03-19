package com.treever_template_tester.dagger;

import com.treever_template_tester.ui.main_screen.MainActivity;

import dagger.Component;

/**
 * Created by Abgaryan on 3/18/18.
 * A dagger component that will live during the lifecycle of an Activity but it won't
 * be destroy during configuration changes. Check {@link MainActivity} to see how this components
 * survives configuration changes.
 * Use the {@link ConfigPersistent} scope to annotate dependencies that need to survive
 * configuration changes (for example Presenters).
 */
@ConfigPersistent
@Component(dependencies = ApplicationComponent.class)
public interface ConfigPersistentComponent {

    ActivityModule getActivityModule(ActivityModule activityModule);

}