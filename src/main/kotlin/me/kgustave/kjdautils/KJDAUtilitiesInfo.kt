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
package me.kgustave.kjdautils

/**KJDAUtilities Version Number Major*/
@Deprecated("Scheduled for removal in 0.5.", ReplaceWith("KJDAUtilitiesInfo.VERSION_MAJOR", "me.kgustave.kjdautils.KJDAUtilitiesInfo"))
val versionMajor = "0"
/**KJDAUtilities Version Number Minor*/
@Deprecated("Scheduled for removal in 0.5.", ReplaceWith("KJDAUtilitiesInfo.VERSION_MINOR", "me.kgustave.kjdautils.KJDAUtilitiesInfo"))
val versionMinor = "4"
/**KJDAUtilities Version Number*/
@Suppress("DEPRECATION")
@Deprecated("Scheduled for removal in 0.5.", ReplaceWith("KJDAUtilitiesInfo.FULL_VERSION", "me.kgustave.kjdautils.KJDAUtilitiesInfo"))
val fullVersion = "$versionMajor.$versionMinor"
/**KJDAUtilities GitHub URL*/
@Deprecated("Scheduled for removal in 0.5.", ReplaceWith("KJDAUtilitiesInfo.GITHUB", "me.kgustave.kjdautils.KJDAUtilitiesInfo"))
val github = "https://github.com/TheMonitorLizard/KJDA-Utilities"
@Deprecated("Scheduled for removal in 0.5.", ReplaceWith("KJDAUtilitiesInfo.AUTHOR_NAME", "me.kgustave.kjdautils.KJDAUtilitiesInfo"))
val authorName = "The Monitor Lizard"
@Deprecated("Scheduled for removal in 0.5.", ReplaceWith("KJDAUtilitiesInfo.REAL_AUTHOR", "me.kgustave.kjdautils.KJDAUtilitiesInfo"))
val realAuthor = "Kaidan Gustave"

/**
 * Information regarding [KJDAUtilities](https://github.com/TheMonitorLizard/KJDA-Utilities).
 *
 * @author   Kaidan Gustave
 */
object KJDAUtilitiesInfo
{
    /**KJDAUtilities Version Number*/
    @JvmField val FULL_VERSION  : String = this::class.java.`package`.implementationVersion
    /**KJDAUtilities Version Number Major*/
    @JvmField val VERSION_MAJOR : String = FULL_VERSION.split(Regex("\\."))[0]
    /**KJDAUtilities Version Number Minor*/
    @JvmField val VERSION_MINOR : String = FULL_VERSION.split(Regex("\\."))[1]
    /**KJDAUtilities GitHub URL*/
    @JvmField val GITHUB        : String = "https://github.com/TheMonitorLizard/KJDA-Utilities"
    @JvmField val AUTHOR_NAME   : String = "The Monitor Lizard"
    @JvmField val REAL_AUTHOR   : String = "Kaidan Gustave"
}
