package com.example.teste


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.example.teste.model.Video
import com.squareup.picasso.Picasso

import java.util.Objects


class DetailsFragment : Fragment() {

    private var title: TextView? = null
    private var thumbnail: ImageView? = null
    private var video: Video? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Objects.requireNonNull<ActionBar>((Objects.requireNonNull<FragmentActivity>(activity) as AppCompatActivity).supportActionBar).setDisplayHomeAsUpEnabled(true)

        if (arguments != null) {
            video = arguments!!.getSerializable("video") as Video
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_details, container, false)
        setHasOptionsMenu(true)
        init(view)
        return view
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        Objects.requireNonNull<FragmentActivity>(activity).onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    private fun init(view: View) {
        thumbnail = view.findViewById(R.id.header)
        Picasso.get().load(video!!.poster_path).into(thumbnail)
        title = view.findViewById(R.id.textView_movieDetails)
        title!!.text = video!!.overview
    }

    override fun onDetach() {
        super.onDetach()
        Objects.requireNonNull<ActionBar>((Objects.requireNonNull<FragmentActivity>(activity) as AppCompatActivity).supportActionBar).setDisplayHomeAsUpEnabled(false)
    }

    companion object {

        fun getInstance(video: Video): DetailsFragment {
            val fragment = DetailsFragment()
            val args = Bundle()
            args.putSerializable("video", video)
            fragment.arguments = args
            return fragment
        }
    }
}
