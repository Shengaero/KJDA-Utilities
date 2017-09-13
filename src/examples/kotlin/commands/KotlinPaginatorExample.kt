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
import com.jagrosh.jdautilities.menu.pagination.PaginatorBuilder
import com.jagrosh.jdautilities.waiter.EventWaiter
import me.kgustave.kjdautils.command.Command
import me.kgustave.kjdautils.menu.*
import net.dv8tion.jda.core.entities.ChannelType
import java.util.concurrent.TimeUnit

/**
 * @author Kaidan Gustave
 */
class KotlinPaginatorExample(waiter: EventWaiter) : Command()
{
    init {
        name { "paginator" }
        help { "gets a demo paginator"}
        cooldown {
            seconds { 20 }
            scope   { CooldownScope.USER }
        }
    }

    private val builder = PaginatorBuilder() timeout {
        delay { 20 }
        unit  { TimeUnit.SECONDS }
    } waiter { waiter }

    override fun initiate(event: CommandEvent) {
        val guilds = event.jda.guilds
        if(guilds.isEmpty())
            return event.replyError("In no guilds!")
        if(guilds.size==1)
            return event.reply("Only in one guild: ${guilds[0].name}")

        builder.clearItems()

        with(builder) {
            for (guild in guilds) add { guild.name }
            text             { t, u -> "Page $t/$u" }
            user             { event.author }
            if(event.isFromType(ChannelType.TEXT))
                color        { event.selfMember.color }
            itemsPerPage     { 8 }
            useNumberedItems { true }
            displayIn        { event.channel }
        }
    }
}