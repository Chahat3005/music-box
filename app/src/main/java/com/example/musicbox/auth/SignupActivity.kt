package com.example.musicbox.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.musicbox.R
import com.example.musicbox.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clicks()
    }

    private fun clicks() {
        binding.btnSignUp.setOnClickListener(this@SignupActivity)
        binding.toolbar.ivBackButton.setOnClickListener(this)
        binding.toolbar.ivOption.visibility = View.GONE
        binding.toolbar.ivSearchOption.visibility = View.GONE
    }


    private fun checkValidation(): Boolean {
        if (binding.etEnterUsername.text!!.toString().isEmpty()) {
            Toast.makeText(this, "Please enter your username", Toast.LENGTH_SHORT).show()
            return false
        } else if (binding.etEnterEmail.text!!.toString().isEmpty()) {
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
            return false
        } else if (binding.etEnterPassword.text!!.toString().isEmpty()) {
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show()
            return false
        } else if (
            binding.etEnterPassword.length() < 8
        ) {
            Toast.makeText(this, "Password must be of at least 8 digits", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnSignUp -> {

                val userType = if (binding.rbVenue.isChecked) {
                    getString(R.string.venue)
                } else if (binding.rbMusician.isChecked) {
                    getString(R.string.musician)
                } else {
                    getString(R.string.user)
                }
                if (checkValidation()) {
                    startActivity(Intent(this, VerificationActivity::class.java))
                }
            }

            R.id.ivBackButton -> {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }
}