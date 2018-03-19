package com.treever_template_tester.rx;

import io.reactivex.disposables.Disposable;

/**
 * Created by Abgaryan on 3/12/18.
 */


public class RxUtils {
    public static void dispose(Disposable disposable) {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}

