package ru.mvlikhachev.wetogether.database.Room

import android.app.Person
import androidx.lifecycle.LiveData
import androidx.room.*
import ru.mvlikhachev.wetogether.model.AppPerson

@Dao
interface AppRoomDao {

    @Query("SELECT * FROM person_tables")
    fun getAllPersons() : LiveData<List<AppPerson>>

    @Query("SELECT * FROM person_tables WHERE id = :id")
    fun getById(id: Int) : LiveData<AppPerson>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: AppPerson)

    @Delete
    suspend fun delete(note: AppPerson)
}