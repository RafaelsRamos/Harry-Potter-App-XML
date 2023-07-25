package com.scookie.database.converters

import com.google.gson.reflect.TypeToken

internal class ListStringConverter: BaseConverter<String>(object : TypeToken<List<String>>() {}.type)