package uz.otamurod.data.network.dto

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class AboutTheHotelDto(
    @SerializedName("description")
    val description: String,

    @SerializedName("peculiarities")
    val peculiarities: List<String>
):Parcelable