package com.example.jokr.propermock.common.extensions

import com.example.jokr.propermock.dagger.modules.NetworkModule

fun String.toUrl(): String {
    return if (this.startsWith("/")) {
        NetworkModule.BASE_URL + this
    } else {
        this
    }
}