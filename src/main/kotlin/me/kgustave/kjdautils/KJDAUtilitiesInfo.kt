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
val versionMajor = "0"
/**KJDAUtilities Version Number Minor*/
val versionMinor = "2"
/**KJDAUtilities Version Number*/
val fullVersion = "$versionMajor.$versionMinor"
/**KJDAUtilities GitHub URL*/
val github = "https://github.com/TheMonitorLizard/KJDA-Utilities"
val authorName = "The Monitor Lizard"
val realAuthor = "Kaidan Gustave"

/**
 * Information regarding [KJDAUtilities](https://github.com/TheMonitorLizard/KJDA-Utilities).
 *
 * @author   Kaidan Gustave
 */
class KJDAUtilitiesInfo private constructor()
{
    companion object
    {
        @JvmField val VERSION_MAJOR : String = versionMajor
        @JvmField val VERSION_MINOR : String = versionMinor
        @JvmField val FULL_VERSION  : String = fullVersion
        @JvmField val GITHUB        : String = github
        @JvmField val AUTHOR_NAME   : String = authorName
        @JvmField val REAL_AUTHOR   : String = realAuthor
    }
}
