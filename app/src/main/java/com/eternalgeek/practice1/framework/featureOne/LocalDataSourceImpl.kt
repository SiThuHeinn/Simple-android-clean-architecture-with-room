package com.eternalgeek.practice1.framework.featureOne

import com.eternalgeek.practice1.core.data.featureOne.LocalDataSource
import com.eternalgeek.practice1.core.domain.featureOne.Node
import com.eternalgeek.practice1.framework.featureOne.dao.FeatureOneDao
import kotlinx.coroutines.flow.Flow


class LocalDataSourceImpl(private val dao : FeatureOneDao) : LocalDataSource {
    override suspend fun insert(node: Node) {
        dao.insert(node)
    }

    override suspend fun fetchNodes() : Flow<List<Node>> = dao.fetchNodes()
}