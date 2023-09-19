package com.gaurneev.mentalhelper.days

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import com.gaurneev.mentalhelper.DietFragment
import com.gaurneev.mentalhelper.R
import com.gaurneev.mentalhelper.databinding.FragmentThurBinding
import com.gaurneev.mentalhelper.databinding.FragmentWedBinding

class wedFragment : Fragment() {

    private lateinit var binding: FragmentWedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWedBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.wedCard.visibility = View.VISIBLE
        disableBackPress()
    }

    private fun disableBackPress(){

        val home = DietFragment()
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            binding.wedCard.visibility = View.INVISIBLE

            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.wedFragment,home)
                commit()
            }
        }
    }
}