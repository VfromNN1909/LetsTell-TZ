package me.vlasoff.letstell_tz.presentation.main

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import me.vlasoff.letstell_tz.R
import me.vlasoff.letstell_tz.data.remote.Status
import me.vlasoff.letstell_tz.databinding.ActivityMainBinding
import me.vlasoff.letstell_tz.utils.SessionManager

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}