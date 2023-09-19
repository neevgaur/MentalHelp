package com.gaurneev.mentalhelper.days

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import com.gaurneev.mentalhelper.DietFragment
import com.gaurneev.mentalhelper.R
import com.gaurneev.mentalhelper.databinding.FragmentTuesBinding
import com.gaurneev.mentalhelper.databinding.FragmentWedBinding

class TuesFragment : Fragment() {
    private lateinit var binding: FragmentTuesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTuesBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.tuesCard.visibility = View.VISIBLE
        disableBackPress()
    }

    private fun disableBackPress(){

        val home = DietFragment()
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            binding.tuesCard.visibility = View.INVISIBLE

            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.Tuescontainer,home)
                commit()
            }
        }
    }
}