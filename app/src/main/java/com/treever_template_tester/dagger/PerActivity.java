package com.treever_template_tester.dagger;

/**
 * Created by Abgaryan on 3/12/18.
 */

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of the activity to be memorized in the
 * correct component.
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {}