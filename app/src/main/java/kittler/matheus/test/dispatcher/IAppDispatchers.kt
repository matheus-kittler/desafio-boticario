package kittler.matheus.test.dispatcher

import kotlin.coroutines.CoroutineContext

interface IAppDispatchers {
    val io: CoroutineContext
    val main: CoroutineContext
}