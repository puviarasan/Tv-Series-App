package com.ek.tvseries.data.mappers

import com.ek.tvseries.data.remote.dto.Episode
import com.ek.tvseries.domain.model.EpisodeDetailModel

fun Episode.toEpisodeModel() = EpisodeDetailModel(
    name = name,
    episodeNumber = episodeNumber.toString(),
    episodeImageUrl = stillPath
)