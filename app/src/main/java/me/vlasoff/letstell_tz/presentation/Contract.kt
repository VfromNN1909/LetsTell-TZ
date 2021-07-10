package me.vlasoff.letstell_tz.presentation

import androidx.lifecycle.LiveData
import me.vlasoff.letstell_tz.data.remote.Resource
import me.vlasoff.letstell_tz.domain.entities.retrofit.LoginRequest
import me.vlasoff.letstell_tz.domain.entities.retrofit.LoginResponse

interface Contract {
    interface IAuthViewModel {
        fun login(body: LoginRequest): LiveData<Resource<LoginResponse?>>

    }
}