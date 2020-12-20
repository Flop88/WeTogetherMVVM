package ru.mvlikhachev.wetogether.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ru.mvlikhachev.wetogether.MainActivity
import ru.mvlikhachev.wetogether.R
import ru.mvlikhachev.wetogether.database.Room.AppRoomDatabase
import ru.mvlikhachev.wetogether.utils.APP_ACTIVITY

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)



        val thread: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(5000)
                } catch (e: Exception) {
                    e.printStackTrace()
                } finally {
                    // Open new fragment
                    startActivity(
                        Intent(
                            this@SplashActivity,
                            MainActivity::class.java
                        )
                    )
                }
            }
        }
        thread.start()
    }
}