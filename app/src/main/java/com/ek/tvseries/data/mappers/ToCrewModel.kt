package com.ek.tvseries.data.mappers

import com.ek.tvseries.data.remote.dto.Crew
import com.ek.tvseries.domain.model.CastDetails

fun Crew.toCrewModel() = CastDetails(
    name = originalName,
    profileImage = profilePath,
    job = job
)