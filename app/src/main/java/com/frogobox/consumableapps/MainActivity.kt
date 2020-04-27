package com.frogobox.consumableapps

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.frogobox.consumableapps.base.BaseActivity
import com.frogobox.consumableapps.consumable.newsapi.NewsActivity
import com.frogobox.consumableapps.consumable.thesportdbapi.SportActivity
import com.frogobox.consumableapps.util.Helper
import com.frogobox.recycler.boilerplate.adapter.callback.FrogoAdapterCallback
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_list_main.view.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()

    }

    private fun listData(): MutableList<Library> {
        val listData = mutableListOf<Library>()
        val rawJsonData = Helper.getJsonAssets(this, "library.json")
        val listLibraryType = object : TypeToken<List<Library>>() {}.type
        val tempList: List<Library> = Gson().fromJson(rawJsonData, listLibraryType)
        listData.addAll(tempList)
        return listData
    }

    private fun setupRecyclerView() {

        val adapterCallback = object : FrogoAdapterCallback<Library> {
            override fun onItemClicked(data: Library) {
                setupIntentActivity(data.code)
            }

            override fun onItemLongClicked(data: Library) {
            }

            override fun setupInitComponent(view: View, data: Library) {
                Glide.with(this@MainActivity).load(data.image).into(view.iv_icon)
                view.tv_title.text = data.name
                view.tv_link.text = data.link
            }
        }

        rv_main.injector<Library>()
            .addData(listData())
            .addCustomView(R.layout.content_list_main)
            .addEmptyView(null)
            .addCallback(adapterCallback)
            .createLayoutLinearVertical(false)
            .createAdapter()
            .build(rv_main)

    }

    private fun setupIntentActivity(codeActivity: Int) {
        when (codeActivity) {
            0 -> {
                startActivity(Intent(this@MainActivity, NewsActivity::class.java))
            }
            1 -> {
                startActivity(Intent(this@MainActivity, SportActivity::class.java))
            }
            2 -> {
                startActivity(Intent(this@MainActivity, NewsActivity::class.java))
            }
            3 -> {
                startActivity(Intent(this@MainActivity, NewsActivity::class.java))
            }
            4 -> {
                startActivity(Intent(this@MainActivity, NewsActivity::class.java))
            }
            5 -> {
                startActivity(Intent(this@MainActivity, NewsActivity::class.java))
            }
            6 -> {
                startActivity(Intent(this@MainActivity, NewsActivity::class.java))
            }
            7 -> {
                startActivity(Intent(this@MainActivity, NewsActivity::class.java))
            }
        }
    }

}
