package com.ashley.domain.common

import io.reactivex.Observable
import io.reactivex.ObservableSource

<<<<<<< HEAD
=======
/**
 * Created by Yossi Segev on 13/11/2017.
 */
>>>>>>> git3/master
class TestTransformer<T>: Transformer<T>() {
    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream
    }

}