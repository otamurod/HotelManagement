package uz.otamurod.data.network.mapper

import uz.otamurod.data.network.api.entities.RoomsResponse as RoomsDto
import uz.otamurod.domain.api.model.Rooms as RoomsBo

object RoomsResponseMapper {
    class Rooms internal constructor(private val dto: RoomsDto) {
        operator fun invoke(): RoomsBo = with(dto) {
            RoomsBo(
                rooms.map {
                    RoomResponseMapper.Room(it).invoke()
                }
            )
        }
    }
}