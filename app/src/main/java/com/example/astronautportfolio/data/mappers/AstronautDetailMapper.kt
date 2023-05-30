package com.example.astronautportfolio.data.mappers

import com.example.astronautportfolio.data.local.entity.detail.AstronautDetailEntity
import com.example.astronautportfolio.data.local.entity.detail.FlightEntity
import com.example.astronautportfolio.data.local.entity.detail.FlightStatusEntity
import com.example.astronautportfolio.data.local.entity.detail.LandingEntity
import com.example.astronautportfolio.data.local.entity.detail.MissionEntity
import com.example.astronautportfolio.data.local.entity.detail.OrbitEntity
import com.example.astronautportfolio.data.local.entity.detail.SpacecraftEntity
import com.example.astronautportfolio.data.local.entity.detail.SpacewalkEntity
import com.example.astronautportfolio.data.local.entity.detail.SpacecraftStatusEntity
import com.example.astronautportfolio.data.remote.details.AstronautDetailDto
import com.example.astronautportfolio.data.remote.details.FlightDto
import com.example.astronautportfolio.data.remote.details.FlightStatusDto
import com.example.astronautportfolio.data.remote.details.LandingDto
import com.example.astronautportfolio.data.remote.details.MissionDto
import com.example.astronautportfolio.data.remote.details.OrbitDto
import com.example.astronautportfolio.data.remote.details.SpacecraftDto
import com.example.astronautportfolio.data.remote.details.SpacewalkDto
import com.example.astronautportfolio.data.remote.details.SpacecraftStatusDto
import com.example.astronautportfolio.model.detail.AstronautDetail
import com.example.astronautportfolio.model.detail.Flight
import com.example.astronautportfolio.model.detail.FlightStatus
import com.example.astronautportfolio.model.detail.Landing
import com.example.astronautportfolio.model.detail.Mission
import com.example.astronautportfolio.model.detail.Orbit
import com.example.astronautportfolio.model.detail.Spacecraft
import com.example.astronautportfolio.model.detail.SpacecraftStatus
import com.example.astronautportfolio.model.detail.Spacewalk

class AstronautDetailMapper {

    fun mapAstronautDetailDtoToEntity(dto: AstronautDetailDto): AstronautDetailEntity{
        return AstronautDetailEntity (
            flights = dto.flights?.map { flightDto ->
                mapFlightsDtoToEntity(flightDto)
            },
            id = dto.id,
            landings = dto.landings?.map { landingDto ->
                mapLandingsDtoToEntity(landingDto)
            },
            spacewalks = dto.spacewalks?.map { spacewalkDto ->
                mapSpaceWalksDtoToEntity(spacewalkDto)
            }
        )
    }

    fun mapFlightsDtoToEntity(dto: FlightDto): FlightEntity {
        return FlightEntity(
            id = dto.id,
            image = dto.image,
            infographic = dto.infographic,
            mission = mapMissionDtoToEntity(dto.mission),
            name = dto.name,
            status = mapFlightStatusDtoToEntity(dto.status),
            url = dto.url
        )
    }

    fun mapLandingsDtoToEntity(dto: LandingDto): LandingEntity {
        return LandingEntity(
            destination = dto.destination,
            id = dto.id,
            missionEnd = dto.missionEnd,
            spacecraft = mapSpaceCraftDtoToEntity(dto.spacecraft),
            url = dto.url
        )
    }

    fun mapSpaceWalksDtoToEntity(dto: SpacewalkDto): SpacewalkEntity {
        return SpacewalkEntity(
            duration = dto.duration,
            end = dto.end,
            id = dto.id,
            location = dto.location,
            name = dto.name,
            start = dto.start,
            url = dto.url
        )

    }

    fun mapMissionDtoToEntity(dto: MissionDto): MissionEntity {
        return MissionEntity(
            description = dto.description,
            id = dto.id,
            name = dto.name,
            orbit = mapOrbitDtoToEntity(dto.orbit),
            type = dto.type
        )
    }

