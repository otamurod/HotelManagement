package uz.otamurod.data.network.api.entities

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class RoomResponse(
    @SerializedName("id")
    val id: Int,

    @SerializedName("image_urls")
    val imageUrls: List<String>,

    @SerializedName("name")
    val name: String,

    @SerializedName("peculiarities")
    val peculiarities: List<String>,

    @SerializedName("price")
    val price: Int,

    @SerializedName("price_per")
    val pricePer: String

):Parcelable