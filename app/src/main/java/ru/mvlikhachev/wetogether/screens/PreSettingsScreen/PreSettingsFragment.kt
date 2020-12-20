package ru.mvlikhachev.wetogether.screens.PreSettingsScreen

import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_pre_settings.*
import ru.mvlikhachev.wetogether.R
import ru.mvlikhachev.wetogether.databinding.FragmentMainBinding
import ru.mvlikhachev.wetogether.databinding.FragmentPreSettingsBinding
import ru.mvlikhachev.wetogether.utils.APP_ACTIVITY
import ru.mvlikhachev.wetogether.utils.TYPE_ROOM
import java.text.SimpleDateFormat
import java.util.*


class PreSettingsFragment : Fragment() {

    private var _binding: FragmentPreSettingsBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: PreSettingsFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPreSettingsBinding.inflate(layoutInflater, container, false)

        // Inflate the layout for this fragment
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(PreSettingsFragmentViewModel::class.java)
        savePreSettingButton.setOnClickListener {
            mViewModel.initDatabase(TYPE_ROOM) {
                APP_ACTIVITY.mNavController.navigate(R.id.action_preSettingsFragment_to_mainFragment)
            }
        }
        setYourData()

    }

    private fun setYourData() {

        yourBirthdayDate.setOnClickListener {
            setYourBirthdayDate()
        }
        yourGender.setOnCheckedChangeListener { radioGroup, i ->
            if (yourGenderMan.isChecked) {
                setYourGender(0)
            } else if (yourGenderWoman.isChecked) {
                setYourGender(1)
            }
        }
    }

    private fun setYourGender(i: Int) {
        TODO("Not yet implemented")
    }


    fun setYourBirthdayDate(){
        var result = "01.01.01"
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_YEAR)

        val datePickerDialog = DatePickerDialog(APP_ACTIVITY, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
            result = "${mDay.toString()}.${mMonth.toString()}.${mYear.toString()}"
            yourBirthdayDate.text = result

        }, year, month, day)

        datePickerDialog.show()
    }


}

//val textView: TextView  = findViewById(R.id.textView_date)
//textView.text = SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis())
//
//var cal = Calendar.getInstance()
//
//val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
//    cal.set(Calendar.YEAR, year)
//    cal.set(Calendar.MONTH, monthOfYear)
//    cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//
//    val myFormat = "dd.MM.yyyy" // mention the format you need
//    val sdf = SimpleDateFormat(myFormat, Locale.US)
//    textView.text = sdf.format(cal.time)
//
//}
//
//textView.setOnClickListener {
//    DatePickerDialog(this@MainActivity, dateSetListener,
//        cal.get(Calendar.YEAR),
//        cal.get(Calendar.MONTH),
//        cal.get(Calendar.DAY_OF_MONTH)).show()
//}
//}

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