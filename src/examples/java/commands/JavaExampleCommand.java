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
package commands;import com.jagrosh.jdautilities.commandclient.CommandEvent;
import me.kgustave.kjdautils.command.Help;
import me.kgustave.kjdautils.command.KCommand;
import me.kgustave.kjdautils.command.Names;
import org.jetbrains.annotations.NotNull;

/**
 * @author Kaidan Gustave
 */
@Names(name = "interoperable", aliases = {"kotlintojava","fromjava"})
@Help(help = "Annotations work perfectly fine here too!")
public class JavaExampleCommand extends KCommand {

    @Override
    public void initiate(@NotNull CommandEvent event)
    {
        event.reply("Hello World, this is java.");
    }
}