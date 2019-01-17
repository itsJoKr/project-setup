package com.example.jokr.propermock

import com.google.gson.Gson
import java.io.InputStreamReader
import java.lang.reflect.Type
import javax.inject.Inject

class Mockaroo @Inject constructor(
    private val gson: Gson
) {

    fun <T> getApiResponse(filename: String, type: Type): T {
        val jsonFile = getFileAsString(filename)
        return gson.fromJson(jsonFile, type)
    }

    private fun getFileAsString(filename: String): String {
        val fileStream = javaClass.classLoader.getResourceAsStream(filename)
        val fileReader: InputStreamReader? = fileStream.reader()
        return fileReader?.readText() ?: ""
    }
}