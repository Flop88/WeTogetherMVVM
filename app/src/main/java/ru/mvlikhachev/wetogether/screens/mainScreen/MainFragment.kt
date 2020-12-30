package ru.mvlikhachev.wetogether.screens.mainScreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_main.*
import ru.mvlikhachev.wetogether.R
import ru.mvlikhachev.wetogether.databinding.FragmentMainBinding
import ru.mvlikhachev.wetogether.model.AppPerson
import ru.mvlikhachev.wetogether.utils.APP_ACTIVITY

class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: MainFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()

        initialization()
        loadData()
    }

    private fun loadData() {
         mViewModel.readUserData.observe(APP_ACTIVITY, { user ->
             val currentUser = user[0]
             setData(currentUser)
        })
    }

    private fun setData(currentUser: AppPerson) {
        mainYourNameTextView.text = "Здраствуйте, ${currentUser.yourName}"
        Log.d("loveDate", currentUser.loveDate)
        Log.d("loveDate", currentUser.loveDate)

    }


    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}