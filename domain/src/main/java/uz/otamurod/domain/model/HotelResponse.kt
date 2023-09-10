package uz.otamurod.domain.model

/**
 * Generic class for holding success response, error response and loading status
 */
data class HotelResponse<out T>(
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

    companion object {
        fun <T> success(data: T?): HotelResponse<T> {
            return HotelResponse(Status.SUCCESS, data, null, null)
        }

        fun <T> error(message: String, error: ApiError?): HotelResponse<T> {
            return HotelResponse(Status.ERROR, null, error, message)
        }

        fun <T> loading(data: T? = null): HotelResponse<T> {
            return HotelResponse(Status.LOADING, data, null, null)
        }
    }

    override fun toString(): String {
        return "Result(status=$status, data=$data, error=$error, message=$message)"
    }
}