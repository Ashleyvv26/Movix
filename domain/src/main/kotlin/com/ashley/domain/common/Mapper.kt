package com.ashley.domain.common

import com.ashley.domain.entities.Optional
import io.reactivex.Observable


<<<<<<< HEAD

=======
/**
 * Created by Yossi Segev on 05/01/2018.
 */
>>>>>>> git3/master

abstract class Mapper<in E, T> {
    abstract fun mapFrom(from: E): T

    fun mapOptional(from: Optional<E>): Optional<T> {
        from.value?.let {
            return Optional.of(mapFrom(it))
        } ?: return Optional.empty()
    }

    fun observable(from: E): Observable<T> {
        return Observable.fromCallable { mapFrom(from) }
    }

    fun observable(from: List<E>): Observable<List<T>> {
        return Observable.fromCallable { from.map { mapFrom(it) } }
    }
}