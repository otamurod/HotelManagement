package uz.otamurod.hotelmanagement.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.otamurod.domain.model.Tourist
import uz.otamurod.hotelmanagement.R
import uz.otamurod.hotelmanagement.databinding.ItemTouristBinding

class TouristAdapter(private val items: ArrayList<uz.otamurod.domain.model.Tourist>) :
    RecyclerView.Adapter<TouristAdapter.ViewHolder>() {

    private val numbers = hashMapOf(
        1 to "Первый Турист",
        2 to "Второй Турист",
        3 to "Третий Турист",
        4 to "Четвёртый Турист",
        5 to "Пятый Турист",
        6 to "Шестой Турист",
        7 to "Седьмой Турист",
        8 to "Восьмой Турист",
        9 to "Девятый Турист",
        10 to "Десятый Турист",
        11 to "Одиннадцатый Турист",
        12 to "Двенадцатый Турист",
        13 to "Тринадцатый Турист",
        14 to "Четырнадцатый Турист",
        15 to "Пятнадцатый Турист",
        16 to "Шестнадцатый Турист",
        17 to "Семнадцатый Турист",
        18 to "Восемнадцатый Турист",
        19 to "Девятнадцатый Турист",
        20 to "Двадцатый Турист"
    )

    inner class ViewHolder(var itemTouristBinding: ItemTouristBinding) :
        RecyclerView.ViewHolder(itemTouristBinding.root) {

        init {
            itemTouristBinding.expandIcon.setOnClickListener {
                toggleExpand()
            }
        }

        private fun toggleExpand() {
            if (itemTouristBinding.expandableLayout.visibility == View.VISIBLE) {
                itemTouristBinding.expandableLayout.visibility = View.GONE
                itemTouristBinding.expandIcon.setImageResource(R.drawable.ic_expand) // Change to your expand icon
            } else {
                itemTouristBinding.expandableLayout.visibility = View.VISIBLE
                itemTouristBinding.expandIcon.setImageResource(R.drawable.ic_collapse) // Change to your collapse icon
            }
        }
    }

    fun addItem(newItem: uz.otamurod.domain.model.Tourist) {
        items.add(newItem)
        notifyItemInserted(items.size - 1)
    }

    private fun numberToOrdinalText(key: Int): String {
        return numbers[key] ?: key.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemTouristBinding =
            ItemTouristBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemTouristBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Set label and sub-views data here

        holder.itemTouristBinding.touristLabel.text =
            String.format("%s", numberToOrdinalText(position + 1))
        holder.itemTouristBinding.touristName.text = items[position].name
        holder.itemTouristBinding.touristSurname.text = items[position].surname
        holder.itemTouristBinding.birthday.text = items[position].birthday
        holder.itemTouristBinding.citizenship.text = items[position].citizenship
        holder.itemTouristBinding.passportNumber.text = items[position].passportNumber
        holder.itemTouristBinding.passportValidityPeriod.text = items[position].passportDueDate

        // Set initial expand/collapse state based on item property
        holder.itemTouristBinding.expandableLayout.visibility = View.GONE
        holder.itemTouristBinding.expandIcon.setImageResource(R.drawable.ic_expand)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}