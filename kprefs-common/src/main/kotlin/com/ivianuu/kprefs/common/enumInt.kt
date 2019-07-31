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

import android.content.SharedPreferences
import com.ivianuu.kprefs.KPrefs
import com.ivianuu.kprefs.Pref
import kotlin.reflect.KClass

/**
 * Returns a [Pref] which is represented a an [T] but persisted as an [Int]
 */
inline fun <reified T> KPrefs.enumInt(
    key: String,
    defaultValue: T
): Pref<T> where T : Enum<T>, T : PrefValueHolder<Int> =
    enumInt(key, defaultValue, T::class)

/**
 * Returns a [Pref] which is represented a an [T] but persisted as an [Int]
 */
fun <T> KPrefs.enumInt(
    key: String,
    defaultValue: T,
    type: KClass<T>
): Pref<T> where T : Enum<T>, T : PrefValueHolder<Int> =
    pref(key, defaultValue, EnumIntPrefAdapter(type, defaultValue))

private class EnumIntPrefAdapter<T>(
    private val type: KClass<T>,
    private val defaultValue: T
) : Pref.Adapter<T> where T : Enum<T>, T : PrefValueHolder<Int> {
    override fun get(key: String, preferences: SharedPreferences): T =
        type.valueFor(preferences.getInt(key, 0), defaultValue)

    override fun set(key: String, value: T, editor: SharedPreferences.Editor) {
        editor.putInt(key, value.value)
    }
}