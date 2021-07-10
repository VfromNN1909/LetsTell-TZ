package me.vlasoff.letstell_tz.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import me.vlasoff.letstell_tz.data.remote.Resource
import me.vlasoff.letstell_tz.domain.usecases.LogoutUseCase
import me.vlasoff.letstell_tz.presentation.Contract
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val logoutUseCase: LogoutUseCase
): ViewModel(), Contract.IMainViewModel {

    override fun logout(token: String) = liveData(Dispatchers.IO) {
        try {
            emit(Resource.success(data = logoutUseCase.execute(token)))
        } catch (ex : Exception){
            emit(Resource.error(data = null, message = ex.message ?: "Ops.. something went wrong"))
        }
    }

}