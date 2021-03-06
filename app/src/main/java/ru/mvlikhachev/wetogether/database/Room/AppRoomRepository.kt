package ru.mvlikhachev.wetogether.database.Room

import android.app.Person
import androidx.lifecycle.LiveData
import ru.mvlikhachev.wetogether.database.DatabaseRepository
import ru.mvlikhachev.wetogether.model.AppPerson

class AppRoomRepository(private val appRoomDao: AppRoomDao) : DatabaseRepository {

    override val allNotes: LiveData<List<AppPerson>>
        get() = appRoomDao.getAllPersons()

    override suspend fun getPersonById(id: Int): LiveData<AppPerson> {
        val person = appRoomDao.getById(id)
        return person
    }

    override suspend fun insert(person: AppPerson, onSuccess: () -> Unit) {
        appRoomDao.insert(person)
        onSuccess()
    }

    override suspend fun delete(person: AppPerson, onSuccess: () -> Unit) {
        appRoomDao.delete(person)
        onSuccess()
    }

    override val isDBExists: Boolean
        get() = appRoomDao.isExists()


}