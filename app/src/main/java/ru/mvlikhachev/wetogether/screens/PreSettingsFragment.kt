package ru.mvlikhachev.wetogether.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.mvlikhachev.wetogether.R


class PreSettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pre_settings, container, false)
    }
}

//public void onGenderButtonClicked(View view) {
//    if(feButton.isPressed()){
//        maButton.setEnabled(false);
//        radioPressed = true;
//    } else if (maButton.isPressed()){
//        feButton.setEnabled(false);
//        radioPressed = true;
//    } else {
//        radioPressed = false;
//    }
//}