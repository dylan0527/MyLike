package com.example.mylike

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //module-level variable
    private var countLike:Int=0
    private var countDislike:Int=0
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity","onCreate")

        //Initialise Shared Preferences
        sharedPreferences = getPreferences(Context.MODE_PRIVATE)




        imageView.setOnClickListener {
            countLike++
            textViewUp.text = countLike.toString()
        }
        imageView2.setOnClickListener {
            countDislike++
            textViewDown.text =countDislike.toString()
        }
    }

    override fun onStart() {
        Log.d("MainActivity","onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("MainActivity","onResume")
        //retrieve the stored value
        countLike = sharedPreferences.getInt(getString(R.string.like),0)
        countDislike = sharedPreferences.getInt(getString(R.string.dislike),0)

        textViewUp.text = countLike.toString()
        textViewDown.text = countDislike.toString()
        super.onResume()
    }

    override fun onRestart() {
        Log.d("MainActivity","onResume")
        super.onRestart()
    }

    override fun onStop() {
        Log.d("MainActivity","onStop")
        super.onStop()
    }

    override fun onPause() {
        with(sharedPreferences.edit()){
            putInt(getString(R.string.like),countLike)
            putInt(getString(R.string.dislike),countDislike)
            commit()
        }

        Log.d("MainActivity","onPause")
        super.onPause()
    }

    override fun onDestroy() {
        Log.d("MainActivity","onDestroy")
        super.onDestroy()
    }
}
