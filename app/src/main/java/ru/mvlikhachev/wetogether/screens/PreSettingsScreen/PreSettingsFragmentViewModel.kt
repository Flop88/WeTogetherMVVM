package ru.mvlikhachev.wetogether.screens.PreSettingsScreen

import android.app.Application
import android.app.DatePickerDialog
import android.os.Build
import android.util.Log
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import ru.mvlikhachev.wetogether.database.Room.AppRoomDatabase
import ru.mvlikhachev.wetogether.database.Room.AppRoomRepository
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

    private fun initDatePicker() {
        lateinit var textYourBirthday: TextView  // <---- ????
        textYourBirthday.text = SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis())

        var cal = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_YEAR, dayOfMonth)

            val myFormat = "dd.MM.yyy"
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            textYourBirthday.text = sdf.format(cal.time)
        }

        textYourBirthday.setOnClickListener {
            DatePickerDialog(
                APP_ACTIVITY, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }

    }

}