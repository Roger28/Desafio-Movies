package com.example.teste


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.teste.adapter.Adapter
import com.example.teste.api.VideoResponse
import com.example.teste.interfaces.Comunicator
import com.example.teste.ui.ViewModel
import java.util.*

class MainFragment : Fragment() {
    private var comm: Comunicator? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val mRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        mRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.itemAnimator = DefaultItemAnimator()
        mRecyclerView.setItemViewCacheSize(10)

        val mAdapter = Adapter(comm!!)
        mRecyclerView.adapter = mAdapter

        val mViewModel = ViewModelProviders.of(this).get(ViewModel::class.java)
        mViewModel.movies().observe(this, Observer { videoResponse -> mAdapter.submitList(Objects.requireNonNull<VideoResponse>(videoResponse).videos) })
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        comm = activity as Comunicator?
    }

    override fun onDetach() {
        super.onDetach()
        comm = null
    }

    companion object {

        private var instance: MainFragment? = null

        fun getInstance(): MainFragment? {
            if (instance == null) {
                synchronized(MainFragment::class.java) {
                    if (instance == null) {
                        instance = MainFragment()
                    }
                }
            }
            return instance
        }
    }

}
