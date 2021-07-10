package me.vlasoff.letstell_tz.data.repos

import me.vlasoff.letstell_tz.data.IRepository
import me.vlasoff.letstell_tz.data.remote.ApiService
import me.vlasoff.letstell_tz.domain.entities.retrofit.LoginRequest

class AuthRepository(
    private val service: ApiService
) : IRepository.IAuthRepository {
    override suspend fun login(body: LoginRequest) = service.login(body)

    override suspend fun logout(token: String) = service.logout(token)
}