package com.example.noizs.fragmentstest.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.noizs.fragmentstest.MainActivity
import com.example.noizs.fragmentstest.R

class FourthFragment : Fragment() {
    companion object {
        fun newInstance(): FourthFragment {
            return FourthFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val text : TextView? = view.findViewById(R.id.text)
        text?.text = "Fourth"
        return view
    }


}
