package uz.otamurod.data.mapper

import uz.otamurod.data.network.dto.BookingDto
import uz.otamurod.domain.model.Booking

fun BookingDto.toBooking(): Booking {
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