package com.loc.newsapp.data.utils

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class RetryInterceptor(
    private val maxRetries: Int = 3 // Maximum number of retries
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var attempt = 0
        var response: Response
        var request: Request = chain.request()

        while (true) {
            try {
                response = chain.proceed(request)
                // Break if response is successful or not retryable
                if (response.isSuccessful || attempt >= maxRetries) {
                    return response
                }
            } catch (e: IOException) {
                // Retry only for IOExceptions (network issues)
                if (attempt >= maxRetries) {
                    throw e // Max retries reached, throw exception
                }
            }

            attempt++
        }
    }
}
