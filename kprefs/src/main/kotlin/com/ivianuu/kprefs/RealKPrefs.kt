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

import android.annotation.SuppressLint
import android.content.SharedPreferences

internal class RealKPrefs(private val sharedPrefs: SharedPreferences) : KPrefs {

    private val listeners = ChangeListeners(sharedPrefs)

    override fun <T> pref(key: String, defaultValue: T, adapter: Pref.Adapter<T>): Pref<T> =
        RealPref(listeners, sharedPrefs, adapter, key, defaultValue)

    @SuppressLint("ApplySharedPref")
    override fun clear() {
        sharedPrefs.edit().clear().apply {
            if (KPrefsPlugins.useCommit) {
                commit()
            } else {
                apply()
            }
        }
    }
}