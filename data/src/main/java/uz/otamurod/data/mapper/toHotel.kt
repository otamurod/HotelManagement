package uz.otamurod.data.mapper

import uz.otamurod.data.network.dto.HotelDto
import uz.otamurod.domain.model.Hotel

fun HotelDto.toHotel(): Hotel {
    return Hotel(
        aboutTheHotel,
        address,
        id,
        imageUrls,
        minimalPrice,
        name,
        priceForIt,
        rating,
        ratingName
    )
}