package me.vlasoff.letstell_tz.presentation.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import me.vlasoff.letstell_tz.R
import me.vlasoff.letstell_tz.data.remote.Status
import me.vlasoff.letstell_tz.databinding.FragmentMainBinding
import me.vlasoff.letstell_tz.presentation.auth.AuthActivity
import me.vlasoff.letstell_tz.utils.SessionManager

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val binding: FragmentMainBinding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = MainFragmentArgs.fromBundle(requireArguments())

        val token = args.accessToken

        val manager = SessionManager(requireContext())
        manager.saveAuthToken(token)

        binding.logout.setOnClickListener {
            viewModel.logout("Bearer $token").observe(viewLifecycleOwner){
                it?.let { resource ->
                    when(resource.status) {
                        Status.SUCCESS -> {
                            resource.data?.status?.let { it1 -> Log.d("LOGOUT_STATUS", it1) }
                            manager.removeToken()
                        }
                        Status.ERROR -> {
                            Toast.makeText(requireContext(), "Ops..something went wrong", Toast.LENGTH_SHORT).show()

                        }
                    }
                }
            }
            val intent = Intent(requireContext(), AuthActivity::class.java)
            startActivity(intent)
        }
    }

}