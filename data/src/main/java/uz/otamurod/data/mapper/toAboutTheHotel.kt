package uz.otamurod.data.mapper

import uz.otamurod.data.network.dto.AboutTheHotelDto
import uz.otamurod.domain.model.AboutTheHotel

fun AboutTheHotelDto.toAboutTheHotel(): AboutTheHotel {
    return AboutTheHotel(description, peculiarities)
}