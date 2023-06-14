package com.example.astronautportfolio.data.local.entity.astronaut

import com.example.astronautportfolio.model.Agency
import com.example.astronautportfolio.model.Astronaut
import com.example.astronautportfolio.model.Flight
import com.example.astronautportfolio.model.Landing
import com.example.astronautportfolio.model.Spacewalk
import com.example.astronautportfolio.model.Status
import com.example.astronautportfolio.model.Type

val FakeAstronautData = Astronaut(
    age = 45,
    agency = Agency(
        abbrev = "ESA",
        administrator = "Director General: Josef Aschbacher",
        countryCode = "AUT,BEL,CZE,DNK,FIN,FRA,DEU,GRC,IRE,ITA,LUZ,NLD,NOR,POL,PRT,ROU,ESP,SWE,CHE,GBR",
        description = "The European Space Agency is an intergovernmental organisation of 22 member states. Established in 1975 and headquartered in Paris, France, ESA has a worldwide staff of about 2,000 employees.\r\n\r\nESA's space flight programme includes human spaceflight (mainly through participation in the International Space Station program); the launch and operation of unmanned exploration missions to other planets and the Moon; Earth observation, science and telecommunication; designing launch vehicles; and maintaining a major spaceport, the Guiana Space Centre at Kourou, French Guiana.",
        featured = false,
        foundingYear = "1975",
        id = 27,
        imageUrl = null,
        launchers = null,
        logoUrl =  "https://spacelaunchnow-prod-east.nyc3.digitaloceanspaces.com/media/logo/european2520space2520agency_logo_20221130101442.png",
        name = "European Space Agency",
        parent = null,
        spacecraft = null,
        type = "Multinational",
        url = "https://ll.thespacedevs.com/2.2.0/agencies/27/"
    ),
    bio =  "Thomas Gautier Pesquet is a French aerospace engineer, pilot, and European Space Agency astronaut. Pesquet was selected by ESA as a candidate in May 2009, and he successfully completed his basic training in November 2010. From November 2016 to June 2017, Pesquet was part of Expeditions 50 and 51 on the International Space Station as a flight engineer.",
    dateOfBirth =  "1978-02-27",
    dateOfDeath = null,
    firstFlight = "2016-11-17T20:20:13Z",
    flightsCount = 2,
    id = 1,
    inSpace = false,
    instagram = "https://instagram.com/thom_astro",
    landingsCount = 2,
    lastFlight = "2021-04-23T09:49:02Z",
    name = "Thomas Pesquet",
    nationality = "French",
    profileImage = "https://spacelaunchnow-prod-east.nyc3.digitaloceanspaces.com/media/astronaut_images/thomas2520pesquet_image_20200102120546.jpeg",
    profileImageThumbnail = "https://spacelaunchnow-prod-east.nyc3.digitaloceanspaces.com/media/astronaut_images/thomas_pesquet_thumbnail_20220911033657.jpeg",
    status = Status(
        id = 1,
        name = "Active"
    ),
    twitter = "https://twitter.com/Thom_astro",
    type = Type(
        id = 2,
        name = "Government"
    ),
    url = "https://ll.thespacedevs.com/2.2.0/astronaut/1/",
    wiki = "https://en.wikipedia.org/wiki/Thomas_Pesquet",
    flights = List(size = 2){
        Flight(
            id = "32dcb5ad-7609-4fc0-8094-768ee5c2ebe0",
            image = "https://spacelaunchnow-prod-east.nyc3.digitaloceanspaces.com/media/launch_images/falcon2520925_image_20210417111946.jpeg",
            infographic = "https://spacelaunchnow-prod-east.nyc3.digitaloceanspaces.com/media/launch_images/falcon2520925_infographic_20210402174019.jpeg",
            name = "Falcon 9 Block 5 | Crew-2",
            url = "https://ll.thespacedevs.com/2.2.0/launch/32dcb5ad-7609-4fc0-8094-768ee5c2ebe0/"
        )
    },
    landings = List(size = 2) {
      Landing(
          destination = "International Space Station",
          id = 579,
          url = "https://ll.thespacedevs.com/2.2.0/spacecraft/flight/579/"
      )
    },
    spacewalks = List(size = 2) {
        Spacewalk(
            duration = "PT6H54M",
            end = "2021-09-12T19:09:00Z",
            id = 431,
            location = "International Space Station",
            name = "Expedition 65 EVA 7",
            start = "2021-09-12T12:15:00Z",
            url = "https://ll.thespacedevs.com/2.2.0/spacewalks/431/"
        )
    },
)