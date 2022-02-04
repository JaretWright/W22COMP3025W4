package com.constantlearningdad.w22comp3025w4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.constantlearningdad.w22comp3025w4.databinding.ActivitySmsActivityBinding

class SmsActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySmsActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySmsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.smsBackToMainButton.setOnClickListener {
            finish()
        }

        binding.messageButton.setOnClickListener {
            var phoneNum = binding.phoneNumEditText.text.toString()
            var message = binding.messageEditText.text.toString()

            if (phoneNum.isNotEmpty() && message.isNotEmpty())
            {
                val uri = Uri.parse("smsto:$phoneNum")
                val intent = Intent(Intent.ACTION_SENDTO, uri)
                intent.putExtra("sms_body",message)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this,"Enter phone and message info", Toast.LENGTH_LONG).show()
            }
        }

    }
}