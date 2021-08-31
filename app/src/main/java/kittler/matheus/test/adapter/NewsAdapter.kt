package kittler.matheus.test.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kittler.matheus.test.R
import kittler.matheus.test.databinding.RowNewsBinding
import kittler.matheus.test.model.New
import kittler.matheus.test.model.Recover
import kittler.matheus.test.model.RecoverResponse

class NewsAdapter(
    private val news: List<Recover>,
     context: Context
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            DataBindingUtil.inflate(layoutInflater, R.layout.row_news, parent, false)
        )
    }

    override fun getItemCount(): Int = news.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.also {
            val news = news[position]
            it.bind(news)
        }
    }

    class NewsViewHolder(private val dataBinding: RowNewsBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {

        fun bind(news: Recover) {
            dataBinding.news = news
        }
    }
}