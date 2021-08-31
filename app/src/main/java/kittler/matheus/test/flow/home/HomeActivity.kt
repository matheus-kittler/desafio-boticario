package kittler.matheus.test.flow.home


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kittler.matheus.test.R
import kittler.matheus.test.adapter.PostAdapter
import kittler.matheus.test.databinding.ActivityHomeBinding
import kittler.matheus.test.flow.description.DataProgrammerActivity
import kittler.matheus.test.flow.news.NewsActivity
import kittler.matheus.test.model.User
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var user: User
    private val viewModel: HomeViewModel by viewModel()
    private val adapter: PostAdapter by lazy {
        PostAdapter(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = getString(R.string.title_screen_home)
        binding = DataBindingUtil
            .setContentView(this, R.layout.activity_home)

        setupObserves()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.rcPost.apply {
            adapter = this@HomeActivity.adapter
            layoutManager = LinearLayoutManager(this@HomeActivity, RecyclerView.VERTICAL, false)
        }
    }

    private fun setupObserves() {
        viewModel.apply {
            getPosts()
            posts.observe(this@HomeActivity) {
                adapter.posts = it ?: arrayListOf()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       return when(item.itemId) {
            R.id.menu_news -> {
                val intent = Intent(this@HomeActivity, NewsActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.menu_programmer_data -> {
                val intent = Intent(this@HomeActivity, DataProgrammerActivity::class.java)
                startActivity(intent)
                true
            }
           else -> {
               false
           }
        }

    }
}