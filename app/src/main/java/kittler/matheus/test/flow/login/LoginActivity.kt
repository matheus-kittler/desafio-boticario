package kittler.matheus.test.flow.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import kittler.matheus.test.R
import kittler.matheus.test.databinding.ActivityLoginBinding
import kittler.matheus.test.flow.home.HomeActivity
import kittler.matheus.test.flow.register.RegisterActivity
import kittler.matheus.test.util.clearField
import kittler.matheus.test.util.showAlert
import kittler.matheus.test.util.showFieldError

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = getString(R.string.title_screen_login)
        binding = DataBindingUtil
            .setContentView(this, R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        binding.btnConfirm.setOnClickListener {
            confirmLogin()
        }
    }

    fun onLogin(view: View) {
        confirmLogin()
    }

    private fun confirmLogin() {
        if (binding.tietEmail.text.isNullOrEmpty() && binding.tietPassword.text.isNullOrEmpty()) {
            Toast.makeText(baseContext, getString(R.string.error_fields), Toast.LENGTH_LONG).show()
        } else {
            signIn(
                binding.tietEmail.text.toString(),
                binding.tietPassword.text.toString()
            )
        }
    }

    private fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                when {
                    task.isSuccessful -> {
                        clearField(binding.tilEmail)
                        clearField(binding.tilPassword)
                        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    task.exception.toString() == getString(R.string.error_firebase_email) -> {
                        showFieldError(binding.tilEmail, getString(R.string.error_email))
                    }
                    task.exception.toString() == getString(R.string.error_firebase_password) -> {
                        showFieldError(binding.tilPassword, getString(R.string.error_password))
                    }
                    task.exception.toString() == getString(R.string.error_firebase_user) -> {
                        showAlert(
                            getString(R.string.error_title),
                            getString(R.string.error_text)
                        ) {
                            setNeutralButton(getString(R.string.affimative_text_button), null)
                        }
                    }
                }
            }
    }
    fun onRegister(view: View) {
        val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
        startActivity(intent)
    }
}