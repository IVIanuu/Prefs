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

package com.ivianuu.kprefs

import android.content.SharedPreferences
import kotlin.reflect.KClass

internal object BooleanAdapter : Pref.Adapter<Boolean> {
    override fun get(key: String, preferences: SharedPreferences): Boolean =
        preferences.getBoolean(key, RealKPrefs.DEFAULT_BOOLEAN)
    override fun set(key: String, value: Boolean, editor: SharedPreferences.Editor) {
        editor.putBoolean(key, value)
    }
}

internal class EnumAdapter<T : Enum<T>>(private val enumClass: KClass<T>) : Pref.Adapter<T> {
    override fun get(key: String, preferences: SharedPreferences): T =
        java.lang.Enum.valueOf(enumClass.java, preferences.getString(key, RealKPrefs.DEFAULT_STRING)!!)

    override fun set(key: String, value: T, editor: SharedPreferences.Editor) {
        editor.putString(key, value.name)
    }
}

internal object FloatAdapter : Pref.Adapter<Float> {
    override fun get(key: String, preferences: SharedPreferences): Float =
        preferences.getFloat(key, RealKPrefs.DEFAULT_FLOAT)
    override fun set(key: String, value: Float, editor: SharedPreferences.Editor) {
        editor.putFloat(key, value)
    }
}

internal object IntAdapter : Pref.Adapter<Int> {
    override fun get(key: String, preferences: SharedPreferences): Int =
        preferences.getInt(key, RealKPrefs.DEFAULT_INT)
    override fun set(key: String, value: Int, editor: SharedPreferences.Editor) {
        editor.putInt(key, value)
    }
}

internal object LongAdapter : Pref.Adapter<Long> {
    override fun get(key: String, preferences: SharedPreferences): Long =
        preferences.getLong(key, RealKPrefs.DEFAULT_LONG)
    override fun set(key: String, value: Long, editor: SharedPreferences.Editor) {
        editor.putLong(key, value)
    }
}

internal object StringAdapter : Pref.Adapter<String> {
    override fun get(key: String, preferences: SharedPreferences): String =
        preferences.getString(key, RealKPrefs.DEFAULT_STRING)!!
    override fun set(key: String, value: String, editor: SharedPreferences.Editor) {
        editor.putString(key, value)
    }
}

internal object StringSetAdapter : Pref.Adapter<Set<String>> {
    override fun get(key: String, preferences: SharedPreferences): Set<String> =
        preferences.getStringSet(key, RealKPrefs.DEFAULT_STRING_SET)!!
    override fun set(key: String, value: Set<String>, editor: SharedPreferences.Editor) {
        editor.putStringSet(key, value)
    }
}