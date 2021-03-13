package com.example.androiddevchallenge.data

data class GardenItemData(val name: String, val thumbnail: String) {
    companion object {
        val all = listOf(
            GardenItemData(
                "Monstera",
                "https://images.pexels.com/photos/3097770/pexels-photo-3097770.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260"
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