package me.vlasoff.letstell_tz.presentation.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.marginTop
import androidx.fragment.app.Fragment
import coil.load
import me.vlasoff.letstell_tz.R
import me.vlasoff.letstell_tz.databinding.FragmentLoginBinding
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent


class LoginFragment : Fragment() {

    private val binding: FragmentLoginBinding by lazy {
        FragmentLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        KeyboardVisibilityEvent.setEventListener(requireActivity()) { isOpen ->
            if (isOpen) {
                binding.cardLogoBg.load(R.drawable.ic_logo2)
            }
//            else {
//                binding.cardLogoBg.load(R.drawable.ic_full_logo)
//            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

}