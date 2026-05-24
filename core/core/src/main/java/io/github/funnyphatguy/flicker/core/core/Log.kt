package io.github.funnyphatguy.flicker.core.core

import co.touchlab.kermit.Logger

object Log {
    fun d(tag: String, message: String) = Logger.d(tag) { message }
    fun i(tag: String, message: String) = Logger.i(tag) { message }
    fun w(tag: String, message: String) = Logger.w(tag) { message }
    fun e(tag: String, message: String, throwable: Throwable? = null) =
        Logger.e(tag, throwable) { message }
}