package com.eduardomaxwell.applicationnotification.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.eduardomaxwell.applicationnotification.R
import com.eduardomaxwell.applicationnotification.databinding.ActivityMainBinding
import com.eduardomaxwell.applicationnotification.utils.showNotification
import com.google.firebase.iid.FirebaseInstanceId

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSendNotification.setOnClickListener {
            this.showNotification(
                "123",
                "Bootcamp Digital Innovation One",
                "Working with Local Notification. Kotlin Android")
        }
        Log.i("**newToken", FirebaseInstanceId.getInstance().token.toString())
    }
}