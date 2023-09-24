package uz.otamurod.data.mapper

import uz.otamurod.data.network.api.entities.*
import uz.otamurod.domain.api.model.*

fun AboutHotelResponse.toDto(): AboutHotel {
    return AboutHotel(description, peculiarities)
}

fun BookingResponse.toDto(): Booking {
    return Booking(
        arrivalCountry,
        departure,
        fuelCharge,
        hotelRating,
        hotelAddress,
        hotelName,
        id,
        numberOfNights,
        nutrition,
        ratingName,
        room,
        serviceCharge,
        tourDateStart,
        tourDateStop,
        tourPrice
    )
}

fun HotelResponse.toDto(): Hotel {
    return Hotel(
        aboutHotel.toDto(),
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

fun RoomResponse.toDto(): Room {
    return Room(id, imageUrls, name, peculiarities, price, pricePer)
}

fun RoomsResponse.toDto(): Rooms {
    return Rooms(rooms.map { it.toDto() })
}