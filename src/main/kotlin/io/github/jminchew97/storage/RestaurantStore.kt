package io.github.jminchew97.storage

import io.github.jminchew97.models.*

interface RestaurantStore {
    fun getRestaurants(): Collection<Restaurant>
    fun getRestaurant(id: RestaurantId): Restaurant?
    fun createRestaurant(restaurant: CreateRestaurant): Boolean
    fun deleteRestaurant(id: RestaurantId): Boolean
    fun updateRestaurant(updateRestaurant: UpdateRestaurant): Boolean
    fun getMenusFromRestaurant(restId: RestaurantId): Collection<Menu>
    fun getMenu(menuId: MenuId): Menu?
    fun createMenu(menu: CreateMenu): Boolean
    fun deleteMenu(restId: RestaurantId, menuId: MenuId): Boolean
    fun getAllMenus():Collection<Menu>
    fun updateMenu(newMenu: UpdateMenu): Boolean
    fun createItem(createItem: CreateItem):Boolean
    fun getItem(itemId:ItemId):Item?
    fun deleteItem(itemId:ItemId, restId: RestaurantId,menuId: MenuId):Boolean
    fun getAllItems(): Collection<Item>
    fun updateItem(updateItem: UpdateItem):Boolean
    fun getItemsByRestaurant(restaurantId: RestaurantId):Collection<Item>
    fun getItemsByMenu(menuId: MenuId): Collection<Item>

}
