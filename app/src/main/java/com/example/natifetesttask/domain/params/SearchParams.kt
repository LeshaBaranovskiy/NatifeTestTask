package com.example.natifetesttask.domain.params

data class SearchParams(
    val query: String,
    val limit: Int,
    val offset: Int
)
