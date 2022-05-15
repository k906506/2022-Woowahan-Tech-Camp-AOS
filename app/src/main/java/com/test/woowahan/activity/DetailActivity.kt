package com.test.woowahan.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.woowahan.adapter.PriceAdapter
import com.test.woowahan.data.Menus
import com.test.woowahan.databinding.ActivityDetailBinding
import com.test.woowahan.request.ImageDownloadManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailActivity : AppCompatActivity() {

    private var _binding: ActivityDetailBinding? = null
    private val binding: ActivityDetailBinding get() = requireNotNull(_binding)

    private val priceAdapter by lazy {
        PriceAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            val bitmap = ImageDownloadManager.getImage(
                intent.getStringExtra("url") ?: ""
            )
            withContext(Dispatchers.Main) {
                binding.menuImageView.setImageBitmap(bitmap)
            }
        }

        // Serialized 오류 발생
//        val data = intent.getSerializableExtra("data") as Menus
//
//        binding.menuTitleTextView.text = data.name
//        binding.menuDescriptionTextView.text = data.name

        initViews()
    }

    private fun initViews() {
        binding.priceRecyclerView.layoutManager = LinearLayoutManager(this@DetailActivity)
        binding.priceRecyclerView.adapter = priceAdapter
    }




}