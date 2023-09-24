package uz.otamurod.data.network.api.entities

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class RoomsResponse(
    val rooms: List<RoomResponse>
) : Parcelable