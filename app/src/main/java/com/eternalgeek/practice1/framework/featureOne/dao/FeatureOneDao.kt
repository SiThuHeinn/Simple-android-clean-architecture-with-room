package com.eternalgeek.practice1.framework.featureOne.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eternalgeek.practice1.core.domain.featureOne.Node
import kotlinx.coroutines.flow.Flow


@Dao
interface FeatureOneDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(node : Node)

    @Query("SELECT * FROM nodes ")
     fun fetchNodes() : Flow<List<Node>>
}