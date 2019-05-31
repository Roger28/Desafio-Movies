package com.example.teste.adapter

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.teste.DetailsFragment
import com.example.teste.R
import com.example.teste.interfaces.Comunicator
import com.example.teste.model.Video
import com.squareup.picasso.Picasso

internal class Adapter(private val comm: Comunicator) : ListAdapter<Video, Adapter.Holder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): Holder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item, viewGroup, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val current = getItem(position)
        holder.textViewVideoTitle.text = current.title
        Picasso.get().load(current.poster_path).into(holder.imageViewVideoThumbnail)
    }

    internal inner class Holder(v: View) : RecyclerView.ViewHolder(v) {

        val textViewVideoTitle: TextView = v.findViewById(R.id.textView_video_title)
        val imageViewVideoThumbnail: ImageView = v.findViewById(R.id.imageView_video_thumbnail)

        init {

            v.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val video = getItem(position)
                    comm.replaceFragment(R.id.fragment, DetailsFragment.getInstance(video))
                }
            }
        }
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Video>() {
            override fun areItemsTheSame(example: Video, t1: Video): Boolean {
                return example.title == t1.title
            }

            override fun areContentsTheSame(example: Video, t1: Video): Boolean {
                return example.poster_path == t1.poster_path
            }
        }
    }

}
