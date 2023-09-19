package com.gaurneev.mentalhelper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.gaurneev.mentalhelper.databinding.FragmentDietBinding
import com.gaurneev.mentalhelper.days.*

class DietFragment : Fragment() {

    private lateinit var binding: FragmentDietBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDietBinding.inflate(inflater, container, false)

        val mon = MondayFragment()
        val tue = TuesFragment()
        val wed = wedFragment()
        val thu = thurFragment()
        val fri = FriFragment()
        val sat = satFragment()
        val sun = sunFragment()
        binding.btnMonday.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, mon)
                commit()
            }
        }
        binding.btnTuesday.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, tue)
                commit()
            }
        }
        binding.btnWed.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, wed)
                commit()
            }
        }
        binding.btnThur.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, thu)
                commit()
            }
        }
        binding.btnFri.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, fri)
                commit()
            }
        }
        binding.btnSat.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, sat)
                commit()
            }
        }
        binding.btnSun.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, sun)
                commit()
            }
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        onBackPress()
    }

    private fun onBackPress() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            requireActivity().finish()
        }
    }
}