package com.example.musicbox.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.musicbox.R
import com.example.musicbox.dashboard.activities.MainActivity
import com.example.musicbox.databinding.ActivityLoginBinding
import com.example.musicbox.models.LoginRequest
import com.example.musicbox.models.LoginResponse
import com.example.musicbox.network.ApiInterface
import com.example.musicbox.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        click()
    }

    private fun click() {
        binding.btLogin.setOnClickListener(this@LoginActivity)
        binding.btSignUpWithEmail.setOnClickListener(this)
        binding.tvForgetPassword.setOnClickListener(this)
    }

    private fun loginApi(username: String, password: String) {
        val apiInterface = RetrofitClient.getInstance().create(ApiInterface::class.java)
        apiInterface.loginApi(LoginRequest(email = username, password = password))
            .enqueue(object :
                Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.code() == 200 || response.code() == 201) {
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        Toast.makeText(
                            this@LoginActivity,
                            "Login success!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
//                        val sharedPreference =
//                            getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
//                        val data = sharedPreference.edit()
//                        data.putString("username", response.body()?.username)
//                        data.putString("email", response.body()?.email)
//                        data.putString("firstName", response.body()?.firstName)
//                        data.putString("lastName", response.body()?.lastName)
//                        data.putString("gender", response.body()?.gender)
//                        data.putString("image", response.body()?.image)
//                        data.commit()
//
                    } else {
                        Toast.makeText(
                            this@LoginActivity,
                            "Enter valid credentials",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(
                        this@LoginActivity,
                        t.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
    }


    private fun checkValidation(): Boolean {
        if (binding.etUsername.text!!.toString().isEmpty()) {
            Toast.makeText(this, "Please enter your username", Toast.LENGTH_SHORT).show()
            return false
        } else if (
            binding.etPassword.text!!.toString().isEmpty()) {
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show()
            return false
        } else if (
            binding.etPassword.length() < 5
        ) {
            Toast.makeText(this, "Password must be of at least 8 digits", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btLogin -> {
                if (checkValidation()) {
                    loginApi(
                        binding.etUsername.text.toString().trim(),
                        binding.etPassword.text.toString().trim()
                    )
                }
            }
            R.id.tvForgetPassword -> {
                startActivity(Intent(this,ForgotPasswordActivity::class.java))
            }

            R.id.btSignUpWithEmail -> {
                startActivity(Intent(this, SignupActivity::class.java))
            }
        }
    }
}