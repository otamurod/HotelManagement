package uz.otamurod.data.remote.datasource

import retrofit2.Response
import retrofit2.Retrofit
import uz.otamurod.domain.util.DataState
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
     * @return DataState<T> the result of the request with type T
     */
    suspend fun <T> getResponse(
        request: suspend () -> Response<T>,
        defaultErrorMessage: String
    ): DataState<T> {
        return try {
            println("I'm working in thread ${Thread.currentThread().name}")
            val result = request.invoke()
            if (result.isSuccessful) {
                return DataState.success(result.body())
            } else {
                val errorResponse = parseError(result)
                DataState.error(errorResponse?.statusMessage ?: defaultErrorMessage, errorResponse)
            }
        } catch (e: Throwable) {
            DataState.error("Unknown Error", null)
        }
    }

    /**
     * Method to convert the error response of API Service to requested type
     * @param response the response of requested api
     * @return the ApiError of the request
     */
    private fun parseError(response: Response<*>): DataState.ApiError? {
        val converter =
            retrofit.responseBodyConverter<DataState.ApiError>(DataState.ApiError::class.java, arrayOfNulls(0))
        return try {
            response.errorBody()?.let {
                converter.convert(it)
            }
        } catch (e: IOException) {
            DataState.ApiError()
        }
    }
}