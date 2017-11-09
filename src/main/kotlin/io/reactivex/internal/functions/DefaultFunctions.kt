package io.reactivex.internal.functions

import io.reactivex.functions.Action
import io.reactivex.functions.Consumer

fun <P1> ((P1) -> Unit)?.orDefaultConsumer(): Consumer<P1> {
    return if (this == null) {
        Functions.emptyConsumer<P1>()
    } else {
        Consumer(this)
    }
}

fun ((Throwable) -> Unit)?.orDefaultOnError(): Consumer<Throwable> {
    return if (this == null) {
        Functions.ON_ERROR_MISSING
    } else {
        Consumer(this)
    }
}

fun (() -> Unit)?.orDefaultOnComplete(): Action {
    return if (this == null) {
        Functions.EMPTY_ACTION
    } else {
        Action(this)
    }
}