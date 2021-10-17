package com.example.quizapp



import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView


import android.provider.ContactsContract
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.database.getStringOrNull
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner


const val EXTRA_MESSAGE = "com.example.quizapp.MESSAGE"
const val TAG_MAIN : String =  "MainActivity"
const val REQUEST_SELECT_CONTACT = 1



class MainActivity : AppCompatActivity() {
    private lateinit var startButton : Button
    private lateinit var chooseContactButton : Button
    private lateinit var userName : TextView
    private lateinit var  contactUri : Uri
    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeView()
        registerListeners()



    }

    private fun initializeView()
    {

        userName = findViewById<TextView>(R.id.userName)
        startButton = findViewById<Button>(R.id.startButton)
        chooseContactButton = findViewById<Button>(R.id.chooseContactbtn)




    }

    private fun registerListeners()
    {

        chooseContactButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = ContactsContract.Contacts.CONTENT_TYPE

            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, REQUEST_SELECT_CONTACT)

            }


        }
        /* LAB01
        startButton.setOnClickListener {
            //left toast and snackbar for the sake of testing.
            //val toast = Toast.makeText(applicationContext, "Name accepted in Toast!", Toast.LENGTH_LONG)
            //toast.show()
            Log.i(TAG_MAIN, userName.text.toString())
            //val snackbar = Snackbar.make(it, "Name Accepted in Snackbar!", Snackbar.LENGTH_LONG)
            hideKeyboard(it)
            //snackbar.show()

        }
        */


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_SELECT_CONTACT && resultCode == Activity.RESULT_OK)
        {
            contactUri = data!!.data!!
            getContactName()
        }
    }
    private fun getContactName() {
        val cursor = contentResolver.query(contactUri!!,null,null,null,null)
        if(cursor!!.moveToFirst()){
            val contactName = cursor.getStringOrNull(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
            userName.setText(contactName)

        }
    }




    fun sendMessage(view: View) {
        val editText = findViewById<EditText>(R.id.userName)
        val message = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }


    override fun onStart() {
        super.onStart()
        Log.i(TAG_MAIN, "onStart override")
        //val toast = Toast.makeText(applicationContext, "onStart Toast!", Toast.LENGTH_LONG)
        //toast.show()
    }

    override fun onResume() {
        Log.i(TAG_MAIN, "onResume override")
        super.onResume()
    }

    override fun onRestart() {
        Log.i(TAG_MAIN, "onRestart override")
        super.onRestart()
    }

    override fun onPause() {
        Log.i(TAG_MAIN, "onPause override")
        super.onPause()
    }

    override fun onStop() {
        Log.i(TAG_MAIN, "onStop override")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i(TAG_MAIN, "onDestroy override")
        super.onDestroy()
    }

    //it annoyed me that the keyboard stayed after the button press, so I solved it (stackoverflow function)
    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }







}
