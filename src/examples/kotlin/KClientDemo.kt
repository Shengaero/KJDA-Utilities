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

import commands.*
import club.minnced.kjda.token
import com.jagrosh.jdautilities.commandclient.examples.PingCommand
import com.jagrosh.jdautilities.waiter.EventWaiter
import me.kgustave.kjdautils.*
import me.kgustave.kjdautils.waiter.waiter
import net.dv8tion.jda.core.AccountType
import net.dv8tion.jda.core.JDABuilder

/**
 * @author Kaidan Gustave
 */
class KClientDemo
{
    fun initialize()
    {
        with(JDABuilder(AccountType.BOT))
        {
            val waiter = EventWaiter()
            token { "<Example_Token>" }
            // Thanks to the nifty 'commandClient' extension function, you can
            // instantiate, build, and add your CommandClient straight into
            // JDABuilder without breaking a chain!
            commandClient {
                prefix   { "!?" }
                ownerId  { 123456789123L }
                command  { PingCommand() }
                commands {
                    waiter { waiter }
                    arrayOf(
                            JavaExampleCommand(),
                            KotlinAnnotationsExample(),
                            KotlinPaginatorExample(waiter)
                    )
                }
                emojis   {
                    success { ":)" }
                    warning { ":|" }
                    error   { ":(" }
                }
            }
            buildAsync()
        }
    }
}

fun main(args: Array<String>) = KClientDemo().initialize()