package com.eternalgeek.practice1.core.interactor.featureOne

import com.eternalgeek.practice1.core.data.featureOne.FeatureOneRepository

class FetchNodes(private val repository : FeatureOneRepository) {

    suspend operator fun invoke() = repository.fetchAllNodes()
}