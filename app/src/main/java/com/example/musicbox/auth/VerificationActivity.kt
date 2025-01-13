package com.example.musicbox.auth

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.musicbox.R
import com.example.musicbox.databinding.ActivityVerificationBinding
import com.example.musicbox.models.AuthResponse
import com.example.musicbox.models.VerifyRequest
import com.example.musicbox.network.ApiInterface
import com.example.musicbox.network.RetrofitClient
import okhttp3.Callback
import retrofit2.Call
import retrofit2.Response

class VerificationActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityVerificationBinding
    private var emailToken: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        allClicks()
        setToolbar()
        setupOtpInputs()
        emailToken = intent.getStringExtra("email constant")

        if (emailToken != null) {
            Toast.makeText(this, "Received Token: $emailToken", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "No Token Found", Toast.LENGTH_SHORT).show()
        }
    }

        private fun allClicks() {
            binding.btnVerify.setOnClickListener(this@VerificationActivity)
            binding.toolbar.ivBackButton.setOnClickListener(this)
            binding.btnVerify.setOnClickListener(this)
        }
    private fun setToolbar(){
        binding.toolbar.ivOption.visibility = View.GONE
        binding.toolbar.ivSearchOption.visibility = View.GONE
    }

        private fun verifyApi(otp: String) {
            val apiInterface = RetrofitClient.getInstance().create(ApiInterface::class.java)
            apiInterface.verifyApi(VerifyRequest(otp = otp,token = emailToken!!))
                .enqueue(object : retrofit2.Callback<AuthResponse> {
                    override fun onResponse(
                        call: Call<AuthResponse>,
                        response: Response<AuthResponse>
                    ) {
                        if (response.isSuccessful) {
                            Toast.makeText(
                                this@VerificationActivity,
                                "Verification Successful",
                                Toast.LENGTH_SHORT
                            ).show()
                            if (response.code()==200|| response.code()==201){
                                startActivity(Intent(this@VerificationActivity,ResetActivity::class.java)
                                    .putExtra("email constant",emailToken))
                            }
                        } else {
                            Toast.makeText(
                                this@VerificationActivity,
                                "Verification Failed",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                        Toast.makeText(this@VerificationActivity, t.message, Toast.LENGTH_SHORT)
                            .show()
                    }

                })
        }

        private fun setupOtpInputs() {
            val editText = listOf(
                binding.etCode1,
                binding.etCode2,
                binding.etCode3,
                binding.etCode4,
                binding.etCode5,
                binding.etCode6,
            )

            for (i in editText.indices) {
                editText[i].addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(
                        s: CharSequence?,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {
                    }

                    override fun onTextChanged(
                        s: CharSequence?,
                        start: Int,
                        before: Int,
                        count: Int
                    ) {
                        if (s?.length == 1 && i < editText.size - 1) {
                            editText[i + 1].requestFocus()

                        }
                    }

                    override fun afterTextChanged(s: Editable?) {}
                })
            }
        }

        private fun checkValidation(): Boolean {
            val otp = listOf(
                binding.etCode1.text.toString(),
                binding.etCode2.text.toString(),
                binding.etCode3.text.toString(),
                binding.etCode4.text.toString(),
                binding.etCode5.text.toString(),
                binding.etCode6.text.toString(),
            )
            if (otp.any { it.isEmpty() }) {
                Toast.makeText(this, "Please fill all the otp fields", Toast.LENGTH_SHORT).show()
                return false
            }
            return true
        }

        override fun onClick(v: View) {
            when (v.id) {

                R.id.btnVerify -> {

                    if (checkValidation()) {
                        val otp = binding.etCode1.text.toString() +
                                binding.etCode2.text.toString() +
                                binding.etCode3.text.toString() +
                                binding.etCode4.text.toString() +
                                binding.etCode5.text.toString() +
                                binding.etCode6.text.toString()

                        Toast.makeText(this, "OTP Verified: $otp", Toast.LENGTH_SHORT).show()
                        verifyApi(otp)
                    }
                }

                R.id.ivBackButton -> {
                    onBackPressedDispatcher.onBackPressed()

                }
            }
        }
    }
