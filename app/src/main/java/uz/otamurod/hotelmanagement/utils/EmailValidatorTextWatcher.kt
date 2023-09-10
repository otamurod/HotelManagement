package uz.otamurod.hotelmanagement.utils

import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import uz.otamurod.hotelmanagement.R

class EmailValidatorTextWatcher(
    private val editText: EditText,
    private val errorTextView: TextView,
    private val fillBuyerDetailsErrorTxt: TextView
) : TextWatcher {

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        // Not needed for this case
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        // Not needed for this case
    }

    @SuppressLint("ResourceAsColor")
    override fun afterTextChanged(s: Editable?) {
        val email = s.toString().trim()

        if (isValidEmail(email)) {
            // Valid email address, clear error and set normal background color
            errorTextView.text = errorTextView.context.getString(R.string.email_label)
            errorTextView.setTextColor(R.color.grey_400)

            editText.background = ContextCompat.getDrawable(
                editText.context,
                R.drawable.buyer_layout_bg
            )

            fillBuyerDetailsErrorTxt.visibility = View.GONE
        } else {
            // Invalid email address, show error and set error background color
            errorTextView.text = editText.context.getString(R.string.invalid_email_error)
            errorTextView.setTextColor(R.color.email_error_color)
            editText.background = ContextCompat.getDrawable(
                editText.context,
                R.drawable.edittext_error_bg
            )
            fillBuyerDetailsErrorTxt.visibility = View.VISIBLE
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}