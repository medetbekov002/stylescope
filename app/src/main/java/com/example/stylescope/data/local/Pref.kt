package com.example.stylescope.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class Pref(private val context: Context) {

    private val pref: SharedPreferences = context.getSharedPreferences("pref_name", MODE_PRIVATE)

    fun isRecover(): Boolean {
        return pref.getBoolean(IS_RECOVER, false)
    }

    fun saveIsRecover(isRecover: Boolean) {
        pref.edit().putBoolean(IS_RECOVER, isRecover).apply()
    }

    fun showUsername():String?{
        return pref.getString(USERNAME,"")
    }

    fun saveUsername(username:String){
        pref.edit().putString(USERNAME,username).apply()
    }

    fun showEmail():String?{
        return pref.getString(EMAIL,"")
    }

    fun saveEmail(email:String){
        pref.edit().putString(EMAIL,email).apply()
    }

    fun showConfirmCode():String?{
        return pref.getString(CONFIRM_CODE,"")
    }
    fun saveConfirmCode(code:String){
        pref.edit().putString(CONFIRM_CODE,code).apply()
    }

    fun saveToken(token:String?){
        pref.edit().putString(TOKEN,token).apply()
    }
    fun showToken():String?{
        return pref.getString(TOKEN,null)
    }

    fun savePassword(password:String){
        pref.edit().putString(USER_PASSWORD,password).apply()
    }

    fun showPassword():String?{
        return pref.getString(USER_PASSWORD,"")
    }

    fun saveRefreshToken(token:String){
        pref.edit().putString(REFRESH_TOKEN,token).apply()
    }

    fun showRefreshToken():String?{
        return pref.getString(REFRESH_TOKEN,"")
    }

    companion object {
        private const val IS_RECOVER = "is_recover"
        private const val USERNAME = "username"
        private const val EMAIL = "email"
        private const val CONFIRM_CODE = "confirm_code"
        private const val TOKEN = "token"
        private const val USER_PASSWORD = "user_password"
        private const val REFRESH_TOKEN = "refresh_token"
    }
}