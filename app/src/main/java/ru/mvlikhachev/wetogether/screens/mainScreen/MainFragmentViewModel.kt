package ru.mvlikhachev.wetogether.screens.mainScreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import ru.mvlikhachev.wetogether.model.AppPerson
import ru.mvlikhachev.wetogether.utils.REPOSITORY

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {

     val readUserData: LiveData<List<AppPerson>> = REPOSITORY.allNotes

}