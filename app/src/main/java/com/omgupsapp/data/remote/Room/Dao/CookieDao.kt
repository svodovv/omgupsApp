package com.omgupsapp.data.remote.Room.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.omgupsapp.data.remote.Room.Model.CookieEntity

@Dao
interface CookieDao {
    @Query("SELECT * FROM cookies WHERE host = :host")
    fun getCookiesForHost(host: String): List<CookieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCookie(cookie: CookieEntity)

}