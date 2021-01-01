package ru.mvlikhachev.wetogether.screens.PreSettingsScreen

import android.app.Application
import android.app.DatePickerDialog
import android.os.Build
import android.util.Log
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.mvlikhachev.wetogether.database.Room.AppRoomDatabase
import ru.mvlikhachev.wetogether.database.Room.AppRoomRepository
import ru.mvlikhachev.wetogether.model.AppPerson
import ru.mvlikhachev.wetogether.utils.APP_ACTIVITY
import ru.mvlikhachev.wetogether.utils.REPOSITORY
import ru.mvlikhachev.wetogether.utils.TYPE_ROOM
import java.text.SimpleDateFormat
import java.util.*

class PreSettingsFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext = application

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

        var isDbCreated = false
        when (type) {
            TYPE_ROOM -> {
                    isDbCreated = true
            }
        }
        Log.d("DBCHECK", "isDbCreated return $isDbCreated ")
        return isDbCreated
    }

}