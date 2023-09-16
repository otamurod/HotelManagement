package uz.otamurod.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AboutTheHotel(
    @SerializedName("description")
    val description: String,

    @SerializedName("peculiarities")
    val peculiarities: List<String>
):Parcelable