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
package me.kgustave.kjdautils.waiter

import com.jagrosh.jdautilities.waiter.EventWaiter
import net.dv8tion.jda.core.JDA
import net.dv8tion.jda.core.JDABuilder

/**A lazy setter that adds an [EventWaiter] to a [JDABuilder].*/
infix inline fun <reified T : JDABuilder> T.waiter(lazy: () -> EventWaiter) : T = this.addEventListener(lazy()) as T

/**A lazy setter that adds an [EventWaiter] to [JDA].*/
infix inline fun <reified T : JDA> T.waiter(lazy: () -> EventWaiter) : T = this.addEventListener(lazy()) as T


