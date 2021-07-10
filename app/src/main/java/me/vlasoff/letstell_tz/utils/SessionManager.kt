package me.vlasoff.letstell_tz.utils

import android.content.Context
import me.vlasoff.letstell_tz.R
import javax.inject.Inject

class SessionManager(context: Context) {
    private val prefs =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        const val USER_TOKEN = "user_token"
    }

    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    fun getAuthToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }
}