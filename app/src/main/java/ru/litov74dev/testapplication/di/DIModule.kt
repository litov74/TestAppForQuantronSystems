package ru.litov74dev.testapplication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.litov74dev.testapplication.Constants
import ru.litov74dev.testapplication.network.ResultCallAdapterFactory
import ru.litov74dev.testapplication.network.RetrofitApi
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DIModule {

    @Provides
    @Singleton
    fun provideAppCoroutineScope(): CoroutineScope = CoroutineScope(Dispatchers.IO + Job())

    /*@Provides
    @Singleton
    fun provideSessionDataStorage(@ApplicationContext ctx: Context)*/

    private fun getLogger(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor(object: HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Timber.tag("OkHttp").d(message)
            }
        })
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        headerInterceptor: HeaderInterceptor
    ) : RetrofitApi {
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .addInterceptor(getLogger())
            .callTimeout(60, TimeUnit.SECONDS)
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.API_SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .addCallAdapterFactory(ResultCallAdapterFactory())
            .build()
        return retrofit.create(RetrofitApi::class.java)
    }
}

@Singleton
class HeaderInterceptor @Inject constructor() : Interceptor {

    // не имеет смысла подкидывать токен, т.к. Auth v3, не v4
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder().build()
        return chain.proceed(request)
    }
}