package uz.otamurod.data.network.mapper

import uz.otamurod.data.network.api.entities.RoomResponse as RoomDto
import uz.otamurod.domain.api.model.Room as RoomBo

object RoomResponseMapper {
    class Room internal constructor(private val dto: RoomDto) {
        operator fun invoke(): RoomBo = with(dto) {
            RoomBo(
                id, imageUrls, name, peculiarities, price, pricePer
            )
        }
    }
}