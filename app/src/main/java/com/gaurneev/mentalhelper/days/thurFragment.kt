package com.gaurneev.mentalhelper.days

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import com.gaurneev.mentalhelper.DietFragment
import com.gaurneev.mentalhelper.R
import com.gaurneev.mentalhelper.databinding.FragmentFriBinding
import com.gaurneev.mentalhelper.databinding.FragmentThurBinding

class thurFragment : Fragment() {

    private lateinit var binding: FragmentThurBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThurBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.thurCard.visibility = View.VISIBLE
        disableBackPress()
    }

    private fun disableBackPress(){

        val home = DietFragment()
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            binding.thurCard.visibility = View.GONE
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.thurFragment,home)
                commit()
            }
        }
    }
}