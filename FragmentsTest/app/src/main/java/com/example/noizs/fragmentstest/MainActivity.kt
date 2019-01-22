package com.example.noizs.fragmentstest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.widget.Button
import com.example.noizs.fragmentstest.fragments.FirstFragment
import com.example.noizs.fragmentstest.fragments.FourthFragment
import com.example.noizs.fragmentstest.fragments.SecondFragment
import com.example.noizs.fragmentstest.fragments.ThirdFragment

class MainActivity : AppCompatActivity() {
    val TAG = "HOME"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentManager = supportFragmentManager
        val button1 : Button? = findViewById(R.id.button1)
        val button2 : Button? = findViewById(R.id.button2)
        val button3 : Button? = findViewById(R.id.button3)
        val button4 : Button? = findViewById(R.id.button4)
        val button5 : Button? = findViewById(R.id.button5)

        if (savedInstanceState == null){
            fragmentManager.beginTransaction()
                .replace(R.id.fragments_container, FirstFragment.newInstance(), "First")
                .commit()
        }
        button1?.setOnClickListener{
            fragmentManager.beginTransaction()
                .replace(R.id.fragments_container, FirstFragment.newInstance(), "First")
                .addToBackStack("First")
                .commit()
        }
        button2?.setOnClickListener{
            fragmentManager.beginTransaction()
                .replace(R.id.fragments_container, SecondFragment.newInstance(), "Second")
                .addToBackStack("Second")
                .commit()
        }
        button3?.setOnClickListener{
            fragmentManager.beginTransaction()
                .replace(R.id.fragments_container, ThirdFragment.newInstance(), "Third")
                .addToBackStack("Third")
                .commit()
        }
        button4?.setOnClickListener{
            fragmentManager.beginTransaction()
                .replace(R.id.fragments_container, FourthFragment.newInstance(), "Fourth")
                .addToBackStack("Fourth")
                .commit()
        }
        button5?.setOnClickListener{
            //Clear pop stack from fragment tag name 'second' ขึ้นไปข้างบน ( if 'second' have more than 1 , find latest and pop elements ) ( FragmentManager.POP_BACK_STACK_INCLUSIVE == รวมตัวมันเองด้วย)
            fragmentManager.popBackStack("Second", FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }
}
