package com.example.jokr.propermock

import java.lang.reflect.Type
import javax.inject.Inject

class Mockaroo @Inject constructor() {

    fun <T> getApiResponse(filename: String, type: Type): T {
        throw Exception("You can't call Mockaroo in this flavour!")
    }

}