package ru.mvlikhachev.wetogether.screens.mainScreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import ru.mvlikhachev.wetogether.R
import ru.mvlikhachev.wetogether.databinding.FragmentMainBinding

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
        Log.d("loadData", mViewModel.loadData().toString())
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}