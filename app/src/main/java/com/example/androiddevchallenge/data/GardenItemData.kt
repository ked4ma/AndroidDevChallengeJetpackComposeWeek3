/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data

data class GardenItemData(val name: String, val thumbnail: String, val checked: Boolean = false) {
    companion object {
        val all = listOf(
            GardenItemData(
                "Monstera",
                "https://images.pexels.com/photos/3097770/pexels-photo-3097770.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260",
                true
            ),
            GardenItemData(
                "Aglaonema",
                "https://images.pexels.com/photos/4751978/pexels-photo-4751978.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
            ),
            GardenItemData(
                "Peace lily",
                "https://images.pexels.com/photos/4425201/pexels-photo-4425201.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
            ),
            GardenItemData(
                "Fiddle leaf",
                "https://images.pexels.com/photos/6208087/pexels-photo-6208087.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
            ),
            GardenItemData(
                "Snake plant",
                "https://images.pexels.com/photos/2123482/pexels-photo-2123482.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
            ),
            GardenItemData(
                "Pothos",
                "https://images.pexels.com/photos/1084199/pexels-photo-1084199.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
            ),
        )
    }
}
