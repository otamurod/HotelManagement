package uz.otamurod.presentation.ui.booking

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import uz.otamurod.domain.model.Booking
import uz.otamurod.domain.model.Tourist
import uz.otamurod.domain.util.DataState
import uz.otamurod.presentation.ui.booking.adapter.TouristAdapter
import uz.otamurod.presentation.R
import uz.otamurod.presentation.databinding.FragmentBookingBinding
import uz.otamurod.presentation.ui.booking.utils.DateTextWatcher
import uz.otamurod.presentation.ui.booking.utils.EmailValidatorTextWatcher
import uz.otamurod.presentation.ui.booking.utils.PhoneTextFormatter
import java.util.*

@AndroidEntryPoint
class BookingFragment : Fragment() {

    private val viewModel: BookingViewModel by viewModels()
    private lateinit var binding: FragmentBookingBinding
    private lateinit var touristAdapter: TouristAdapter
    private lateinit var tourists: ArrayList<Tourist>
    private var snackBar: Snackbar? = null
    private var roomId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            roomId = it?.getInt("roomId")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookingBinding.inflate(
            LayoutInflater.from(container?.context),
            container,
            false
        )
        return binding.root
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()

        viewModel.bookRoom.observe(viewLifecycleOwner) { result ->
            val isLoading = when (result.status) {
                DataState.Status.SUCCESS -> {
                    result.data?.let { booking ->
                        updateUI(booking)
                    }
                    false
                }
                DataState.Status.ERROR -> {
                    result.message?.let {
                        showError(it) {
                            viewModel.fetchBookingInfo()
                        }
                    }
                    false
                }
                DataState.Status.LOADING -> true
            }

            if (isLoading) {
                startShimmerAnimation()
            }
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun initUI() {

        addTextWatchers()

        binding.paymentBtn.setOnClickListener {
            if (binding.buyerPhoneNumberEditTxt.text.isNotBlank() &&
                isValidEmail(binding.buyerEmailAddressEditTxt.text.toString())
                && binding.fillBuyerDetailsErrorTxt.visibility == View.GONE
            ) {
                binding.fillBuyerDetailsErrorTxt.visibility = View.GONE
                val bundle = bundleOf("roomId" to roomId)
                findNavController().navigate(R.id.action_bookingFragment_to_paidFragment, bundle)
            } else {
                binding.fillBuyerDetailsErrorTxt.visibility = View.VISIBLE
            }
        }

        binding.navigateBackBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }

        var isAddClicked = false
        binding.addTouristIcon.setOnClickListener {
            if (!isAddClicked) {
                binding.addTouristLayout.visibility = View.VISIBLE
                binding.addTouristIcon.setImageResource(R.drawable.ic_cancel) // Change to your collapse icon
                isAddClicked = true
            } else {
                binding.addTouristLayout.visibility = View.GONE
                binding.addTouristErrorTxt.visibility = View.GONE
                binding.addTouristIcon.setImageResource(R.drawable.ic_add) // Change to your collapse icon
                isAddClicked = false
            }
        }

        binding.addTouristBtn.setOnClickListener {
            binding.apply {
                val name = touristNameEditTxt.text.toString()
                val surname = touristSurnameEditText.text.toString()
                val birthday = birthdayEditText.text.toString()
                val citizenship = citizenshipEditText.text.toString()
                val passportNumber = passportNumber.text.toString()
                val passportDueDate = passportValidityPeriod.text.toString()

                if (name.isNotBlank() && surname.isNotBlank() && birthday.isNotBlank() && citizenship.isNotBlank() && passportNumber.isNotBlank() && passportDueDate.isNotBlank()) {
                    val tourist = Tourist(
                        name, surname, birthday, citizenship, passportNumber, passportDueDate
                    )
                    touristAdapter.addItem(tourist)
                    touristRv.adapter?.notifyDataSetChanged()
                    binding.addTouristErrorTxt.visibility = View.GONE
                    binding.addTouristLayout.visibility = View.GONE
                    binding.addTouristIcon.setImageResource(R.drawable.ic_add) // Change to your collapse icon
                    isAddClicked = false
                } else {
                    binding.addTouristErrorTxt.visibility = View.VISIBLE
                }
            }
        }

        binding.addTourist1Icon.setOnClickListener {
            toggleExpand()
        }

        binding.addTourist1Btn.setOnClickListener {
            binding.apply {
                val name = tourist1NameEditTxt.text.toString()
                val surname = tourist1SurnameEditText.text.toString()
                val birthday = tourist1BirthdayEditText.text.toString()
                val citizenship = tourist1CitizenshipEditText.text.toString()
                val passportNumber = tourist1PassportNumber.text.toString()
                val passportDueDate = tourist1PassportValidityPeriod.text.toString()

                if (name.isNotBlank() && surname.isNotBlank() && birthday.isNotBlank() && citizenship.isNotBlank() && passportNumber.isNotBlank() && passportDueDate.isNotBlank()) {
                    tourists = ArrayList()

                    val tourist = Tourist(
                        name, surname, birthday, citizenship, passportNumber, passportDueDate
                    )
                    tourists.add(tourist)

                    touristAdapter = TouristAdapter(tourists)
                    binding.touristRv.adapter = touristAdapter
                    binding.addFirstTouristBlock.visibility = View.GONE
                    binding.touristRv.visibility = View.VISIBLE
                    binding.addTourist1ErrorTxt.visibility = View.GONE
                } else {
                    binding.addTourist1ErrorTxt.visibility = View.VISIBLE
                }
            }
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun addTextWatchers() {
        binding.buyerPhoneNumberEditTxt.setBackgroundResource(R.drawable.buyer_layout_bg)
        binding.buyerPhoneNumberEditTxt.addTextChangedListener(
            PhoneTextFormatter(
                binding.buyerPhoneNumberEditTxt,
                "+7 (***) ***-**-**",
                binding.fillBuyerDetailsErrorTxt
            )
        )

        // Set up the EmailValidatorTextWatcher
        binding.buyerEmailAddressEditTxt.setBackgroundResource(R.drawable.buyer_layout_bg)
        binding.buyerEmailAddressEditTxt.addTextChangedListener(
            EmailValidatorTextWatcher(
                binding.buyerEmailAddressEditTxt,
                binding.errorTextView,
                binding.fillBuyerDetailsErrorTxt
            )
        )

        // Set up a listener to clear the error message when the user starts typing
        binding.buyerEmailAddressEditTxt.doOnTextChanged { _, _, _, _ ->
            binding.errorTextView.text = getString(R.string.email)
            binding.errorTextView.setTextColor(R.color.grey_400)
            binding.buyerEmailAddressEditTxt.background = ContextCompat.getDrawable(
                binding.buyerEmailAddressEditTxt.context,
                R.drawable.buyer_layout_bg
            )
        }

        binding.tourist1BirthdayEditText.addTextChangedListener(
            DateTextWatcher(binding.tourist1BirthdayEditText)
        )

        binding.tourist1PassportValidityPeriod.addTextChangedListener(
            DateTextWatcher(binding.tourist1PassportValidityPeriod)
        )

        binding.birthdayEditText.addTextChangedListener(
            DateTextWatcher(binding.birthdayEditText)
        )

        binding.passportValidityPeriod.addTextChangedListener(
            DateTextWatcher(binding.passportValidityPeriod)
        )
    }

    private fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun toggleExpand() {
        if (binding.addTourist1Layout.visibility == View.VISIBLE) {
            binding.addTourist1Layout.visibility = View.GONE
            binding.addTourist1ErrorTxt.visibility = View.GONE
            binding.addTourist1Icon.setImageResource(R.drawable.ic_expand) // Change to your expand icon
        } else {
            binding.addTourist1Layout.visibility = View.VISIBLE
            binding.addTourist1Icon.setImageResource(R.drawable.ic_collapse) // Change to your collapse icon
        }
    }

    private fun startShimmerAnimation() {
        binding.shimmerLayout.startShimmer()
    }

    private fun stopShimmerAnimation() {
        binding.shimmerLayout.stopShimmer()
        binding.shimmerLayout.visibility = View.GONE
    }

    private fun updateUI(booking: Booking) {
        binding.apply {
            val name = booking.hotelName
            val address = booking.hotelAddress
            val hotelRating = booking.hotelRating
            val ratingName = booking.ratingName
            val hotelDeparture = booking.departure
            val arrivalCountry = booking.arrivalCountry
            val tourDateStart = booking.tourDateStart
            val tourDateStop = booking.tourDateStop
            val numberOfNights = booking.numberOfNights
            val room = booking.room
            val nutritious = booking.nutrition
            val tourCharge = booking.tourPrice
            val fuelCharge = booking.fuelCharge
            val serviceCharge = booking.serviceCharge
            val totalPrice = tourCharge + fuelCharge + serviceCharge

            hotelStar.text = String.format("%d %s", hotelRating, ratingName)
            hotelName.text = String.format("%s", name)
            hotelAddress.text = String.format("%s", address)
            departure.text = String.format("%s", hotelDeparture)
            country.text = String.format("%s", arrivalCountry)
            dates.text = String.format("%s - %s", tourDateStart, tourDateStop)
            dates.text = String.format("%s - %s", tourDateStart, tourDateStop)
            nightsNumber.text = String.format("%s", numberOfNights)
            hotel.text = String.format("%s", name)
            number.text = String.format("%s", room)
            nutrition.text = String.format("%s", nutritious)
            tourPrice.text = String.format("%,d ₽", tourCharge).replace(",", " ")
            fuelPrice.text = String.format("%,d ₽", fuelCharge).replace(",", " ")
            serviceFee.text = String.format("%,d ₽", serviceCharge).replace(",", " ")

            totalCost.text = String.format("%,d ₽", totalPrice).replace(",", " ")
            paymentBtn.text = String.format("Оплатить %,d ₽", totalPrice).replace(",", " ")
        }
        stopShimmerAnimation()
    }

    private fun showError(msg: String, onRetry: () -> Unit) {
        view?.let {
            snackBar = Snackbar.make(it, msg, Snackbar.LENGTH_INDEFINITE)
            snackBar?.setAction("RETRY") {
                snackBar?.dismiss()
                onRetry.invoke()
            }
            snackBar?.show()
        }
    }

    companion object {
        fun newInstance() = BookingFragment()
    }
}