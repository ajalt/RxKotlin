package io.reactivex.rxkotlin

import io.reactivex.*
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.internal.functions.*

private typealias OnT<T> = ((T) -> Unit)?
private typealias OnError = ((Throwable) -> Unit)?
private typealias OnComplete = (() -> Unit)?
/**
 * Overloaded subscribe function that allows passing named parameters
 */
inline fun <reified T : Any> Observable<T>.subscribeBy(
        noinline onError: OnError = null,
        noinline onComplete: OnComplete = null,
        noinline onNext: OnT<T> = null
): Disposable = subscribe(onNext.orDefaultConsumer(), onError.orDefaultOnError(), onComplete.orDefaultOnComplete())

/**
 * Overloaded subscribe function that allows passing named parameters
 */
inline fun <reified T : Any> Flowable<T>.subscribeBy(
        noinline onError: OnError = null,
        noinline onComplete: OnComplete = null,
        noinline onNext: OnT<T> = null
): Disposable = subscribe(onNext.orDefaultConsumer(), onError.orDefaultOnError(), onComplete.orDefaultOnComplete())

/**
 * Overloaded subscribe function that allows passing named parameters
 */
inline fun <reified T : Any> Single<T>.subscribeBy(
        noinline onError: OnError = null,
        noinline onSuccess: OnT<T> = null
): Disposable = subscribe(onSuccess.orDefaultConsumer(), onError.orDefaultOnError())

/**
 * Overloaded subscribe function that allows passing named parameters
 */
inline fun <reified T : Any> Maybe<T>.subscribeBy(
        noinline onError: OnError = null,
        noinline onComplete: OnComplete = null,
        noinline onSuccess: OnT<T> = null
): Disposable = subscribe(onSuccess.orDefaultConsumer(), onError.orDefaultOnError(), onComplete.orDefaultOnComplete())

/**
 * Overloaded subscribe function that allows passing named parameters
 */
fun Completable.subscribeBy(
        onError: OnError = null,
        onComplete: OnComplete = null
): Disposable = if (onError == null) {
    subscribe(onComplete.orDefaultOnComplete())
} else {
    subscribe(onComplete.orDefaultOnComplete(), Consumer(onError))
}

/**
 * Overloaded blockingSubscribe function that allows passing named parameters
 */
inline fun <reified T : Any> Observable<T>.blockingSubscribeBy(
        noinline onError: OnError = null,
        noinline onComplete: OnComplete = null,
        noinline onNext: OnT<T> = null
): Disposable = subscribe(onNext.orDefaultConsumer(), onError.orDefaultOnError(), onComplete.orDefaultOnComplete())

/**
 * Overloaded blockingSubscribe function that allows passing named parameters
 */
inline fun <reified T : Any> Flowable<T>.blockingSubscribeBy(
        noinline onError: OnError = null,
        noinline onComplete: OnComplete = null,
        noinline onNext: OnT<T> = null
): Disposable = subscribe(onNext.orDefaultConsumer(), onError.orDefaultOnError(), onComplete.orDefaultOnComplete())
