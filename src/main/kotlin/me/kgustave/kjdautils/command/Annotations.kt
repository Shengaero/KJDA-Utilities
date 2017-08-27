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
@file:Suppress("unused", "MemberVisibilityCanPrivate")
package me.kgustave.kjdautils.command

import net.dv8tion.jda.core.Permission

/**
 * Constants for designating [KCommandAnnotations][KCommandAnnotation]
 * usage location.
 *
 * This is employed in order to prevent non-necessary annotation processing during operations,
 * and comes in two forms:
 *
 * - [Instantiation][KCommandAnnotationUsage.INSTANTIATION]: used **once at instantiation**.
 * - [Execution][KCommandAnnotationUsage.EXECUTION]: used **just before and/or during execution**.
 *
 * All KCommand annotations have this usage documented in the `@annotationUsage` doc-tag.
 */
enum class KCommandAnnotationUsage
{
    /**
     * Designates that the usage of the annotation
     * is only during instantiation.
     */
    INSTANTIATION,

    /**
     * Designates that the usage of the annotation
     * is during execution.
     */
    EXECUTION
}

/**
 * Designates annotations as 'KCommand-Specific'.
 *
 * @author Kaidan Gustave
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class KCommandAnnotation(val usage: KCommandAnnotationUsage)

/**
 * Annotates a [KCommand][KCommand] to signify that it must have
 * arguments in order to operate further.
 *
 * This will provide an [error][MustHaveArguments.error] response
 * if one is provided.
 *
 * @author Kaidan Gustave
 *
 * @annotationUsage [KCommandAnnotationUsage.EXECUTION]
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@KCommandAnnotation(KCommandAnnotationUsage.EXECUTION)
@MustBeDocumented
annotation class MustHaveArguments(/**An error message that will be sent if the call does not have arguments.*/ val error: String = "")

/**
 * Annotates a [KCommand][KCommand] so that the [KCommand.name]
 * will be set as to what is provided as the [name] parameter.
 *
 * Additionally, any other parameters specified will become the
 * command's [aliases].
 *
 * @author Kaidan Gustave
 *
 * @annotationUsage [KCommandAnnotationUsage.INSTANTIATION]
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@KCommandAnnotation(KCommandAnnotationUsage.INSTANTIATION)
@MustBeDocumented
annotation class Names constructor(/**The name of the [KCommand].*/ val name: String, /**The aliases of the [KCommand].*/ vararg val aliases: String)

/**
 * Annotates a [KCommand][KCommand] so that the [KCommand.botPermissions]
 * will be set as to what is provided as the [permissions] parameter.
 *
 * @author Kaidan Gustave
 *
 * @annotationUsage [KCommandAnnotationUsage.INSTANTIATION]
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@KCommandAnnotation(KCommandAnnotationUsage.INSTANTIATION)
@MustBeDocumented
annotation class BotPermissions constructor(/**The [Permissions][Permission] the bot must have to use this [KCommand].*/ vararg val permissions: Permission)

/**
 * Annotates a [KCommand][KCommand] so that the [KCommand.userPermissions]
 * will be set as to what is provided as the [permissions] parameter.
 *
 * @author Kaidan Gustave
 *
 * @annotationUsage [KCommandAnnotationUsage.INSTANTIATION]
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@KCommandAnnotation(KCommandAnnotationUsage.INSTANTIATION)
@MustBeDocumented
annotation class UserPermissions constructor(/**The [Permissions][Permission] a user must have to use this [KCommand].*/ vararg val permissions: Permission)

/**
 * Annotates a [KCommand][KCommand] so that the [KCommand.help]
 * will be set as to what is provided as the [help] parameter.
 *
 * @author Kaidan Gustave
 *
 * @annotationUsage [KCommandAnnotationUsage.INSTANTIATION]
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@KCommandAnnotation(KCommandAnnotationUsage.INSTANTIATION)
@MustBeDocumented
annotation class Help constructor(/**The help snippet for this [KCommand].*/ val help: String)

/**
 * Annotates a [KCommand][KCommand] so that the [KCommand.arguments]
 * will be set as to what is provided as the [arguments] parameter.
 *
 * @author Kaidan Gustave
 *
 * @annotationUsage [KCommandAnnotationUsage.INSTANTIATION]
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@KCommandAnnotation(KCommandAnnotationUsage.INSTANTIATION)
@MustBeDocumented
annotation class Arguments constructor(/**The arguments snippet for this [KCommand].*/ val arguments: String)
