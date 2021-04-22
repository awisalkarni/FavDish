package com.example.favdish.model.database

import androidx.room.*
import com.example.favdish.model.entities.FavDish
import kotlinx.coroutines.flow.Flow


@Dao
interface FavDishDao {

    @Insert
    suspend fun insertFavDishDetails(favDish: FavDish)

    @Query("SELECT * FROM fav_dishes_table ORDER BY ID")
    fun getAllDishesList(): Flow<List<FavDish>>

    @Query("SELECT * FROM fav_dishes_table where type = :filterType")
    fun getFilteredDishesList(filterType: String): Flow<List<FavDish>>

    @Update
    suspend fun updateFaveDishDetails(favDish: FavDish)

    @Query("select * from fav_dishes_table where favorite_dish = 1")
    fun getFavoriteDishesList(): Flow<List<FavDish>>

    @Delete
    suspend fun deleteFavoriteDish(favDish: FavDish)

}