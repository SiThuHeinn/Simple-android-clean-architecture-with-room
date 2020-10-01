package com.eternalgeek.practice1

import android.app.Application
import android.util.Log
import com.eternalgeek.practice1.core.data.featureOne.FeatureOneRepository
import com.eternalgeek.practice1.core.domain.featureOne.Node
import com.eternalgeek.practice1.database.MainDatabase
import com.eternalgeek.practice1.framework.featureOne.LocalDataSourceImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class App : Application() {


    companion object{
        private lateinit var instance : App

        private val database : MainDatabase by lazy {
            MainDatabase.buildDatabase(instance)
        }

        val featureOneRepo : FeatureOneRepository by lazy {
            FeatureOneRepository(
                LocalDataSourceImpl(database.featureOneDao())
            )
        }

    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        GlobalScope.launch {
           featureOneRepo.fetchAllNodes().catch {
                error -> Log.d("Main Exception", "Error ${error.message}")
           }.collect{
               if (it.isEmpty()){
                   featureOneRepo.saveNode(Node(title = "Macbook pro 2020 has been released ",content = "As rumor spread over, apple is taking action with new macbook pro 2020..."))
                   featureOneRepo.saveNode(Node(title = "Thinkpad x1 carbon has been released ",content = "As rumor spread over, Lenovo is taking action with Thinkpad x1 carbon 2020..."))
                   featureOneRepo.saveNode(Node(title = "Dell xps 13 developer edition hass been released ",content = "As rumor spread over, Dell is taking action with Dell xps 13 2020..."))

               }
           }
        }
    }
}