    fun mapFlightStatusDtoToEntity(dto: FlightStatusDto) : FlightStatusEntity {
        return FlightStatusEntity(
            abbrev = dto.abbrev,
            description = dto.description,
            id = dto.id,
            name = dto.name
        )
    }

    fun mapSpaceCraftDtoToEntity(dto: SpacecraftDto) : SpacecraftEntity {
        return SpacecraftEntity(
            description = dto.description,
            id = dto.id,
            name = dto.name,
            serialNumber = dto.serialNumber,
            status = mapSpaceCraftStatusDtoToEntity(dto.status),
            url = dto.url
        )
    }

    fun mapOrbitDtoToEntity(dto: OrbitDto) : OrbitEntity {
        return OrbitEntity(
            abbrev = dto.abbrev,
            id = dto.id,
            name = dto.name
        )
    }

    fun mapSpaceCraftStatusDtoToEntity (dto: SpacecraftStatusDto) : SpacecraftStatusEntity {
        return SpacecraftStatusEntity(
            id = dto.id,
            name = dto.name
        )
    }

    fun mapAstronautDetailEntityToModel(entity: AstronautDetailEntity): AstronautDetail {
        return AstronautDetail (
            flights = entity.flights?.map { flight ->
                mapFlightsEntityToModel(flight)
            },
            id = entity.id,
            landings = entity.landings?.map { landing ->
                mapLandingsEntityToModel(landing)
            },
            spacewalks = entity.spacewalks?.map { spacewalk ->
                mapSpaceWalksEntityToModel(spacewalk)
            }
        )
    }

    fun mapFlightsEntityToModel(entity: FlightEntity): Flight {
        return Flight(
            id = entity.id,
            image = entity.image,
            infographic = entity.infographic,
            mission = mapMissionEntityToModel(entity.mission),
            name = entity.name,
            status = mapFlightStatusEntityToModel(entity.status),
            url = entity.url
        )
    }

    fun mapLandingsEntityToModel(entity: LandingEntity): Landing {
        return Landing(
            destination = entity.destination,
            id = entity.id,
            missionEnd = entity.missionEnd,
            spacecraft = mapSpaceCraftEntityToModel(entity.spacecraft),
            url = entity.url
        )
    }

    fun mapSpaceWalksEntityToModel(entity: SpacewalkEntity): Spacewalk {
        return Spacewalk(
            duration = entity.duration,
            end = entity.end,
            id = entity.id,
            location = entity.location,
            name = entity.name,
            start = entity.start,
            url = entity.url
        )

    }

    fun mapMissionEntityToModel(entity: MissionEntity): Mission {
        return Mission(
            description = entity.description,
            id = entity.id,
            name = entity.name,
            orbit = mapOrbitEntityToModel(entity.orbit),
            type = entity.type
        )
    }

    fun mapFlightStatusEntityToModel(entity: FlightStatusEntity) : FlightStatus {
        return FlightStatus(
            abbrev = entity.abbrev,
            description = entity.description,
            id = entity.id,
            name = entity.name
        )
    }

    fun mapSpaceCraftEntityToModel(entity: SpacecraftEntity) : Spacecraft {
        return Spacecraft(
            description = entity.description,
            id = entity.id,
            name = entity.name,
            serialNumber = entity.serialNumber,
            status = mapSpaceCraftStatusEntityToModel(entity.status),
            url = entity.url
        )
    }

    fun mapOrbitEntityToModel(entity: OrbitEntity) : Orbit {
        return Orbit(
            abbrev = entity.abbrev,
            id = entity.id,
            name = entity.name
        )
    }

    fun mapSpaceCraftStatusEntityToModel (entity: SpacecraftStatusEntity) : SpacecraftStatus {
        return SpacecraftStatus(
            id = entity.id,
            name = entity.name
        )
    }
}

