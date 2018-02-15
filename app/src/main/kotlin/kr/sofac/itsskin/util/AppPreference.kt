package kr.sofac.itsskin.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.content.edit
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kr.sofac.itsskin.data.model.Category
import java.util.ArrayList

class AppPreference (context: Context){

    private var preferences: SharedPreferences
    private val gson : Gson = Gson()

    private val CATEGORIES_KEY : String = "Categories"

    init {
        preferences = PreferenceManager.getDefaultSharedPreferences(context)
    }

    fun getCategories() : List<Category>{
        return gson.fromJson(preferences.getString(CATEGORIES_KEY,""), object: TypeToken<List<Category>>() {}.type)
    }

    fun setCategories(categories : List<Category>){
        preferences.edit {
            putString(CATEGORIES_KEY, gson.toJson(categories))
        }
    }

}