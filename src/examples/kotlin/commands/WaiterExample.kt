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
package commands

import com.jagrosh.jdautilities.commandclient.CommandEvent
import com.jagrosh.jdautilities.waiter.EventWaiter
import me.kgustave.kjdautils.command.Command
import me.kgustave.kjdautils.waiter.WaitingTimeOut
import me.kgustave.kjdautils.waiter.waitFor
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import java.util.concurrent.TimeUnit

/**
 * @author Kaidan Gustave
 */
class WaiterExample(private val waiter: EventWaiter) : Command() {

    private val CommandEvent.messageHasSameAuthor  : (MessageReceivedEvent) -> Boolean
        get() = { it.author == this.author }
    private val in20Seconds : WaitingTimeOut.() -> Unit
        get() = { delay { 20 } unit { TimeUnit.SECONDS } }
    private val CommandEvent.respond : (MessageReceivedEvent) -> Unit
        get() = { this.replyError("You just said: \"${it.message.rawContent}\"") }

    init {
        this.name { "waiter" }
        this.help { "an example of how to use EventWaiter in KJDA-Utilities" }
    }

    override fun initiate(event: CommandEvent)
    {
        with(event)
        {
            waiter.waitFor<MessageReceivedEvent>() where messageHasSameAuthor then respond timeout in20Seconds
        }
    }
}