package uz.otamurod.data.remote.datasource

import retrofit2.Response
import retrofit2.Retrofit
import uz.otamurod.domain.model.ApiError
import java.io.IOException

/**
 * Base class of Remote API Data source
 * @param retrofit the object of Retrofit instance
 */
abstract class BaseRemoteDataSource constructor(
    private val retrofit: Retrofit
) {

    /**
     * Method to parse the Response of API Service
     * @param T the type of Response
     * @param request
     * @return HotelResponse<T> the result of the request with type T
     */
    suspend fun <T> getResponse(
        request: suspend () -> Response<T>,
        defaultErrorMessage: String
    ): HotelResponse<T> {
        return try {
            println("I'm working in thread ${Thread.currentThread().name}")
            val result = request.invoke()
            if (result.isSuccessful) {
                return HotelResponse.success(result.body())
            } else {
                val errorResponse = parseError(result)
                HotelResponse.error(errorResponse?.statusMessage ?: defaultErrorMessage, errorResponse)
            }
        } catch (e: Throwable) {
            HotelResponse.error("Unknown Error", null)
        }
    }

    /**
     * Method to convert the error response of API Service to requested type
     * @param response the response of requested api
     * @return the ApiError of the request
     */
    private fun parseError(response: Response<*>): ApiError? {
        val converter =
            retrofit.responseBodyConverter<ApiError>(ApiError::class.java, arrayOfNulls(0))
        return try {
            response.errorBody()?.let {
                converter.convert(it)
            }
        } catch (e: IOException) {
            ApiError()
        }
    }
}