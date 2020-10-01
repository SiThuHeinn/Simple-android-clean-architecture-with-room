package com.eternalgeek.practice1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.eternalgeek.practice1.core.domain.featureOne.Node
import com.eternalgeek.practice1.framework.featureOne.dao.FeatureOneDao


@Database(entities = [Node::class],version = 1, exportSchema = false)
abstract class MainDatabase : RoomDatabase(){

    abstract fun featureOneDao() : FeatureOneDao

    companion object{

        private const val DATABASE_NAME = "MainDatabase"

        fun buildDatabase(context : Context) : MainDatabase {

            return Room.databaseBuilder(
                context,
                MainDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}