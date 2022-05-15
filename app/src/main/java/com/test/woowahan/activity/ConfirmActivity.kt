package com.test.woowahan.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.woowahan.databinding.ActivityConfirmBinding

class ConfirmActivity: AppCompatActivity() {

    private var _binding: ActivityConfirmBinding? = null
    private val binding: ActivityConfirmBinding get() = requireNotNull(_binding)

    companion object {
        fun getIntent(context: Context): Intent {
            //TODO putExtra
            return Intent(context, ConfirmActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}