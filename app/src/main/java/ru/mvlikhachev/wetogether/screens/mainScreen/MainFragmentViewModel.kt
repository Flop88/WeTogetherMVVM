package ru.mvlikhachev.wetogether.screens.mainScreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ru.mvlikhachev.wetogether.utils.REPOSITORY
import java.lang.Appendable

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {

    fun loadData() {
        val user = REPOSITORY.allNotes
    }

}