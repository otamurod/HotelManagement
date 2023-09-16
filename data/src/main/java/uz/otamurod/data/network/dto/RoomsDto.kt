package uz.otamurod.data.network.dto

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import uz.otamurod.domain.model.Room

@Keep
@Parcelize
data class RoomsDto(
    val rooms: List<Room>
) : Parcelable