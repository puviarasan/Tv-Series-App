package com.ek.tvseries.data.mappers

import com.ek.tvseries.data.remote.dto.SeasonDetailDto
import com.ek.tvseries.domain.model.SeasonDetailModel

fun SeasonDetailDto.toSeasonDetailModel() = SeasonDetailModel(
    posterPath = posterPath,
    episodeNumber = episodes.size.toString(),
    episodeDetails = episodes.map { it.toEpisodeModel() },
    name = name,
    crewDetails = episodes[0].crew.map { it.toCrewModel() },
    castDetails = episodes[0].guestStars.map { it.toCastDetail() }
)