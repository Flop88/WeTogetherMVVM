package ru.mvlikhachev.wetogether.database

import androidx.lifecycle.LiveData
import ru.mvlikhachev.wetogether.model.AppPerson

interface DatabaseRepository {

    val allNotes: LiveData<List<AppPerson>>

    suspend fun getPersonById(id: Int) : LiveData<AppPerson>

    suspend fun insert(person: AppPerson, onSuccess:() -> Unit)
    suspend fun delete(person: AppPerson, onSuccess:() -> Unit)

}