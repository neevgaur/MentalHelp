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
import com.gaurneev.mentalhelper.databinding.FragmentSatBinding

class FriFragment : Fragment() {

    private lateinit var binding: FragmentFriBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFriBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.FriCard.visibility= View.VISIBLE
        disableBackPress()
    }

    private fun disableBackPress(){

        val home = DietFragment()
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            binding.FriCard.visibility= View.GONE
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.Fricontainer,home)
                commit()
            }
        }
    }
}