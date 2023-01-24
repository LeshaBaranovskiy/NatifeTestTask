package com.example.natifetesttask.data.dto

import com.google.gson.annotations.SerializedName

data class GifsEntityResponse(
    @SerializedName("data")
    val data: List<GifEntity>,
    @SerializedName("pagination")
    val pagination: GitPaginationEntity
)

data class GifEntity(
    @SerializedName("type")
    val type: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("images")
    val images: GifImageEntity
)

data class GifImageEntity(
    @SerializedName("original")
    val original: GifImageOriginalEntity
)

data class GitPaginationEntity(
    @SerializedName("total_count")
    val totalCount: Int
)

data class GifImageOriginalEntity(
    @SerializedName("url")
    val url: String
)