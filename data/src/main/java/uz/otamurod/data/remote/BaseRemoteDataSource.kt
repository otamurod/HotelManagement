package uz.otamurod.data.remote

import retrofit2.Response
import retrofit2.Retrofit
import uz.otamurod.domain.model.ApiError
import uz.otamurod.domain.model.HotelResponse
import java.io.IOException
import javax.inject.Inject

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
    ): uz.otamurod.domain.model.HotelResponse<T> {
        return try {
            println("I'm working in thread ${Thread.currentThread().name}")
            val result = request.invoke()
            if (result.isSuccessful) {
                return uz.otamurod.domain.model.HotelResponse.success(result.body())
            } else {
                val errorResponse = parseError(result)
                uz.otamurod.domain.model.HotelResponse.error(errorResponse?.statusMessage ?: defaultErrorMessage, errorResponse)
            }
        } catch (e: Throwable) {
            uz.otamurod.domain.model.HotelResponse.error("Unknown Error", null)
        }
    }

    /**
     * Method to convert the error response of API Service to requested type
     * @param response the response of requested api
     * @return the ApiError of the request
     */
    private fun parseError(response: Response<*>): uz.otamurod.domain.model.ApiError? {
        val converter =
            retrofit.responseBodyConverter<uz.otamurod.domain.model.ApiError>(uz.otamurod.domain.model.ApiError::class.java, arrayOfNulls(0))
        return try {
            response.errorBody()?.let {
                converter.convert(it)
            }
        } catch (e: IOException) {
            uz.otamurod.domain.model.ApiError()
        }
    }
}