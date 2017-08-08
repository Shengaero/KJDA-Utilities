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
@file:JvmName("KCommandClientBuilder")
@file:Suppress("unused")
package me.kgustave.kjdautils

import com.jagrosh.jdautilities.commandclient.*
import net.dv8tion.jda.core.JDABuilder
import net.dv8tion.jda.core.entities.Game
import java.util.concurrent.ScheduledExecutorService

/**
 * A closure-based adaptation of [CommandClientBuilder].
 *
 * This inherits all original setters from the original CommandClientBuilder,
 * as well as lazy setters.
 *
 * This will automatically be built and added to the [JDABuilder] that calls
 * this as an [EventListener][net.dv8tion.jda.core.hooks.EventListener].
 *
 * @receiver The instance of [JDABuilder] the [CommandClient] built will
 *           be added to.
 *
 * @param    [init]
 *           The initializing function that creates the CommandClientBuilder
 *           to be added to the JDABuilder
 *
 * @return   The [JDABuilder] instance. Useful for chaining.
 *
 * @author   Kaidan Gustave
 * @since    0.1
 */
infix inline fun <reified T : JDABuilder> T.commandClient(init: CommandClientBuilder.() -> Unit) : T = with(CommandClientBuilder())
{
    init()
    addEventListener(build()) as T
}

/**A lazy setter adaptation of [CommandClientBuilder.setOwnerId].*/
infix inline fun <reified T: CommandClientBuilder> T.ownerId(lazy: () -> Any) : T = with(lazy())
{
    if(this is String || this is Long)
        setOwnerId(this.toString()) as T
    else throw IllegalArgumentException("Owner ID must be a Long or String!")
}
/**A lazy setter adaptation of [CommandClientBuilder.setCoOwnerIds].*/
infix inline fun <reified T: CommandClientBuilder> T.coOwnerIds(lazy: () -> Array<String>) : T
        = this.setCoOwnerIds(*lazy()) as T
/**A lazy setter adaptation of [CommandClientBuilder.setPrefix].*/
infix inline fun <reified T: CommandClientBuilder> T.prefix(lazy: () -> String) : T
        = this.setPrefix(lazy()) as T
/**A lazy setter adaptation of [CommandClientBuilder.setGame].*/
infix inline fun <reified T: CommandClientBuilder> T.game(lazy: () -> Game) : T
        = this.setGame(lazy()) as T
/**A lazy setter adaptation of [CommandClientBuilder.setServerInvite].*/
infix inline fun <reified T: CommandClientBuilder> T.serverInvite(lazy: () -> String) : T
        = this.setServerInvite(lazy()) as T
/**A lazy setter adaptation of [CommandClientBuilder.setCarbonitexKey].*/
infix inline fun <reified T: CommandClientBuilder> T.carbonKey(lazy: () -> String) : T
        = this.setCarbonitexKey(lazy()) as T
/**A lazy setter adaptation of [CommandClientBuilder.setDiscordBotsKey].*/
infix inline fun <reified T: CommandClientBuilder> T.dBotsKey(lazy: () -> String) : T
        = this.setDiscordBotsKey(lazy()) as T
/**A lazy setter adaptation of [CommandClientBuilder.setListener].*/
infix inline fun <reified T: CommandClientBuilder> T.listener(lazy: () -> CommandListener) : T
        = this.setListener(lazy()) as T
/**A lazy setter adaptation of [CommandClientBuilder.useHelpBuilder].*/
infix inline fun <reified T: CommandClientBuilder> T.useHelp(lazy: () -> Boolean) : T
        = this.useHelpBuilder(lazy()) as T
/**A lazy setter adaptation of [CommandClientBuilder.setHelpFunction].*/
infix inline fun <reified T: CommandClientBuilder> T.helpFunction(noinline lazy: (event:CommandEvent) -> String) : T
        = this.setHelpFunction(lazy) as T
/**A lazy setter adaptation of [CommandClientBuilder.setHelpWord].*/
infix inline fun <reified T: CommandClientBuilder> T.helpWord(lazy: () -> String) : T
        = this.setHelpWord(lazy()) as T
/**A lazy setter adaptation of [CommandClientBuilder.setScheduleExecutor].*/
infix inline fun<reified T: CommandClientBuilder> T.executor(lazy: () -> ScheduledExecutorService) : T
        = this.setScheduleExecutor(lazy()) as T
/**A lazy setter adaptation of [CommandClientBuilder.addCommand].*/
infix inline fun <reified T: CommandClientBuilder> T.command(lazy: () -> Command) : T
        = this.addCommand(lazy()) as T
/**A lazy setter adaptation of [CommandClientBuilder.addCommands].*/
infix inline fun <reified T: CommandClientBuilder> T.commands(lazy: () -> Array<com.jagrosh.jdautilities.commandclient.Command>) : T
        = this.addCommands(*lazy()) as T
/**A lazy setter adaptation of [CommandClientBuilder.setEmojis].*/
infix inline fun <reified T: CommandClientBuilder> T.emojis(lazy: Emojis.() -> Unit) : T
        = with(Emojis()) { lazy(); setEmojis(this.success, this.error, this.warning) as T }

/**
 * An organized collection of three Strings that will
 * be used as the [CommandClient][CommandClient]'s
 * success, warning, and error emoji's.
 */
class Emojis
{
    var success : String? = null
    var warning : String? = null
    var error   : String? = null

    infix inline fun success(success: () -> String) { this.success = success() }
    infix inline fun warning(warning: () -> String) { this.warning = warning() }
    infix inline fun error(error:     () -> String) {   this.error = error()   }
}