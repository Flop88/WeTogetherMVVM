package ru.mvlikhachev.wetogether.database.Room

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.mvlikhachev.wetogether.model.AppPerson

@Dao
interface AppRoomDao {

    @Query("SELECT * FROM person_tables")
    fun getAllPersons() : LiveData<List<AppPerson>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(appPerson: AppPerson)

    @Delete
    suspend fun delete(appPerson: AppPerson)

    @Update
    suspend fun update(appPerson: AppPerson)
}