package me.vlasoff.letstell_tz.presentation.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import coil.load
import dagger.hilt.android.AndroidEntryPoint
import me.vlasoff.letstell_tz.R
import me.vlasoff.letstell_tz.data.remote.Status
import me.vlasoff.letstell_tz.databinding.FragmentLoginBinding
import me.vlasoff.letstell_tz.domain.entities.retrofit.LoginRequest
import me.vlasoff.letstell_tz.presentation.main.MainFragmentArgs
import me.vlasoff.letstell_tz.utils.SessionManager
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val binding: FragmentLoginBinding by lazy {
        FragmentLoginBinding.inflate(layoutInflater)
    }

    private val viewModel: AuthViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        KeyboardVisibilityEvent.setEventListener(requireActivity()) { isOpen ->
            if (isOpen) {
                binding.cardLogoBg.load(R.drawable.ic_logo2)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val manager = SessionManager(requireContext())

        if (manager.getAuthToken() != null){
            findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
        }

        binding.buttonLogin.setOnClickListener {

            val email = binding.email.editText?.text.toString()
            val password = binding.password.editText?.text.toString()
            Log.d("EM&PW", "$email\n$password")

            if (binding.email.editText?.text.toString() == "") {
                binding.email.editText?.error = "Field must be filled"
            }
            if (binding.password.editText?.text.toString() == "") {
                binding.password.editText?.error = "Field must be filled"
            }
            viewModel.login(LoginRequest(email, password)).observe(requireActivity()) {
                it?.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {

                            findNavController().navigate(R.id.action_loginFragment_to_mainFragment,
                                resource.data?.let { loginResponse ->
                                    MainFragmentArgs(
                                        loginResponse.body.user.email,
                                        loginResponse.body.access_token
                                    ).toBundle()
                                }
                            )
                        }
                        Status.ERROR -> {
                            Toast.makeText(
                                requireContext(),
                                "Email or password is incorrect!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }


        }

    }

}