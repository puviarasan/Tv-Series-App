package com.ek.tvseries.domain.model

data class SeasonDetailModel(
    val posterPath: String?,
    val episodeNumber: String?,
    val name: String?,
    val episodeDetails: List<EpisodeDetailModel>,
    val crewDetails: List<CastDetails>,
    val castDetails: List<CastDetails>
)
data class EpisodeDetailModel(
    val name: String,
    val episodeNumber: String?,
    val episodeImageUrl: String?
)
