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
@file:Suppress("unused", "MemberVisibilityCanPrivate", "HasPlatformType")
@file:JvmName("OrderedKt")
package me.kgustave.kjdautils.menu

import com.jagrosh.jdautilities.menu.orderedmenu.OrderedMenuBuilder

/**
 * Represents a choice for an [OrderedMenu][com.jagrosh.jdautilities.menu.orderedmenu.OrderedMenu].
 *
 * OrderedChoices have two parts:
 * - The [name] of the choice, which will be displayed in the Menu.
 * - The [action] that will be preformed when the this choice is selected.
 *
 * These can be added to an OrderedMenu builder using [OrderedMenuBuilder#choices][choices],
 * but must all be added at the same time, and without using [OrderedMenuBuilder.setChoices],
 * [OrderedMenuBuilder.addChoices], or [OrderedMenuBuilder.setAction].
 */
class OrderedChoice
{
    var name : String = "null"
    var action : (() -> Unit) = {}

    infix inline fun name(lazy: () -> String) : OrderedChoice
    {
        this.name = lazy()
        return this
    }

    @Deprecated("Set to be removed in 0.5", ReplaceWith("'action' setter"))
    infix fun action(action : (() -> Unit)) : OrderedChoice
    {
        this.action = action
        return this
    }
}

/**
 * Creates and builds an [ArrayList] of [OrderedChoices][OrderedChoice].
 *
 * **NOTE:** This does not work correctly or at all if you use
 * [OrderedMenuBuilder.setChoices], [OrderedMenuBuilder.addChoices],
 * or [OrderedMenuBuilder.setAction].
 */
infix inline fun OrderedMenuBuilder.choices(lazy: ArrayList<OrderedChoice>.() -> Unit) = with(ArrayList<OrderedChoice>()) {
    lazy()
    return@with setChoices(*this.map { it.name }.toTypedArray()).setAction { this[it-1].action() }
}

/**A lazy setter for [OrderedMenuBuilder.setDescription].*/
infix inline fun OrderedMenuBuilder.description(lazy: () -> String?) = setDescription(lazy())

/**A lazy setter for [OrderedMenuBuilder.setText].*/
infix inline fun OrderedMenuBuilder.text(lazy: () -> String?) = setText(lazy())

/**A lazy setter for [OrderedMenuBuilder.useCancelButton].*/
infix inline fun OrderedMenuBuilder.useCancelButton(lazy: () -> Boolean) = useCancelButton(lazy())

/**A lazy setter for [OrderedMenuBuilder.useLetters].*/
infix inline fun OrderedMenuBuilder.useLetters(lazy: () -> Boolean) =  if(lazy()) useLetters() else this

/**A lazy setter for [OrderedMenuBuilder.useNumbers].*/
infix inline fun OrderedMenuBuilder.useNumbers(lazy: () -> Boolean) = if(lazy()) useNumbers() else this

/**A lazy setter for [OrderedMenuBuilder.allowTextInput].*/
infix inline fun OrderedMenuBuilder.allowTextInput(lazy: () -> Boolean) = allowTextInput(lazy())

infix inline fun <reified T: ArrayList<OrderedChoice>> T.choice(lazy: OrderedChoice.() -> Unit) : T = with(OrderedChoice()) {
    lazy()
    add(this)
    return@with this@choice
}