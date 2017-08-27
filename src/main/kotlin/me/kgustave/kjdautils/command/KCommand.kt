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
package me.kgustave.kjdautils.command

import com.jagrosh.jdautilities.commandclient.Command
import com.jagrosh.jdautilities.commandclient.CommandEvent
import net.dv8tion.jda.core.Permission
import java.util.function.BiConsumer

typealias Command = KCommand

/**
 * An extension of [Command][com.jagrosh.jdautilities.commandclient.Command]
 * geared towards Kotlin usage.
 *
 * KCommand's make usage of the numerous annotations in `Annotations.kt`, as
 * well as some convenience lazy setters.
 *
 * @since    0.2
 * @author   Kaidan Gustave
 */
abstract class KCommand : Command()
{
    /**
     * Whether or not the [KCommand] uses [KCommandAnnotations][KCommandAnnotation].
     *
     * This will eliminate any annotation overhead if set to `true`.
     *
     * Default: `false`
     */
    @JvmField protected var noAnnotations = false

    ///////////////////////
    // PRIVATE FUNCTIONS //
    ///////////////////////

    private infix inline fun <reified T : Collection<Annotation>> T.filterUnneeded(usage: KCommandAnnotationUsage) =
            filter { it.annotationClass.annotations.filterIsInstance<KCommandAnnotation>().any { it.usage == usage } }

    private fun processAnnotations() {
        if(noAnnotations)
            return
        // Filter out unnecessary annotations
        for(annotation in this::class.annotations.filterUnneeded(KCommandAnnotationUsage.INSTANTIATION))
        {
            if(annotation is Names)
            {
                name = annotation.name
                aliases = annotation.aliases
                continue
            }

            if(annotation is BotPermissions)
            {
                botPermissions = annotation.permissions
                continue
            }

            if(annotation is UserPermissions)
            {
                botPermissions = annotation.permissions
                continue
            }
        }
    }

    ////////////////////
    // INITIALIZATION //
    ////////////////////

    init
    {
        processAnnotations()
    }

    /////////////////////////
    // PROTECTED FUNCTIONS //
    /////////////////////////

    final override fun execute(event: CommandEvent)
    {
        if(!noAnnotations)
        {
            with(this::class.annotations.filterUnneeded(KCommandAnnotationUsage.EXECUTION)) // Filter out unnecessary
            {
                if(this.isNotEmpty())
                    this.forEach {
                        if(it is MustHaveArguments)
                            if(event.args.isEmpty())
                                return if(it.error.isNotEmpty()) event.replyError(it.error) else Unit
                            else return@forEach
                    }
            }
        }
        initiate(event)
    }

    /**
     * The actual operations of the [KCommand].
     *
     * This is equivalent to [Command.execute] in normal JDA-Utilities.
     */
    protected abstract fun initiate(event: CommandEvent)

    //////////////////
    // LAZY SETTERS //
    //////////////////

    protected infix inline fun KCommand.name(lazy: () -> String) { name = lazy() }
    protected infix inline fun KCommand.aliases(lazy: () -> Array<String>) { aliases = lazy() }
    protected infix inline fun KCommand.arguments(lazy: () -> String) { arguments = lazy() }
    protected infix inline fun KCommand.help(lazy: () -> String) { help = lazy() }
    protected infix inline fun KCommand.guildOnly(lazy: () -> Boolean) { guildOnly = lazy() }
    protected infix inline fun KCommand.ownerCommand(lazy: () -> Boolean) { ownerCommand = lazy() }
    protected infix inline fun KCommand.usesTopicTags(lazy: () -> Boolean) { usesTopicTags = lazy() }
    protected infix inline fun KCommand.requiredRole(lazy: () -> String) { requiredRole = lazy() }
    protected infix fun KCommand.helpBiConsumer(lazy: (CommandEvent, Command) -> Unit) { helpBiConsumer = BiConsumer(lazy) }
    protected infix inline fun KCommand.userPermissions(lazy: () -> Array<Permission>) { userPermissions = lazy() }
    protected infix inline fun KCommand.botPermissions(lazy: () -> Array<Permission>) { botPermissions = lazy() }
    protected infix inline fun KCommand.category(lazy: () -> Category) { category = lazy() }
    protected infix inline fun KCommand.children(lazy: () -> Array<Command>) { children = lazy() }
    protected infix inline fun KCommand.cooldown(lazy: Cooldown.() -> Unit) = with(Cooldown()) {
        lazy()
        cooldown = this.seconds
        cooldownScope = this.scope
    }
    protected infix inline fun KCommand.noAnnotations(lazy: () -> Boolean) { noAnnotations = lazy() }

    /**
     * A container for a cooldown's length in seconds and it's [scope][Command.CooldownScope].
     *
     * @author   Kaidan Gustave
     */
    inner class Cooldown
    {
        var seconds: Int = 0
        var scope: Command.CooldownScope = Command.CooldownScope.USER

        infix inline fun seconds(lazy: () -> Int) { seconds = lazy() }
        infix inline fun scope(lazy: () -> Command.CooldownScope) { scope = lazy() }
    }
}
