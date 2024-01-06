package com.pedroabreudev.testing

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.rules.TestWatcher
import org.junit.runner.Description

@ExperimentalCoroutinesApi
class MainCoroutineRule(
    private val dispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()
//    val testDispatcher: TestDispatcher = UnconfinedTestDispatcher(TestCoroutineScheduler())
) : TestWatcher(), TestCoroutineScope by TestCoroutineScope(dispatcher) {

//    val testDispatcherProvider = object : CoroutinesDispatchers {
//        override fun default(): CoroutineDispatcher = testDispatcher
//        override fun io(): CoroutineDispatcher = testDispatcher
//        override fun main(): CoroutineDispatcher = testDispatcher
//        override fun unconfined(): CoroutineDispatcher = testDispatcher
//    }

    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(dispatcher)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        cleanupTestCoroutines()
        Dispatchers.resetMain()
    }
}