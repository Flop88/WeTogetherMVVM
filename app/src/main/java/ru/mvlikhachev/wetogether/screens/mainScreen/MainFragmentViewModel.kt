package ru.mvlikhachev.wetogether.screens.mainScreen

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.mvlikhachev.wetogether.utils.REPOSITORY
import java.lang.Appendable

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {

    fun loadData(id: Int) {
        viewModelScope.launch(Dispatchers.Main) {
            val user = REPOSITORY.getPersonById(id)
            Log.d("getById", "user id: ${user.id}")
            Log.d("getById", "user yourName: ${user.yourName}")
            Log.d("getById", "user yourBirthdayDate: ${user.yourBirthdayDate}")
            Log.d("getById", "user yourGender: ${user.yourGender}")
            Log.d("getById", " ")
            Log.d("getById", "user yourGender: ${user.partnerName}")
            Log.d("getById", "user yourGender: ${user.partnerBirthdayDate}")
            Log.d("getById", "user yourGender: ${user.partnerGender}")
            Log.d("getById", " ")
            Log.d("getById", "user yourGender: ${user.loveDate}")
        }
    }

}