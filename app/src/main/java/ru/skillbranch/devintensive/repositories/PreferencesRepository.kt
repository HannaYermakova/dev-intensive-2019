package ru.skillbranch.devintensive.repositories

import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatDelegate
import ru.skillbranch.devintensive.App
import ru.skillbranch.devintensive.models.Profile

object PreferencesRepository {

    private const val FIRST_NAME = "FIRST_NAME"
    private const val LAST_NAME = "LAST_NAME"
    private const val ABOUT = "ABOUT"
    private const val REPOSITORY = "REPOSITORY"
    private const val RATING = "RATING"
    private const val RESPECT = "RESPECT"
    private const val APP_THEME = "APP_THEME"

    private val pref: SharedPreferences by lazy {
        val ctx = App.applicationContext()
        PreferenceManager.getDefaultSharedPreferences(ctx)
    }


    fun saveAppTheme(theme: Int) {
        putValue(APP_THEME to theme)
    }

    fun getAppTheme(): Int = pref.getInt(APP_THEME, AppCompatDelegate.MODE_NIGHT_NO)

    fun getProfile(): Profile = Profile(
        pref.getString(FIRST_NAME, "")!!,
        pref.getString(LAST_NAME, "")!!,
        pref.getString(ABOUT, "")!!,
        pref.getString(REPOSITORY, "")!!,
        pref.getInt(RATING, 0),
        pref.getInt(RESPECT, 0)
    )

    fun saveProfileData(profile: Profile) {
        with(profile) {
            putValue(FIRST_NAME to firstName)
            putValue(LAST_NAME to lastName)
            putValue(ABOUT to about)
            putValue(REPOSITORY to repository)
            putValue(RATING to rating)
            putValue(RESPECT to respect)
        }
    }

    private fun putValue(pair: Pair<String, Any>) = with(pref.edit()) {
        val key = pair.first
        val value = pair.second

        when (value) {
            is Int -> putInt(key, value)
            is String -> putString(key, value)
            is Boolean -> putBoolean(key, value)
            is Float -> putFloat(key, value)
            is Long -> putLong(key, value)
            else -> error("Only primitives types can be stored in SharedPreferences")
        }
        apply()
    }

}