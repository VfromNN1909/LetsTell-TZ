package me.vlasoff.letstell_tz.data.remote

import me.vlasoff.letstell_tz.domain.entities.retrofit.LoginRequest
import me.vlasoff.letstell_tz.domain.entities.retrofit.LoginResponse
import me.vlasoff.letstell_tz.domain.entities.retrofit.LogoutResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("auth/login")
    suspend fun login(
        @Body body: LoginRequest
    ): LoginResponse

    @POST("auth/logout")
    suspend fun logout(
        @Query("access_token") token: String
    ): LogoutResponse
}