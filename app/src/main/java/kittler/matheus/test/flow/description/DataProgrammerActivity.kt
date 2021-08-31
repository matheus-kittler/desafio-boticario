package kittler.matheus.test.flow.description

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kittler.matheus.test.R
import kittler.matheus.test.databinding.ActivityDataProgrammerBinding

class DataProgrammerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataProgrammerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = getString(R.string.title_data_programmer)
        binding = DataBindingUtil
            .setContentView(this, R.layout.activity_data_programmer)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun onGithub(view: android.view.View) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(getString(R.string.github))).toString()
        startActivity(intent)
    }
    fun onLinkedin(view: android.view.View) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(getString(R.string.linkedin))).toString()
        startActivity(intent)
    }
}