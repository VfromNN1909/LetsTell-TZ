package me.vlasoff.letstell_tz.domain.usecases

import me.vlasoff.letstell_tz.data.repos.AuthRepository
import me.vlasoff.letstell_tz.domain.entities.retrofit.LoginRequest
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend fun execute(body: LoginRequest) = repository.login(body)
}