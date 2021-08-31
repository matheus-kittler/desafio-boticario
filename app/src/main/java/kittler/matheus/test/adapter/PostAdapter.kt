package kittler.matheus.test.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kittler.matheus.test.R
import kittler.matheus.test.databinding.RowPostBinding
import kittler.matheus.test.model.User

class PostAdapter(
    context: Context
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    var posts: List<User> = ArrayList()
        set(value) {
            field = ArrayList(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            DataBindingUtil.inflate(layoutInflater, R.layout.row_post, parent, false)
        )
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.also {
            val post = posts[position]
            it.bind(post)
        }
    }

    class PostViewHolder(private val dataBinding: RowPostBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {

        fun bind(user: User) {
            dataBinding.post = user
        }
    }
}