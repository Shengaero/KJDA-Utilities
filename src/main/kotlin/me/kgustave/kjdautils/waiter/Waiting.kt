/*
 * Copyright 2017 Kaidan Gustave
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:Suppress("unused")
@file:JvmName("WaitingKt")
package me.kgustave.kjdautils.waiter

import com.jagrosh.jdautilities.waiter.EventWaiter
import net.dv8tion.jda.core.JDA
import net.dv8tion.jda.core.JDABuilder
import net.dv8tion.jda.core.events.Event
import java.util.concurrent.TimeUnit
import java.util.function.Consumer
import java.util.function.Predicate

/**A lazy setter that adds an [EventWaiter] to a [JDABuilder].*/
infix inline fun <reified T : JDABuilder> T.waiter(lazy: () -> EventWaiter) : T = this.addEventListener(lazy()) as T

/**A lazy setter that adds an [EventWaiter] to [JDA].*/
infix inline fun <reified T : JDA> T.waiter(lazy: () -> EventWaiter) : T = this.addEventListener(lazy()) as T
inline fun <reified T : Event> EventWaiter.waitFor() : WaitingCondition<T> =
        WaitingCondition(T::class.java, this, {true}, {})

class WaitingCondition<T : Event>(val c : Class<T>,
                                  val waiter: EventWaiter,
                                  private var condition: (T) -> Boolean,
                                  private val action: (T) -> Unit
) : (T) -> Boolean {
    override fun invoke(p1: T): Boolean = condition(p1)

    var timeout : WaitingTimeOut = WaitingTimeOut()

    infix fun where(lazy: (T) -> Boolean) : WaitingCondition<T> {
        condition = lazy
        return this
    }

    infix fun then(lazy: (T) -> Unit) = WaitingAction(this, lazy)

    infix inline fun timeout(init: WaitingTimeOut.() -> Unit) = with(WaitingTimeOut()) {
        init()
        this@WaitingCondition.timeout = this
        return@with this@WaitingCondition
    }
}

class WaitingAction<T : Event>(private val condition: WaitingCondition<T>, private val action: (T) -> Unit)
{
    private fun invoke() = condition.waiter.waitForEvent(condition.c,
            Predicate(condition), Consumer(action), condition.timeout.delay,
                    condition.timeout.unit, Runnable(condition.timeout))


    infix fun timeout(init: WaitingTimeOut.() -> Unit) = with(WaitingTimeOut()) {
        init()
        this@WaitingAction.condition.timeout = this
        return@with this@WaitingAction
    }

    init {
        invoke()
    }
}

class WaitingTimeOut : () -> Unit
{

    var delay : Long = -1
    var unit : TimeUnit? = null
    var runnable : () -> Unit = {}

    infix inline fun delay(lazy: () -> Long) : WaitingTimeOut {
        require(lazy()>-1) { "Delay must be positive or zero!" }
        delay = lazy()
        return this
    }

    infix inline fun unit(lazy: () -> TimeUnit) : WaitingTimeOut {
        unit = lazy()
        return this
    }

    infix inline fun action(crossinline lazy: () -> Unit) : WaitingTimeOut {
        this.runnable = { lazy() }
        return this
    }

    override fun invoke() {
        runnable
    }
}