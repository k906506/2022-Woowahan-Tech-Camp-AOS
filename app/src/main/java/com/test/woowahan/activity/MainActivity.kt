package com.test.woowahan.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.test.woowahan.adapter.MenuAdapter
import com.test.woowahan.data.Menus
import com.test.woowahan.data.ShopInfo
import com.test.woowahan.databinding.ActivityMainBinding
import com.test.woowahan.repo.RequestRepository
import com.test.woowahan.request.ImageDownloadManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = requireNotNull(_binding)
    private var menus: List<Menus> = listOf()
    private var shopInfo: ShopInfo? = null

    private val adapter by lazy {
        MenuAdapter(itemClickListener = { menus -> startDetailActivity(menus) })
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * API 호출예제
         * 예제는 삭제/수정 가능합니다.
         *
         * 예제코드의 모든 코드는 변경, 수정 가능합니다.
         */
        lifecycleScope.launch {
            val data = RequestRepository().requestData().data

            menus = data.shopMenu.groupMenus[0].menus
            adapter.submitList(menus)

            shopInfo = data.shopInfo

            bindViews()
        }

        initViews()
    }

    private fun startDetailActivity(menus: Menus) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra("url", menus.images?.get(0)?.url)
        // Serialized 오류 발생
        // intent.putExtra("data", menus)
        startActivity(intent)
    }

    private fun initViews() {
        binding.menuRecyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.menuRecyclerview.adapter = adapter
    }

    private fun bindViews() = with(binding) {
        CoroutineScope(Dispatchers.IO).launch {
            val bitmap = ImageDownloadManager.getImage(
                shopInfo?.headerImages?.get(0)?.url
                    ?: ""
            )
            withContext(Dispatchers.Main) {
                shopImageView.setImageBitmap(bitmap)
            }
        }

        shopTitleTextView.text = shopInfo?.shopName
        shopRatingBar.rating = shopInfo?.statisticsInfo?.starAveragePoint?.toFloat()!!
        shopReviewTextView.text = "최근리뷰 : ${shopInfo?.statisticsInfo?.reviewCountLatest}"

        minPriceView.text = "${shopInfo?.orderCondition?.minimumOrderAblePrice?.toString()}원"
        tipView.text = "${shopInfo?.deliveryTipInfo?.deliveryTipPrice}원"
        departTimeView.text = "${shopInfo?.deliveryTimeInfo.toString()}"
    }


}