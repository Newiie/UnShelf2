package com.example.unshelf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.unshelf.Model.authentication.Customer_Login
import com.example.unshelf.Model.authentication.Customer_Register
import com.example.unshelf.Model.authentication.Seller_Login

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getStartedButton = findViewById<Button>(R.id.btn_get_started)

        getStartedButton.setOnClickListener {
            // Create an Intent to navigate to the Customer_Register activity
            val intent = Intent(this, Customer_Login::class.java)
            startActivity(intent)
        }
    }


}