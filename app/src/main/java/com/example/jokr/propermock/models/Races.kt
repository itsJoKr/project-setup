package com.example.jokr.propermock.models

import com.google.gson.annotations.SerializedName
import retrofit2.Response

typealias Races = List<Race>

class Race(
    @SerializedName("country") val country: String?,
    @SerializedName("raceDate") val raceDate: String?,
    @SerializedName("qualifyingRecordDriver") val qualifyingRecordDrivers: Driver?,
    @SerializedName("description") val description: String?,
    @SerializedName("images") val images: List<Image>?,
    @SerializedName("circuitId") val circuitId: String?,
    @SerializedName("raceDistance") val raceDistance: Int?,
    @SerializedName("circuitName") val circuitName: String?,
    @SerializedName("lapRecordDriver") val lapRecordDriver: Driver?,
    @SerializedName("circuitPermiter") val circuitPermiter: Int?,
    @SerializedName("circuitTurns") val circuitTurns: Int?,
    @SerializedName("raceId") val raceId: String?,
    @SerializedName("hasRaceResults") val hasRaceResults: Boolean?,
    @SerializedName("pastWinners") val pastWinners: List<Driver>?,
    @SerializedName("sequence") val sequence: Int?,
    @SerializedName("raceName") val raceName: String?,
    @SerializedName("lapRecordTime") val lapRecordTime: String?,
    @SerializedName("city") val city: String?,
    @SerializedName("hasSessionResults") val hasSessionResults: Boolean?,
    @SerializedName("scheduledLaps") val scheduledLaps: Int?,
    @SerializedName("qualifyingRecordTime") val qualifyingRecordTime: String?,
    @SerializedName("raceFlag") val raceFlag: Image?,
    @SerializedName("raceCode") val raceCode: String?,
    @SerializedName("raceResultUrl") val raceResultUrl: String?,
    @SerializedName("ticketUrl") val ticketUrl: String?,
    @SerializedName("activeRace") val activeRace: Boolean?,
    @SerializedName("raceTrackImage") val raceTrackImage: Image?,
    @SerializedName("raceSponsorImage") val raceSponsorImage: Image?
)


data class Image(
    @SerializedName("title") val title: String?,
    @SerializedName("url") val url: String?,
    @SerializedName("appImageType") val type: Int?
)


data class Driver(
    @SerializedName("activeDriver") val active: Boolean?,
    @SerializedName("audioFeed") val audioFeed: String?,
    @SerializedName("raceStarts") val raceStarts: Int?,
    @SerializedName("lastName") val lastName: String?,
    @SerializedName("fastestLaps") val fastestLaps: Int?,
    @SerializedName("firstStartDate") val firstStartDate: String?,
    @SerializedName("images") val images: List<Image>?,
    @SerializedName("firstStartId") val firstStartId: String?,
    @SerializedName("biography") val biography: String?,
    @SerializedName("podiums") val podiums: Int?,
    @SerializedName("ledKm") val ledKm: Int?,
    @SerializedName("racedKm") val racedKm: Int?,
    @SerializedName("birthPlace") val birthPlace: String?,
    @SerializedName("nationality") val nationality: String?,
    @SerializedName("ledRaces") val ledRaces: Int?,
    @SerializedName("ledLaps") val ledLaps: Int?,
    @SerializedName("driverId") val driverId: String?,
    @SerializedName("racedLaps") val racedLaps: Int?,
    @SerializedName("birthDate") val birthDate: String?,
    @SerializedName("frontRows") val frontRows: Int?,
    @SerializedName("driverNameShort") val driverNameShort: String?,
    @SerializedName("country") val country: String?,
    @SerializedName("firstStart") val firstStart: String?,
    @SerializedName("firstName") val firstName: String?,
    @SerializedName("totalPoints") val totalPoints: Int?,
    @SerializedName("driverName") val driverName: String?,
    @SerializedName("poles") val poles: Int?,
    @SerializedName("driverFullStatsUrl") val driverFullStatsUrl: String?,
    @SerializedName("fanBoostVoting") val fanBoostVoting: Boolean?,
    @SerializedName("position") val position: Int?,
    @SerializedName("points") val points: Int?,
    @SerializedName("teamName") val teamName: String?,
    @SerializedName("wins") val wins: Int?
)