package uz.otamurod.data.mapper

import uz.otamurod.data.network.dto.RoomDto
import uz.otamurod.domain.model.Room

fun RoomDto.toRoom(): Room {
    return Room(id, imageUrls, name, peculiarities, price, pricePer)
}