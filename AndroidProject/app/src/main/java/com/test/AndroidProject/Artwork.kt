package com.test.AndroidProject


import java.io.Serializable

data class Artwork(
    val title: String,
    val artist: String,
    val category: String,
    val description: String
) : Serializable
