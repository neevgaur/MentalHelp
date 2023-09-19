package com.gaurneev.mentalhelper

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gaurneev.mentalhelper.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnDiet?.setOnClickListener{

            val destinationFragment = DietFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.container, destinationFragment)
            transaction.addToBackStack(null) // Optional, for back navigation
            transaction.commit()
        }

        binding?.btnProgress?.setOnClickListener{

            val destinationFragment = ProgressFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.container, destinationFragment)
            transaction.addToBackStack(null) // Optional, for back navigation
            transaction.commit()
        }

        binding?.btnCure?.setOnClickListener{

            val destinationFragment = CureFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.container, destinationFragment)
            transaction.addToBackStack(null) // Optional, for back navigation
            transaction.commit()
        }

        binding?.btnJoy?.setOnClickListener{

            val destinationFragment = JoyFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.container, destinationFragment)
            transaction.addToBackStack(null) // Optional, for back navigation
            transaction.commit()
        }

        binding?.btnSelfEvaluation?.setOnClickListener{

            val destinationFragment = SelfEvaluationFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.container, destinationFragment)
            transaction.addToBackStack(null) // Optional, for back navigation
            transaction.commit()
        }

        binding?.btnNeedHelpNow?.setOnClickListener{

            val destinationFragment = NeedHelpNowFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.container, destinationFragment)
            transaction.addToBackStack(null) // Optional, for back navigation
            transaction.commit()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        binding= null
    }
}