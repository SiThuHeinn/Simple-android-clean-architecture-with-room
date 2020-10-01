package com.eternalgeek.practice1.framework.interactor

import com.eternalgeek.practice1.core.interactor.featureOne.FetchNodes
import com.eternalgeek.practice1.core.interactor.featureOne.SaveNode

data class FeatureOneInteractor(val saveNode : SaveNode, val fetchNodes: FetchNodes)