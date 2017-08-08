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
package me.kgustave.kjdautils.menu

import com.jagrosh.jdautilities.menu.pagination.PaginatorBuilder
import net.dv8tion.jda.core.entities.Message
import java.awt.Color

infix fun PaginatorBuilder.finalAction(lazy: (Message) -> Unit) = setFinalAction(lazy)!!

infix fun PaginatorBuilder.colorBiFunction(lazy: (Int, Int) -> Color?) = setColor(lazy)!!

infix fun PaginatorBuilder.text(lazy: (Int, Int) -> String?) = setText(lazy)!!

infix inline fun PaginatorBuilder.items(lazy: ArrayList<String>.() -> Unit) = setItems(*with(ArrayList<String>()){lazy(); this}.toTypedArray())!!

infix inline fun PaginatorBuilder.add(lazy: () -> String) = addItems(lazy())!!

infix inline fun PaginatorBuilder.columns(lazy: () -> Int) = setColumns(lazy())!!

infix inline fun PaginatorBuilder.text(lazy: () -> String?) = setText(lazy())!!

infix inline fun PaginatorBuilder.waitOnSinglePage(lazy: () -> Boolean) = waitOnSinglePage(lazy())!!

infix inline fun PaginatorBuilder.itemsPerPage(lazy: () -> Int) = setItemsPerPage(lazy())!!

infix inline fun PaginatorBuilder.showPageNumbers(lazy: () -> Boolean) = showPageNumbers(lazy())!!

infix inline fun PaginatorBuilder.useNumberedItems(lazy: () -> Boolean) = useNumberedItems(lazy())!!
