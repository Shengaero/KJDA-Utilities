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
@file:JvmName("CommandBuilderKt")
@file:Suppress("Unused", "HasPlatformType")
package me.kgustave.kjdautils.command

import com.jagrosh.jdautilities.commandclient.Command
import com.jagrosh.jdautilities.commandclient.CommandBuilder
import net.dv8tion.jda.core.Permission

/**
 * Creates an initializing block using a [CommandBuilder].
 *
 * **Note:** This must end with [CommandBuilder#build][CommandBuilder.build],
 * as the functionality requires that [init] returns a [Command].
 *
 * @param  init
 *         The initializing block using a CommandBuilder.
 *
 * @return The [Command] built.
 */
inline fun command(init: CommandBuilder.() -> Command) = CommandBuilder().init()

/** Lazy setter for [CommandBuilder#setName][CommandBuilder.setName]. */
infix inline fun CommandBuilder.name(lazy: () -> String) = setName(lazy())

/** Lazy setter for [CommandBuilder#addAlias][CommandBuilder.addAlias]. */
infix inline fun CommandBuilder.alias(lazy: () -> String) = addAlias(lazy())

/** Lazy setter for [CommandBuilder#setHelp][CommandBuilder.setHelp]. */
infix inline fun CommandBuilder.help(lazy: () -> String) = setHelp(lazy())

/** Lazy setter for [CommandBuilder#setArguments][CommandBuilder.setArguments]. */
infix inline fun CommandBuilder.arguments(lazy: () -> String) = setArguments(lazy())

/** Lazy setter for [CommandBuilder#setGuildOnly][CommandBuilder.setGuildOnly]. */
infix inline fun CommandBuilder.guildOnly(lazy: () -> Boolean) = setGuildOnly(lazy())

/** Lazy setter for [CommandBuilder#setOwnerCommand][CommandBuilder.setOwnerCommand]. */
infix inline fun CommandBuilder.ownerCommand(lazy: () -> Boolean) = setOwnerCommand(lazy())

/** Lazy setter for [CommandBuilder#setCategory][CommandBuilder.setCategory]. */
infix inline fun CommandBuilder.category(lazy: () -> Command.Category) = setCategory(lazy())

/** Lazy setter for [CommandBuilder#setCooldown][CommandBuilder.setCooldown]. */
infix inline fun CommandBuilder.cooldown(lazy: () -> Int) = setCooldown(lazy())

/** Lazy setter for [CommandBuilder#setCooldownScope][CommandBuilder.setCooldownScope]. */
infix inline fun CommandBuilder.cooldownScope(lazy: () -> Command.CooldownScope) = setCooldownScope(lazy())

/** Lazy setter for [CommandBuilder#setBotPermissions][CommandBuilder.setBotPermissions]. */
infix inline fun CommandBuilder.botPermissions(lazy: MutableList<Permission>.() -> Unit) = with(ArrayList<Permission>()) {
    lazy()
    setBotPermissions(this)
}

/** Lazy setter for [CommandBuilder#setUserPermissions][CommandBuilder.setUserPermissions]. */
infix inline fun CommandBuilder.userPermissions(lazy: MutableList<Permission>.() -> Unit) = with(ArrayList<Permission>()) {
    lazy()
    setUserPermissions(this)
}

/** Lazy setter for [CommandBuilder#addChild][CommandBuilder.addChild]. */
infix inline fun CommandBuilder.child(lazy: () -> Command) = addChild(lazy())

/** Lazy setter for [CommandBuilder#setUsesTopicTags][CommandBuilder.setUsesTopicTags]. */
infix inline fun CommandBuilder.topicTags(lazy: () -> Boolean) = setUsesTopicTags(lazy())