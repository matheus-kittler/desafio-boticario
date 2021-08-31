package kittler.matheus.test.flow.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import kittler.matheus.test.R
import kittler.matheus.test.adapter.NewsAdapter
import kittler.matheus.test.databinding.ActivityNewsBinding
import kittler.matheus.test.model.Recover
import org.koin.android.viewmodel.ext.android.viewModel

class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding
    private val viewModel: NewsViewModel by viewModel()
    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = getString(R.string.title_screen_news)
        binding = DataBindingUtil
            .setContentView(this, R.layout.activity_news)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupObserves()
    }

    private fun setupObserves() {
        val recoversObserver = Observer<List<Recover>> {
            configAdapter(it)
            binding.pbLoading.visibility = View.GONE
        }

        viewModel.recovers.observe(this@NewsActivity, recoversObserver)
    }

    private fun configAdapter(recovers: List<Recover>) {
        adapter = NewsAdapter(recovers, this)
        binding.rcNews.adapter = adapter
    }
}