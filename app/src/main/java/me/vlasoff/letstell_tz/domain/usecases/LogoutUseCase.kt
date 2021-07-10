package me.vlasoff.letstell_tz.domain.usecases

import me.vlasoff.letstell_tz.data.repos.AuthRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend fun execute(token: String) = repository.logout(token)
}