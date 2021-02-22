package com.example.nestedrecyclersample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclersample.data.DataSource
import com.example.nestedrecyclersample.databinding.ActivityMainBinding
import com.example.nestedrecyclersample.ui.adapter.AnimalSectionAdapter
import com.example.nestedrecyclersample.utils.enforceSingleScrollDirection

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var concatAdapter: ConcatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initViews()
    }

    private fun initViews() {
        //create a populated list of sections
        val sections = DataSource.createSections(numberOfSections = 50, itemsPerSection = 25)

        //create an instance of ConcatAdapter
        concatAdapter = ConcatAdapter()

        //create AnimalSectionAdapter for the sections and add to ConcatAdapter
        val sectionAdapter = AnimalSectionAdapter(sections)
        concatAdapter.addAdapter(sectionAdapter)

        //setup the recycler
        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclerView.run {
            layoutManager = linearLayoutManager
            adapter = concatAdapter
            enforceSingleScrollDirection()
        }
    }
}