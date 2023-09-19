package com.gaurneev.mentalhelper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gaurneev.mentalhelper.databinding.FragmentCureBinding
import com.gaurneev.mentalhelper.databinding.FragmentHomeBinding

class CureFragment : Fragment() {

    private var binding: FragmentCureBinding?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding= FragmentCureBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnExercise?.setOnClickListener{

            val destinationFragment = ExerciseFragment()
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