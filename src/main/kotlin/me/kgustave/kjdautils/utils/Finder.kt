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
@file:JvmName("FinderKt")
package me.kgustave.kjdautils.utils

import com.jagrosh.jdautilities.utils.FinderUtil
import net.dv8tion.jda.core.JDA
import net.dv8tion.jda.core.entities.*

/**
 * Queries the receiving instance of [JDA] for [Users][User] using [FinderUtil].
 *
 * @receiver The instance of [JDA] to search from.
 * @param    [query] The query to search for Users by.
 *
 * @return A possibly-empty [List] of [Users][User] matching the [query].
 *
 * @see FinderUtil
 */
infix fun JDA.findUsers(query: String) : List<User>                   = FinderUtil.findUsers(query, this)

/**
 * Queries the receiving instance of [JDA] for [TextChannels][TextChannel] using [FinderUtil].
 *
 * @receiver The instance of [JDA] to search from.
 * @param    [query] The query to search for TextChannels by.
 *
 * @return A possibly-empty [List] of [TextChannels][TextChannel] matching the [query].
 *
 * @see FinderUtil
 */
infix fun JDA.findTextChannels(query: String) : List<TextChannel>     = FinderUtil.findTextChannels(query, this)

/**
 * Queries the receiving instance of [JDA] for [VoiceChannels][VoiceChannel] using [FinderUtil].
 *
 * @receiver The instance of [JDA] to search from.
 * @param    [query] The query to search for VoiceChannels by.
 *
 * @return A possibly-empty [List] of [VoiceChannels][VoiceChannel] matching the [query].
 *
 * @see FinderUtil
 */
infix fun JDA.findVoiceChannels(query: String) : List<VoiceChannel>   = FinderUtil.findVoiceChannels(query, this)

/**
 * Queries the receiving instance of [JDA] for [Users][User] using [FinderUtil].
 *
 * @receiver The [Guild] to search from.
 * @param    [query] The query to search for Users by.
 *
 * @return A possibly-empty [List] of [Users][User] matching the [query].
 *
 * @see FinderUtil
 */
infix fun Guild.findBannedUsers(query: String) : List<User>?          = FinderUtil.findBannedUsers(query, this)

/**
 * Queries the receiving [Guild] for [Members][Member] using [FinderUtil].
 *
 * @receiver The [Guild] to search from.
 * @param    [query] The query to search for Members by.
 *
 * @return A possibly-empty [List] of [Members][Member] matching the [query].
 *
 * @see FinderUtil
 */
infix fun Guild.findMembers(query: String) : List<Member>             = FinderUtil.findMembers(query, this)

/**
 * Queries the receiving [Guild] for [TextChannels][TextChannel] using [FinderUtil].
 *
 * @receiver The [Guild] to search from.
 * @param    [query] The query to search for TextChannels by.
 *
 * @return A possibly-empty [List] of [TextChannels][TextChannel] matching the [query].
 *
 * @see FinderUtil
 */
infix fun Guild.findTextChannels(query: String) : List<TextChannel>   = FinderUtil.findTextChannels(query, this)

/**
 * Queries the receiving [Guild] for [VoiceChannels][VoiceChannel] using [FinderUtil].
 *
 * @receiver The [Guild] to search from.
 * @param    [query] The query to search for VoiceChannels by.
 *
 * @return A possibly-empty [List] of [VoiceChannels][VoiceChannel] matching the [query].
 *
 * @see FinderUtil
 */
infix fun Guild.findVoiceChannels(query: String) : List<VoiceChannel> = FinderUtil.findVoiceChannels(query, this)

/**
 * Queries the instance of [JDA] for [Roles][Role] using [FinderUtil].
 *
 * @receiver The [Guild] to search from.
 * @param    [query] The query to search for Roles by.
 *
 * @return A possibly-empty [List] of [Roles][Role] matching the [query].
 *
 * @see FinderUtil
 */
infix fun Guild.findRoles(query: String) : List<Role>                 = FinderUtil.findRoles(query, this)

infix inline fun JDA.findUsers(query: () -> String)           = this.findUsers(query())
infix inline fun JDA.findTextChannels(query: () -> String)    = this.findTextChannels(query())
infix inline fun JDA.findVoiceChannels(query: () -> String)   = this.findVoiceChannels(query())
infix inline fun Guild.findBannedUsers(query: () -> String)   = this.findBannedUsers(query())
infix inline fun Guild.findMembers(query: () -> String)       = this.findMembers(query())
infix inline fun Guild.findTextChannels(query: () -> String)  = this.findTextChannels(query())
infix inline fun Guild.findVoiceChannels(query: () -> String) = this.findVoiceChannels(query())
infix inline fun Guild.findRoles(query: () -> String)         = this.findRoles(query())