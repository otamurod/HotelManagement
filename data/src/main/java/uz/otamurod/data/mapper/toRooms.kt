package uz.otamurod.data.mapper

import uz.otamurod.domain.model.Rooms

fun Rooms.toRooms(): Rooms {
    return Rooms(rooms)
}