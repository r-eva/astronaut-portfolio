package com.example.astronautportfolio.data.local.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.PrimaryKey
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.astronautportfolio.data.local.database.AstronautDatabase
import com.example.astronautportfolio.data.local.entity.astronaut.AgencyEntity
import com.example.astronautportfolio.data.local.entity.astronaut.AstronautEntity
import com.example.astronautportfolio.data.local.entity.astronaut.LandingEntity
import com.example.astronautportfolio.data.local.entity.astronaut.SpacewalkEntity
import com.example.astronautportfolio.data.local.entity.astronaut.StatusEntity
import com.example.astronautportfolio.data.local.entity.astronaut.TypeEntity
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class AstronautDaoTest {

    /*@get: Rule
  var instantTaskExecutorRule = InstantTaskExecutorRule()


  private lateinit var database: AstronautDatabase
  private lateinit var dao: AstronautDao

  @Before
  fun setup() {
      database = Room.inMemoryDatabaseBuilder(
          ApplicationProvider.getApplicationContext(),
          AstronautDatabase::class.java
      ).allowMainThreadQueries().build()
      dao = database.astronautDao()
  }

  @After
  fun tearDown() {
      database.close()
  }

  @Test
  fun upserAll() = runBlocking {
      val astronautEntity = List(size = 2){
          AstronautEntity(
          age = 45,
          agency = AgencyEntity(
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
          id = "$it".toInt(),
          inSpace = false,
          instagram = "https://instagram.com/thom_astro",
          landingsCount = 2,
          lastFlight = "2021-04-23T09:49:02Z",
          name = "Thomas Pesquet",
          nationality = "French",
          profileImage = "https://spacelaunchnow-prod-east.nyc3.digitaloceanspaces.com/media/astronaut_images/thomas2520pesquet_image_20200102120546.jpeg",
          profileImageThumbnail = "https://spacelaunchnow-prod-east.nyc3.digitaloceanspaces.com/media/astronaut_images/thomas_pesquet_thumbnail_20220911033657.jpeg",
          status = StatusEntity(
              id = 1,
              name = "Active"
          ),
          twitter = "https://twitter.com/Thom_astro",
          type = TypeEntity(
              id = 2,
              name = "Government"
          ),
          url = "https://ll.thespacedevs.com/2.2.0/astronaut/1/",
          wiki = "https://en.wikipedia.org/wiki/Thomas_Pesquet",
          flights = null,
          landings = null,
          spacewalks = null
      )}
      dao.upsertAll(astronautEntity)
      val allAstronautEntity = dao.getAllAstronautFromDb()
      assertThat(allAstronautEntity).contains(astronautEntity)
  }*/
}