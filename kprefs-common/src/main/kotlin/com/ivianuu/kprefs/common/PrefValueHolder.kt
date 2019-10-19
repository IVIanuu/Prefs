/*
 * Copyright 2018 Manuel Wrage
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ivianuu.kprefs.common

import kotlin.reflect.KClass

interface PrefValueHolder<T> {
    val value: T
}

fun <T, V> KClass<T>.valueFor(
    value: V,
    defaultValue: T
): T where T : Enum<T>, T : PrefValueHolder<V> =
    java.enumConstants!!.firstOrNull { it.value == value } ?: defaultValue

fun <T, V> KClass<T>.valueForOrNull(value: V): T? where T : Enum<T>, T : PrefValueHolder<V> =
    java.enumConstants!!.firstOrNull { it.value == value }