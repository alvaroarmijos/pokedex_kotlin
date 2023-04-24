package com.example.pokedexkotlin.core.common.util

import android.widget.ImageView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load

fun ImageView.loadImage(imageUri: String, placeholder: Int? = null) {

    val imageLoader = ImageLoader.Builder(this.context)
        .componentRegistry { add(SvgDecoder(this@loadImage.context)) }
        .build()

    load(uri = imageUri, imageLoader = imageLoader) {
        crossfade(true)
    }
}