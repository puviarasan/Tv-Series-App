package com.ek.tvseries.data.mappers

import com.ek.tvseries.data.remote.dto.GuestStar
import com.ek.tvseries.domain.model.CastDetails

fun GuestStar.toCastDetail() = CastDetails(
    name = originalName,
    profileImage = profilePath,
    job = character
)