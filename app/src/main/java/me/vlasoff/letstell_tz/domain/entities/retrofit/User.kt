package me.vlasoff.letstell_tz.domain.entities.retrofit


data class User(
    val about: String?,
    val avatar: String,
    val country: String?,
    val country_id: Int,
    val email: String,
    val id: String,
    val is_email_verified: Boolean,
    val language_id: Int,
    val name: String,
    val sex: String
)