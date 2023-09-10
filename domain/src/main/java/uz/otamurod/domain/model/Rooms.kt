package uz.otamurod.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Rooms(
    val rooms: List<Room>
) : Parcelable