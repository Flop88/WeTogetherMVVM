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
import ru.mvlikhachev.wetogether.database.Room.AppRoomDatabase
import ru.mvlikhachev.wetogether.databinding.FragmentMainBinding
import ru.mvlikhachev.wetogether.databinding.FragmentPreSettingsBinding
import ru.mvlikhachev.wetogether.model.AppPerson
import ru.mvlikhachev.wetogether.utils.APP_ACTIVITY
import ru.mvlikhachev.wetogether.utils.TYPE_ROOM
import java.text.SimpleDateFormat
import java.util.*


class PreSettingsFragment : Fragment() {

    private var _binding: FragmentPreSettingsBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: PreSettingsFragmentViewModel

    private lateinit var yourNameText: String
    private lateinit var yourBirthdayDateText: String
    private lateinit var yourGenderText: String
    private lateinit var partnerNameText: String
    private lateinit var partnerBirthdayText: String
    private lateinit var partnerGenderText: String
    private lateinit var loveDayText: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPreSettingsBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun checkStart() {
        if (mViewModel.isDatabaseExist(TYPE_ROOM)) {
            Log.d("DBCHECK", "DB is Created")
            APP_ACTIVITY.mNavController.navigate(R.id.action_preSettingsFragment_to_mainFragment)
        } else {
            Log.d("DBCHECK", "DB is not Created")
        }
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(PreSettingsFragmentViewModel::class.java)

        checkStart()

        mViewModel.initDatabase(TYPE_ROOM) {

            savePreSettingButton.setOnClickListener {

                setYourData()
                setPartnerData()
                setLoveDate()

                mViewModel.insert(AppPerson(yourName = yourNameText, yourBirthdayDate = yourBirthdayDateText,
                yourGender = yourGenderText, partnerName = partnerNameText, partnerBirthdayDate = partnerBirthdayText,
                partnerGender = partnerGenderText, loveDate = loveDayText)) {
                    APP_ACTIVITY.mNavController.navigate(R.id.action_preSettingsFragment_to_mainFragment)
                }

                Log.d("getAllData", "Name: $yourNameText")
                Log.d("getAllData", "Birthday: $yourBirthdayDateText")
                Log.d("getAllData", "Your gender: $yourGenderText")
                Log.d("getAllData", "Partner name: $partnerNameText")
                Log.d("getAllData", "Partner birdthday: $partnerBirthdayText")
                Log.d("getAllData", "Partner gender: $partnerGenderText")
                Log.d("getAllData", "Love Dater: $loveDayText")
            }

            yourNameText = textInputYourName.editText?.text.toString().trim()
            yourBirthdayDateText = yourBirthdayDate.text.toString().trim()
            yourGenderText = "Unknown"

            partnerNameText = textInputLoveName.editText?.getText().toString().trim()
            partnerBirthdayText = partnerBirthdayDate.text.toString().trim()
            partnerGenderText = "Unknown"

            setYourData()
            setPartnerData()
            setLoveDate()
        }
    }

    private fun setYourData() {

        yourNameText = textInputYourName.editText?.text.toString().trim()
        yourBirthdayDateText = yourBirthdayDate.text.toString().trim()
        yourBirthdayDate.setOnClickListener {
            setDate(yourBirthdayDate)
            yourBirthdayDateText = yourBirthdayDate.text.toString().trim()
        }
        yourGender.setOnCheckedChangeListener { radioGroup, i ->
            if (yourGenderMan.isChecked) {
                yourGenderText = setGender(0)
            } else if (yourGenderWoman.isChecked) {
                yourGenderText = setGender(1)
            }
        }
    }

    private fun setPartnerData() {

        partnerNameText = textInputLoveName.editText?.getText().toString().trim()
        partnerBirthdayText = partnerBirthdayDate.text.toString().trim()
        partnerBirthdayDate.setOnClickListener {
            setDate(partnerBirthdayDate)
            partnerBirthdayText = partnerBirthdayDate.text.toString().trim()
        }
        partnerGender.setOnCheckedChangeListener { radioGroup, i ->
            if (partnerGenderMan.isChecked) {
                partnerGenderText = setGender(0)
            } else if (partnerGenderWoman.isChecked) {
                partnerGenderText = setGender(1)
            }
        }
    }

    private fun setLoveDate() {
        loveDayText = loveDate.text.toString().trim()
        loveDate.setOnClickListener {
            setDate(loveDate)
            loveDayText = loveDate.text.toString().trim()
        }
    }


    private fun setGender(i: Int): String {
        lateinit var gender: String
        if (i == 0) {
            gender = "Мужской"
        } else if (i == 1) {
            gender = "Женский"
        }
        return gender
    }


    fun setDate(date: TextView?) {
        var result = "01.01.01"
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_YEAR)

        val datePickerDialog = DatePickerDialog(
            APP_ACTIVITY,
            DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                result = "${mDay.toString()}.${mMonth.toString()}.${mYear.toString()}"
                date?.text = result

            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}