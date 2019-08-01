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

package com.ivianuu.kprefs.coroutines

import com.ivianuu.kprefs.ChangeListener
import com.ivianuu.kprefs.Pref
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

/**
 * Returns a [Flow] which emits the latest value
 */
@FlowPreview
fun <T> Pref<T>.asFlow(): Flow<T> = callbackFlow {
    val listener: ChangeListener<T> = { offer(it) }
    addListener(listener)
    awaitClose { removeListener(listener) }
}