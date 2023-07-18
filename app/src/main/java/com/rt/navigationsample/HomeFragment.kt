package com.rt.navigationsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.rt.navigationsample.databinding.FragmentHomeBinding


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.apply {

            btnNavigate.setOnClickListener {
                if (etName.text.toString().isNotEmpty()) {
                    val bundle = bundleOf("name" to etName.text.toString())
                    it.findNavController()
                        .navigate(R.id.action_homeFragment_to_nameFragment, bundle)
                } else Toast.makeText(activity, "EMPTY text", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

}