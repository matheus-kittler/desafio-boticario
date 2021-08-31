package kittler.matheus.test.flow.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import kittler.matheus.test.R
import kittler.matheus.test.databinding.ActivityRegisterBinding
import kittler.matheus.test.flow.login.LoginActivity
import kittler.matheus.test.util.clearField
import kittler.matheus.test.util.hideKeyboard
import kittler.matheus.test.util.showFieldError
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = getString(R.string.title_screen_register)
        binding = DataBindingUtil
            .setContentView(this, R.layout.activity_register)

        auth = FirebaseAuth.getInstance()
        binding.tietEmail.hideKeyboard()
        binding.tietPassword.hideKeyboard()
    }

    fun onRegisterUser(view: View) {

        if (binding.tietEmail.text.isNullOrEmpty()
            && binding.tietPassword.text.isNullOrEmpty()
        ) {
            Toast.makeText(
                baseContext, getString(R.string.error_fields), Toast.LENGTH_LONG
            ).show()
        } else {
            register()
        }
    }

    private fun register() {
        auth.createUserWithEmailAndPassword(
            binding.tietEmail.text.toString(),
            binding.tietPassword.text.toString()
        ).addOnCompleteListener(
            this
        )
        { task ->

            when {
                task.isSuccessful -> {
                    clearField(binding.tilEmail)
                    clearField(binding.tilPassword)
                    val intent = Intent(
                        this@RegisterActivity,
                        LoginActivity::class.java
                    )
                    startActivity(intent)
                }
                task.exception.toString() == getString(R.string.error_firebase_email) -> {
                    showFieldError(binding.tilEmail, getString(R.string.error_email))
                }
                task.exception.toString() == getString(R.string.error_firebase_password) -> {
                    showFieldError(binding.tilEmail, getString(R.string.error_password))
                }
            }
        }
    }
}