package me.vlasoff.letstell_tz.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import me.vlasoff.letstell_tz.R
import me.vlasoff.letstell_tz.databinding.FragmentMainScreenBinding
import me.vlasoff.letstell_tz.domain.entities.retrofit.LoginResponse
import me.vlasoff.letstell_tz.utils.SessionManager

@AndroidEntryPoint
class MainScreenFragment : Fragment() {

    private val binding: FragmentMainScreenBinding by lazy {
        FragmentMainScreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = MainScreenFragmentArgs.fromBundle(requireArguments())

        val email = args.email
        val token = args.accessToken

        Log.d("MSARGS", "$email\n$token")
    }

}