package com.example.quizapp



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.Toast

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.Fragment


import com.google.android.material.snackbar.Snackbar
const val EXTRA_MESSAGE = "com.example.quizapp.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1 = findViewById<Button>(R.id.btn1)

        /*
        btn1.setOnClickListener {
            //left toast and snackbar for the sake of testing.
            //val toast = Toast.makeText(applicationContext, "Name accepted in Toast!", Toast.LENGTH_LONG)
            //toast.show()
            //val snackbar = Snackbar.make(it, "Name Accepted in Snackbar!", Snackbar.LENGTH_LONG)
            hideKeyboard(it)
            //snackbar.show()

        }
        */


    }
    /*
    override fun onStart() {
        super.onStart()
        val toast = Toast.makeText(applicationContext, "onStart Toast!", Toast.LENGTH_LONG)
        toast.show()
    }
    */

    fun sendMessage(view: View) {
        val editText = findViewById<EditText>(R.id.nameOfPersonGET)
        val message = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    //it annoyed me that the keyboard stayed after the button press, so I solved it (stackoverflow function)
    /*
    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    */


}
