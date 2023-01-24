package com.example.natifetesttask.domain.mapper

import com.example.natifetesttask.data.dto.GifsEntityResponse
import com.example.natifetesttask.domain.model.entity.*

class GifsMapperImpl: GifsMapper {
    override fun mapGifsResponseToEntity(gifsEntityResponse: GifsEntityResponse): GifsEntity {
        with(gifsEntityResponse) {
            val gifs = GifsEntity(data.map {
                Gif(
                    it.type,
                    it.id,
                    it.url,
                    it.title,
                    GifImage(
                        GifImageOriginal(it.images.original.url)
                    )
                )
            },
            GifPagination(
                gifsEntityResponse.pagination.totalCount
            ))
            return gifs
        }
    }
}