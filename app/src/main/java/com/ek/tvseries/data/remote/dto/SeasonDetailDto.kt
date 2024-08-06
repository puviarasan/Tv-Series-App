package com.ek.tvseries.data.remote.dto


import com.ek.tvseries.domain.model.SeasonDetailModel
import com.google.gson.annotations.SerializedName

data class SeasonDetailDto(
    @SerializedName("air_date")
    val airDate: String,
    @SerializedName("episodes")
    val episodes: List<Episode>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("season_number")
    val seasonNumber: Int,
    @SerializedName("vote_average")
    val voteAverage: Double
)

fun SeasonDetailDto.toSeasonDetailModel() = SeasonDetailModel(
    posterPath = posterPath,
    episodeNumber = episodes.size.toString(),
    episodeDetails = episodes.map { it.toEpisodeModel() },
    name = name,
    crewDetails = episodes[0].crew.map { it.toCrewModel() },
    castDetails = episodes[0].guestStars.map { it.toCastDetail() }
)
