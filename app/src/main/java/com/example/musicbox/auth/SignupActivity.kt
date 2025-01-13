package com.example.musicbox.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.musicbox.R
import com.example.musicbox.dashboard.activities.MainActivity
import com.example.musicbox.databinding.ActivitySignupBinding
import com.example.musicbox.models.LoginResponse
import com.example.musicbox.models.SignupRequest
import com.example.musicbox.network.ApiInterface
import com.example.musicbox.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    private fun signupApi(username: String, password: String,fullName:String) {
        val apiInterface = RetrofitClient.getInstance().create(ApiInterface::class.java)

        apiInterface.signupApi(SignupRequest(email = username, password = password, fullName = fullName))
            .enqueue(object :
                Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.code() == 200 || response.code() == 201) {
                        startActivity(Intent(this@SignupActivity, MainActivity::class.java))
                        Toast.makeText(
                            this@SignupActivity,
                            "Login success!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else {
                        Toast.makeText(
                            this@SignupActivity,
                            "Enter valid credentials",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(
                        this@SignupActivity,
                        t.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
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
            binding.etEnterPassword.length() < 5
        ){
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
                    signupApi(binding.etEnterEmail.text.toString().trim(),binding.etEnterPassword.text.toString().trim(),binding.etEnterUsername.text.toString().trim())

                }
            }

            R.id.ivBackButton -> {
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }
}