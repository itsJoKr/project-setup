package com.example.jokr.propermock.dagger.modules

import com.example.jokr.propermock.models.Races
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www-tst.formulae.cloud")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


    @Provides
    fun provideRequestsInterceptor(): Interceptor {
        return Interceptor { interceptor ->
            val requestBuilder = interceptor.request().newBuilder()
            requestBuilder.addHeader("accept-language", "en")
            interceptor.proceed(requestBuilder.build())
        }
    }

    @Provides
    fun provideOkHttpClient(
        interceptor: Interceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addInterceptor(interceptor)
        return builder.build()
    }

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

}

interface ApiService {

    @GET("/api/v1/championships/2022018/races")
    fun getRaces(): Deferred<Races>
}