package com.example.astronautportfolio.data.mappers

import com.example.astronautportfolio.data.local.entity.astronaut.AgencyEntity
import com.example.astronautportfolio.data.local.entity.astronaut.AstronautEntity
import com.example.astronautportfolio.data.local.entity.astronaut.FlightEntity
import com.example.astronautportfolio.data.local.entity.astronaut.LandingEntity
import com.example.astronautportfolio.data.local.entity.astronaut.SpacewalkEntity
import com.example.astronautportfolio.data.local.entity.astronaut.StatusEntity
import com.example.astronautportfolio.data.local.entity.astronaut.TypeEntity
import com.example.astronautportfolio.data.remote.dto.AgencyDto
import com.example.astronautportfolio.data.remote.dto.StatusDto
import com.example.astronautportfolio.data.remote.dto.TypeDto
import com.example.astronautportfolio.model.Agency
import com.example.astronautportfolio.model.Astronaut
import com.example.astronautportfolio.model.Status
import com.example.astronautportfolio.model.Type
import com.example.astronautportfolio.data.remote.dto.AstronautDto
import com.example.astronautportfolio.data.remote.dto.FlightDto
import com.example.astronautportfolio.data.remote.dto.LandingDto
import com.example.astronautportfolio.data.remote.dto.SpacewalkDto
import com.example.astronautportfolio.model.Flight
import com.example.astronautportfolio.model.Landing
import com.example.astronautportfolio.model.Spacewalk
import javax.inject.Inject

class AstronautMapper @Inject constructor() {
    fun mapAstronautDtoToEntity(dto: AstronautDto): AstronautEntity {
        return AstronautEntity(
            age = dto.age,
            agency = mapAgencyDtoToEntity(dto.agency),
            bio = dto.bio,
            dateOfBirth = dto.dateOfBirth,
            dateOfDeath = dto.dateOfDeath,
            firstFlight = dto.firstFlight,
            flightsCount = dto.flightsCount,
            id = dto.id,
            inSpace = dto.inSpace,
            instagram = dto.instagram,
            landingsCount = dto.landingsCount,
            lastFlight = dto.lastFlight,
            name = dto.name,
            nationality = dto.nationality,
            profileImage = dto.profileImage,
            profileImageThumbnail = dto.profileImageThumbnail,
            status = mapStatusDtoToEntity(dto.status),
            twitter = dto.twitter,
            type = mapTypeDtoToEntity(dto.type),
            url = dto.url,
            wiki = dto.wiki,
            flights = dto.flights?.map { flightDto ->
                mapFlightsDtoToEntity(flightDto)
            },
            landings = dto.landings?.map { landingDto ->
                mapLandingsDtoToEntity(landingDto)
            },
            spacewalks = dto.spacewalks?.map { spacewalkDto ->
                mapSpaceWalksDtoToEntity(spacewalkDto)
            }
        )
    }

    private fun mapAgencyDtoToEntity(dto: AgencyDto): AgencyEntity {
        return AgencyEntity(
            abbrev = dto.abbrev,
            administrator = dto.administrator,
            countryCode = dto.countryCode,
            description = dto.description,
            featured = dto.featured,
            foundingYear = dto.foundingYear,
            id = dto.id,
            imageUrl = dto.imageUrl,
            launchers = dto.launchers,
            logoUrl = dto.logoUrl,
            name = dto.name,
            parent = dto.parent,
            spacecraft = dto.spacecraft,
            type = dto.type,
            url = dto.url
        )
    }

    private fun mapStatusDtoToEntity(dto: StatusDto): StatusEntity {
        return StatusEntity(
            id = dto.id,
            name = dto.name
        )
    }

    private fun mapTypeDtoToEntity(dto: TypeDto): TypeEntity {
        return TypeEntity(
            id = dto.id,
            name = dto.name
        )
    }

    fun mapAstronautEntityToAstronaut(entity: AstronautEntity): Astronaut {
        return Astronaut(
            age = entity.age,
            agency = mapAgencyEntityToAgency(entity.agency),
            bio = entity.bio,
            dateOfBirth = entity.dateOfBirth,
            dateOfDeath = entity.dateOfDeath,
            firstFlight = entity.firstFlight,
            flightsCount = entity.flightsCount,
            id = entity.id,
            inSpace = entity.inSpace,
            instagram = entity.instagram,
            landingsCount = entity.landingsCount,
            lastFlight = entity.lastFlight,
            name = entity.name,
            nationality = entity.nationality,
            profileImage = entity.profileImage,
            profileImageThumbnail = entity.profileImageThumbnail,
            status = mapStatusEntityToStatus(entity.status),
            twitter = entity.twitter,
            type = mapTypeEntityToType(entity.type),
            url = entity.url,
            wiki = entity.wiki,
            flights = entity.flights?.map { flight ->
                mapFlightsEntityToModel(flight)
            },
            landings = entity.landings?.map { landing ->
                mapLandingsEntityToModel(landing)
            },
            spacewalks = entity.spacewalks?.map { spacewalk ->
                mapSpaceWalksEntityToModel(spacewalk)
            }
        )
    }

    private fun mapAgencyEntityToAgency(entity: AgencyEntity): Agency {
        return Agency(
            abbrev = entity.abbrev,
            administrator = entity.administrator,
            countryCode = entity.countryCode,
            description = entity.description,
            featured = entity.featured,
            foundingYear = entity.foundingYear,
            id = entity.id,
            imageUrl = entity.imageUrl,
            launchers = entity.launchers,
            logoUrl = entity.logoUrl,
            name = entity.name,
            parent = entity.parent,
            spacecraft = entity.spacecraft,
            type = entity.type,
            url = entity.url
        )
    }

    private fun mapStatusEntityToStatus(entity: StatusEntity): Status {
        return Status(
            id = entity.id,
            name = entity.name
        )
    }

    private fun mapTypeEntityToType(dto: TypeEntity): Type {
        return Type(
            id = dto.id,
            name = dto.name
        )
    }

    //// Astronaut Detail Mapper

    fun mapFlightsDtoToEntity(dto: FlightDto): FlightEntity {
        return FlightEntity(
            id = dto.id,
            image = dto.image,
            infographic = dto.infographic,
            name = dto.name,
            url = dto.url
        )
    }

    fun mapLandingsDtoToEntity(dto: LandingDto): LandingEntity {
        return LandingEntity(
            destination = dto.destination,
            id = dto.id,
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

    /// Astronaut Detail Mapper

    fun mapFlightsEntityToModel(entity: FlightEntity): Flight {
        return Flight(
            id = entity.id,
            image = entity.image,
            infographic = entity.infographic,
            name = entity.name,
            url = entity.url
        )
    }

    fun mapLandingsEntityToModel(entity: LandingEntity): Landing {
        return Landing(
            destination = entity.destination,
            id = entity.id,
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

}