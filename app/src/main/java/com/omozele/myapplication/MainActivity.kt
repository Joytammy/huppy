package com.omozele.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val validUsername = "admin"
    val validPassword = "admin"
    val validSubmit = "admin"


    private lateinit var usernameInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var submitButton: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameInput = findViewById(R.id.username_input)
        passwordInput = findViewById(R.id.password_input)
        submitButton = findViewById(R.id.submit_)

        submitButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            login(username, password)
        }

    }
    private fun login(username: String, password: String){
        if (isValidCredentials(username, password)){
            val intent: Intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("name", username)
            startActivity(intent)
    } else{
        Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT ).show()

    }
    }

    private fun isValidCredentials(username: String, password: String):Boolean{
        if(username == validUsername && password == validPassword) return true
        return false
    }
}