package com.test.woowahan.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.woowahan.data.Options
import com.test.woowahan.databinding.ItemMenuPriceBinding

class PriceAdapter() : RecyclerView.Adapter<PriceAdapter.ViewHolder>() {
    private var options: List<Options>? = null

    inner class ViewHolder(private val binding: ItemMenuPriceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindViews(option: Options) = with(binding) {
            btnRadio.text = option.name
            priceView.text = option.price.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMenuPriceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        options?.let {
            holder.bindViews(it[position])
        }
    }

    override fun getItemCount(): Int {
        return options?.size ?: 0
    }

    fun submitList(items: List<Options>) {
        options = items
        notifyDataSetChanged()
    }
}