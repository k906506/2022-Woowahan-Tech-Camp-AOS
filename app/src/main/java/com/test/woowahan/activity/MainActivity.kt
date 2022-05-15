package com.test.woowahan.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.test.woowahan.databinding.ActivityMainBinding
import com.test.woowahan.repo.RequestRepository
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = requireNotNull(_binding)

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
        lifecycleScope.launch { RequestRepository().requestData() }
    }

    fun startDetailActivity() {
        DetailActivity.getIntent(this@MainActivity)
    }
}