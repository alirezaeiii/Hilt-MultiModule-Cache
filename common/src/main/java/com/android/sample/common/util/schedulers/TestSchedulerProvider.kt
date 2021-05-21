package com.android.sample.common.util.schedulers

import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler

/**
 * Implementation of the [BaseSchedulerProvider] making all [Scheduler]s immediate.
 */
class TestSchedulerProvider : BaseSchedulerProvider {

    val testScheduler = TestScheduler()

    override fun computation(): Scheduler = testScheduler

    override fun io(): Scheduler = testScheduler

    override fun ui(): Scheduler = testScheduler
}