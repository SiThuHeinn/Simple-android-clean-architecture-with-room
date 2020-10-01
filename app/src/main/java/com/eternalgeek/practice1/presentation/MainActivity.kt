package com.eternalgeek.practice1.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.eternalgeek.practice1.App
import com.eternalgeek.practice1.R
import com.eternalgeek.practice1.adapter.FeatureOneAdapter
import com.eternalgeek.practice1.core.data.featureOne.FeatureOneRepository
import com.eternalgeek.practice1.core.domain.featureOne.Node
import com.eternalgeek.practice1.utils.getPlainDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_add_node.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    private val adapter by lazy { FeatureOneAdapter(this::onAdapterItemClick)  }

    private val repo by lazy { App.featureOneRepo }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        lifecycleScope.launch {
            repo.fetchAllNodes()
                .catch { error -> Log.d("MainActivity ", "error ${error.message}") }
                .collect {
                    adapter.setNewData(it)
                }
        }

    }

    private fun onAdapterItemClick(node : Node){
        Toast.makeText(this,"Data ${node.title}",Toast.LENGTH_SHORT).show()
    }

    private fun initView() {
        main_rv.layoutManager = LinearLayoutManager(this)
        main_rv.setHasFixedSize(true)
        main_rv.adapter = adapter



        btnAdd.setOnClickListener {
            val dialog = getPlainDialog(R.layout.dialog_add_node,true)
            dialog.addNode.setOnClickListener {

                if (!dialog.et_title.text.isNullOrBlank() && !dialog.et_content.text.isNullOrBlank()) {
                    val node = Node()
                    node.title = dialog.et_title.text.toString()
                    node.content = dialog.et_content.text.toString()
                    saveNode(node)
                    dialog.dismiss()
                }
            }
            dialog.show()
        }


    }

    private fun saveNode(data : Node) {
        lifecycleScope.launch {
            repo.saveNode(data)
        }
    }
}