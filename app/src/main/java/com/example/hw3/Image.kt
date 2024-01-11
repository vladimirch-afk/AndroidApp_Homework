package com.example.hw3


class Image(
    var name: String,
    var imageResource: Int
) {
    override fun toString(): String {
        return "$name, $imageResource"
    }
}

