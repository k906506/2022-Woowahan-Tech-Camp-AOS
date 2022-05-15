package com.test.woowahan.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.woowahan.data.Menus
import com.test.woowahan.databinding.ItemMenuThumbnailBinding
import com.test.woowahan.request.ImageDownloadManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MenuAdapter(private val itemClickListener: (Menus) -> Unit) :
    RecyclerView.Adapter<MenuAdapter.ViewHolder>() {
    private var menus: List<Menus>? = null

    inner class ViewHolder(private val binding: ItemMenuThumbnailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindViews(menu: Menus) = with(binding) {
            menuTitleTextView.text = menu.name
            menuDescriptionTextView.text = menu.description
            menuPriceTextView.text = menu.menuPrices[0].price

            CoroutineScope(Dispatchers.IO).launch {
                val bitmap = ImageDownloadManager.getImage(menu.images?.get(2)?.url ?: "No Image")
                withContext(Dispatchers.Main) {
                    menuImageView.setImageBitmap(bitmap)
                }
            }

            binding.root.setOnClickListener {
                itemClickListener(menu)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMenuThumbnailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        menus?.let {
            holder.bindViews(it[position])
        }
    }

    override fun getItemCount(): Int {
        return menus?.size ?: 0
    }

    fun submitList(items: List<Menus>) {
        menus = items
        notifyDataSetChanged()
    }
}