package com.test.woowahan.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.woowahan.databinding.ActivityDetailBinding

class DetailActivity: AppCompatActivity() {

    private var _binding: ActivityDetailBinding? = null
    private val binding: ActivityDetailBinding get() = requireNotNull(_binding)

    companion object {
        fun getIntent(context: Context): Intent {
            //TODO putExtra
            return Intent(context, DetailActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun startConfirmActivity() {
        ConfirmActivity.getIntent(this@DetailActivity)
    }
}