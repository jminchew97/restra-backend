package io.github.jminchew97.routes

import io.github.jminchew97.config.PostgresConfig
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.github.jminchew97.models.Restaurant
import io.github.jminchew97.models.RestaurantId
import io.github.jminchew97.storage.InMemoryRestaurantStore
import java.util.UUID
fun Route.restaurantRouting(postgresConfig: PostgresConfig) {

    route("/restaurant") {
        val appApi: InMemoryRestaurantStore = InMemoryRestaurantStore()

        get {
            call.respond(appApi.getRestaurants())
        }
        get("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText( // if id null, respond with 'Bad request'
                "Bad request",
                status = HttpStatusCode.BadRequest
            )

            val restaurant = appApi.getRestaurant(RestaurantId(id))
            call.respond(
                if (restaurant == null) {
                    call.respond(
                        HttpStatusCode(
                            404,
                            "Resource not found"
                        )
                    )
                } else {
                    call.respond(restaurant)

                }
            )

        }
        post {
            val restaurantObj: Restaurant = call.receive<Restaurant>()
            println(restaurantObj)
            appApi.createRestaurant(restaurantObj)
            call.respondText("Restaurant created", status = HttpStatusCode.Created)
        }
        delete("{id?}") {
            val id = call.parameters["id"] ?: return@delete call.respondText(
                "Bad request",
                status = HttpStatusCode.BadRequest
            )
            if (appApi.deleteRestaurant(RestaurantId(id))) call.respond(HttpStatusCode(204, "Deleted resource"))

            call.respond(HttpStatusCode(404, "Resource not found"))
        }
    }
}