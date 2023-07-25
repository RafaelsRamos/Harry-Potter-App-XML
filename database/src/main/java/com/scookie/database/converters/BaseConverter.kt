package com.scookie.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.lang.reflect.Type

internal abstract class BaseConverter<T>(type: Type) {
    private val gson: Gson
    private val type: Type

    init {
        this.type = type
        gson = GsonBuilder()
            .serializeNulls()
            .create()
    }

    @TypeConverter
    fun mapStringToList(value: String?): List<T> {
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun mapListToString(value: List<T>?): String {
        return gson.toJson(value, type)
    }
}