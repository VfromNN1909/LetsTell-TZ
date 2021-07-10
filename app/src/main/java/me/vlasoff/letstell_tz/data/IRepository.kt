package me.vlasoff.letstell_tz.data

import me.vlasoff.letstell_tz.domain.entities.retrofit.LoginRequest
import me.vlasoff.letstell_tz.domain.entities.retrofit.LoginResponse
import me.vlasoff.letstell_tz.domain.entities.retrofit.LogoutResponse
import retrofit2.Call
import retrofit2.Response

interface IRepository {
    interface IAuthRepository {
        suspend fun login(body: LoginRequest): LoginResponse
        suspend fun logout(token: String): LogoutResponse
    }
}