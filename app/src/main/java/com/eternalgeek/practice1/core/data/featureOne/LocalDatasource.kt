package com.eternalgeek.practice1.core.data.featureOne

import com.eternalgeek.practice1.core.domain.featureOne.Node
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun insert(node : Node)

    suspend fun fetchNodes() : Flow<List<Node>>
}