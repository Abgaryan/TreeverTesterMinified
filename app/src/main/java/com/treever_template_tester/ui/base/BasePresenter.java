package com.treever_template_tester.ui.base;

/**
 * Created by Abgaryan on 3/12/18.
 */

public interface BasePresenter<T> {

    void attachView(T view);


    void detachView();
}
