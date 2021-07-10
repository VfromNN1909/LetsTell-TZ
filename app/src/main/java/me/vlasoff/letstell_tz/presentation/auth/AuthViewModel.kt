package me.vlasoff.letstell_tz.presentation.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import me.vlasoff.letstell_tz.data.remote.Resource
import me.vlasoff.letstell_tz.domain.entities.retrofit.LoginRequest
import me.vlasoff.letstell_tz.domain.entities.retrofit.LoginResponse
import me.vlasoff.letstell_tz.domain.usecases.LoginUseCase
import me.vlasoff.letstell_tz.presentation.Contract
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel(), Contract.IAuthViewModel {

    override fun login(body: LoginRequest) = liveData(Dispatchers.IO) {
        try {
            emit(Resource.success(data = loginUseCase.execute(body)))
        } catch (ex: Exception) {
            emit(Resource.error(data = null, message = ex.message ?: "Ops.. something went wrong!"))
        }
    }

}