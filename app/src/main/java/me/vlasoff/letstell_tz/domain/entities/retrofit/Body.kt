package me.vlasoff.letstell_tz.domain.entities.retrofit

data class Body(
    val access_token: String,
    val expires_in: Int,
    val token_type: String,
    val user: User
)