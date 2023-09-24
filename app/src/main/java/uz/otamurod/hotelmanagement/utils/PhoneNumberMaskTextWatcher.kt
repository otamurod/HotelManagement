package uz.otamurod.hotelmanagement.utils

import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

class PhoneTextFormatter(
    private val mEditText: EditText,
    private val mPattern: String,
    private val fillBuyerDetailsErrorTxt: TextView
) : TextWatcher {
    private val TAG = this.javaClass.simpleName

    init {
        //set max length of string
        val maxLength = mPattern.length
        mEditText.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        val phone = java.lang.StringBuilder(s)

        if (count > 0 && !isValid(phone.toString())) {
            for (i in phone.indices) {
                Log.d(TAG, String.format("%s", phone))
                val c = mPattern[i]
                if (c != '*' && c != phone[i]) {
                    phone.insert(i, c)
                }
            }
            mEditText.setText(phone)
            mEditText.setSelection(mEditText.text.length)
        }
    }

    override fun afterTextChanged(s: Editable) {
        val phone = s.toString()
        if (phone.length == mPattern.length) {
            fillBuyerDetailsErrorTxt.visibility = View.GONE
        } else {
            fillBuyerDetailsErrorTxt.visibility = View.VISIBLE
        }
    }

    private fun isValid(phone: String): Boolean {
        for (i in phone.indices) {
            val c = mPattern[i]
            if (c == '*') continue
            if (c != phone[i]) {
                return false
            }
        }
        return true
    }
}
