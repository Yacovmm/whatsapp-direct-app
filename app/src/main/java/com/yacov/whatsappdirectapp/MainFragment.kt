package com.yacov.whatsappdirectapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.yacov.whatsappdirectapp.databinding.FragmentFirstBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    var binding: FragmentFirstBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding?.buttonFirst?.setOnClickListener {
            if (binding?.etFirst?.text.isNullOrEmpty()){
                Snackbar.make(requireView(), "Prencha o número", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val link = "https://api.whatsapp.com/send?phone=${binding?.etFirst?.text}"
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(browserIntent)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}