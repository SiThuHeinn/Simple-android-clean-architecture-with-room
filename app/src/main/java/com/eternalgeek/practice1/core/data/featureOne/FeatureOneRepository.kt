package com.eternalgeek.practice1.core.data.featureOne

import com.eternalgeek.practice1.core.domain.featureOne.Node
import kotlinx.coroutines.flow.Flow

class FeatureOneRepository(private val localDataSource: LocalDataSource) {

    suspend fun saveNode(node : Node) = localDataSource.insert(node)

    suspend fun fetchAllNodes() : Flow<List<Node>> = localDataSource.fetchNodes()

}