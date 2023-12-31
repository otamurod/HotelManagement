package uz.otamurod.data.network.api.entities

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class HotelResponse(
    @SerializedName("about_the_hotel")
    val aboutHotel: AboutHotelResponse,

    @SerializedName("adress")
    val address: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("image_urls")
    val imageUrls: List<String>,

    @SerializedName("minimal_price")
    val minimalPrice: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("price_for_it")
    val priceForIt: String,

    @SerializedName("rating")
    val rating: Int,

    @SerializedName("rating_name")
    val ratingName: String
) : Parcelable