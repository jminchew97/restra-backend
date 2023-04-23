package com.example.storage

import com.example.models.Restaurant
import com.example.models.RestaurantId

interface RestaurantStore {
    fun getRestaurants(): Collection<Restaurant>

    fun getRestaurant(id: RestaurantId) : Restaurant?

    fun createRestaurant(restaurant: Restaurant) : Boolean
    fun deleteRestaurant(id: RestaurantId): Boolean


}