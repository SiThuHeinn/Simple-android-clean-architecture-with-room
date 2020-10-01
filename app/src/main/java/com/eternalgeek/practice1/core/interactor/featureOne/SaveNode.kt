package com.eternalgeek.practice1.core.interactor.featureOne

import com.eternalgeek.practice1.core.data.featureOne.FeatureOneRepository
import com.eternalgeek.practice1.core.domain.featureOne.Node

class SaveNode(private val repository : FeatureOneRepository) {

    suspend operator fun invoke(node : Node) = repository.saveNode(node)
}