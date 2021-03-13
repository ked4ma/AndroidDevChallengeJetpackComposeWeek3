package com.example.androiddevchallenge.data

data class ThemeItemData(
    val name: String,
    val thumbnail: String
) {
    companion object {
        val all = listOf(
            ThemeItemData(
                "Desert chic",
                "https://images.pexels.com/photos/2132227/pexels-photo-2132227.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
            ),
            ThemeItemData(
                "Tiny terrariums",
                "https://images.pexels.com/photos/1400375/pexels-photo-1400375.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
            ),
            ThemeItemData(
                "Jungle vibes",
                "https://images.pexels.com/photos/5699665/pexels-photo-5699665.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
            ),
            ThemeItemData(
                "Easy care",
                "https://images.pexels.com/photos/6208086/pexels-photo-6208086.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
            ),
            ThemeItemData(
                "Statements",
                "https://images.pexels.com/photos/3511755/pexels-photo-3511755.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
            ),
        )
    }
}
