package uz.otamurod.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Tourist(
    val name: String,
    val surname: String,
    val birthday: String,
    val citizenship: String,
    val passportNumber: String,
    val passportDueDate: String
) : Parcelable
