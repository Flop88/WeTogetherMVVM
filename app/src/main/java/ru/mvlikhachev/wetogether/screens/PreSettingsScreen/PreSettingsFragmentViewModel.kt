package ru.mvlikhachev.wetogether.screens.PreSettingsScreen

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.mvlikhachev.wetogether.database.Room.AppRoomDatabase
import ru.mvlikhachev.wetogether.database.Room.AppRoomRepository
import ru.mvlikhachev.wetogether.model.AppPerson
import ru.mvlikhachev.wetogether.utils.REPOSITORY
import ru.mvlikhachev.wetogether.utils.TYPE_ROOM

class PreSettingsFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext = application
    lateinit var readUserData: LiveData<List<AppPerson>>

    fun initDatabase(type: String, onSuccess:() -> Unit) {
        when(type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }
        }
    }
    fun insert(appPerson: AppPerson, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.Main) {
            REPOSITORY.insert(appPerson) {
                onSuccess()
            }
        }
    fun isDatabaseExist(type: String) : Boolean {
        val db = AppRoomDatabase.getInstance(mContext)
        var database:AppRoomDatabase?=null
        val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()

        REPOSITORY = AppRoomRepository(dao)
        readUserData  = REPOSITORY.allNotes

        var isDbCreated = false
        when (type) {
            TYPE_ROOM -> {
                    isDbCreated = false
                    Log.d("DBCHECK", "db is ${db} ")
                    Log.d("DBCHECK", "readUserData is ${readUserData.observeForever { 
                        
                    }} ")
                    Log.d("DBCHECK", "isDbCreated is $isDbCreated ")
            }
        }
        Log.d("DBCHECK", "isDbCreated return $isDbCreated ")
        return isDbCreated
    }

}