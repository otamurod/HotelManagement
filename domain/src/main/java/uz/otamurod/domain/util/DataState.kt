package uz.otamurod.domain.util

data class DataState<out T>(
    val status: Status,
    val data: T?,
    val error: ApiError?,
    val message: String?
) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    data class ApiError(
        val statusCode: Int = 0,
        val statusMessage: String? = null
    )

    companion object {
        fun <T> success(data: T?): DataState<T> {
            return DataState(Status.SUCCESS, data, null, null)
        }

        fun <T> error(message: String, error: ApiError?): DataState<T> {
            return DataState(Status.ERROR, null, error, message)
        }

        fun <T> loading(data: T? = null): DataState<T> {
            return DataState(Status.LOADING, data, null, null)
        }
    }

    override fun toString(): String {
        return "Result(status=$status, data=$data, error=$error, message=$message)"
    }
}