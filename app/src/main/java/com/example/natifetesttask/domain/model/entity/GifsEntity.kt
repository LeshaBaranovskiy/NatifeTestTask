package com.example.natifetesttask.domain.model.entity

data class GifsEntity(
    val data: List<Gif>,
    val pagination: GifPagination
)

data class Gif(
    val type: String,
    val id: String,
    val url: String,
    val title: String,
    val images: GifImage
)

data class GifPagination(
    val totalCount: Int
)

data class GifImage(
    val original: GifImageOriginal
)

data class GifImageOriginal(
    val url: String
)