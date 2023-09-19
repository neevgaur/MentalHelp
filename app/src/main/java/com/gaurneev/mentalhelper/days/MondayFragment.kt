package com.gaurneev.mentalhelper.days

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import com.gaurneev.mentalhelper.DietFragment
import com.gaurneev.mentalhelper.R
import com.gaurneev.mentalhelper.databinding.FragmentMondayBinding
import com.gaurneev.mentalhelper.databinding.FragmentTuesBinding

class MondayFragment : Fragment() {

    private lateinit var binding : FragmentMondayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMondayBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.monCard.visibility = View.VISIBLE
        disableBackPress()
    }

    private fun disableBackPress(){

        val home = DietFragment()
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            binding.monCard.visibility = View.INVISIBLE
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.Moncontainer,home)
                commit()
            }
        }
    }
}