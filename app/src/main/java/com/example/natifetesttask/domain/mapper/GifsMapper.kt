package com.example.natifetesttask.domain.mapper

import com.example.natifetesttask.data.dto.GifsEntityResponse
import com.example.natifetesttask.domain.model.entity.GifsEntity

interface GifsMapper {
    fun mapGifsResponseToEntity(gifsEntityResponse: GifsEntityResponse): GifsEntity
}