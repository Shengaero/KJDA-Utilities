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
package me.kgustave.kjdautils.extensions

import com.jagrosh.jdautilities.utils.FinderUtil
import net.dv8tion.jda.core.JDA
import net.dv8tion.jda.core.entities.*

/**
 * Queries the receiving instance of [JDA] for [Users][User] using [FinderUtil].
 *
 * @receiver [JDA]   The instance of JDA to search from.
 * @param    [query] The query to search for Users by.
 *
 * @return A possibly-empty [List][MutableList] of [Users][User] matching the [query].
 *
 * @see FinderUtil
 */
fun JDA.findUsers(query: String) : MutableList<User>                   = FinderUtil.findUsers(query, this)

/**
 * Queries the receiving instance of [JDA] for [TextChannels][TextChannel] using [FinderUtil].
 *
 * @receiver [JDA]   The instance of JDA to search from.
 * @param    [query] The query to search for TextChannels by.
 *
 * @return A possibly-empty [List][MutableList] of [TextChannels][TextChannel] matching the [query].
 *
 * @see FinderUtil
 */
fun JDA.findTextChannels(query: String) : MutableList<TextChannel>     = FinderUtil.findTextChannels(query, this)

/**
 * Queries the receiving instance of [JDA] for [VoiceChannels][VoiceChannel] using [FinderUtil].
 *
 * @receiver [JDA]   The instance of JDA to search from.
 * @param    [query] The query to search for VoiceChannels by.
 *
 * @return A possibly-empty [List][MutableList] of [VoiceChannels][VoiceChannel] matching the [query].
 *
 * @see FinderUtil
 */
fun JDA.findVoiceChannels(query: String) : MutableList<VoiceChannel>   = FinderUtil.findVoiceChannels(query, this)

/**
 * Queries the receiving [Guild] for [Members][Member] using [FinderUtil].
 *
 * @receiver [Guild] The Guild to search from.
 * @param    [query] The query to search for Members by.
 *
 * @return A possibly-empty [List][MutableList] of [Members][Member] matching the [query].
 *
 * @see FinderUtil
 */
fun Guild.findMembers(query: String) : MutableList<Member>             = FinderUtil.findMembers(query, this)

/**
 * Queries the receiving [Guild] for [TextChannels][TextChannel] using [FinderUtil].
 *
 * @receiver [Guild] The Guild to search from.
 * @param    [query] The query to search for TextChannels by.
 *
 * @return A possibly-empty [List][MutableList] of [TextChannels][TextChannel] matching the [query].
 *
 * @see FinderUtil
 */
fun Guild.findTextChannels(query: String) : MutableList<TextChannel>   = FinderUtil.findTextChannels(query, this)

/**
 * Queries the receiving [Guild] for [VoiceChannels][VoiceChannel] using [FinderUtil].
 *
 * @receiver [Guild] The Guild to search from.
 * @param    [query] The query to search for VoiceChannels by.
 *
 * @return A possibly-empty [List][MutableList] of [VoiceChannels][VoiceChannel] matching the [query].
 *
 * @see FinderUtil
 */
fun Guild.findVoiceChannels(query: String) : MutableList<VoiceChannel> = FinderUtil.findVoiceChannels(query, this)

/**
 * Queries the instance of [JDA] for [Roles][Role] using [FinderUtil].
 *
 * @receiver [JDA]   The instance of JDA to search from.
 * @param    [query] The query to search for Roles by.
 *
 * @return A possibly-empty [List][MutableList] of [Roles][Role] matching the [query].
 *
 * @see FinderUtil
 */
fun Guild.findRoles(query: String) : MutableList<Role>                 = FinderUtil.findRoles(query, this)

infix inline fun JDA.findUsers(query: () -> String)           = this.findUsers(query())
infix inline fun JDA.findTextChannels(query: () -> String)    = this.findTextChannels(query())
infix inline fun JDA.findVoiceChannels(query: () -> String)   = this.findVoiceChannels(query())
infix inline fun Guild.findMembers(query: () -> String)       = this.findMembers(query())
infix inline fun Guild.findTextChannels(query: () -> String)  = this.findTextChannels(query())
infix inline fun Guild.findVoiceChannels(query: () -> String) = this.findVoiceChannels(query())
infix inline fun Guild.findRoles(query: () -> String)         = this.findRoles(query())