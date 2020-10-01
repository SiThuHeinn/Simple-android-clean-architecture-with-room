package com.eternalgeek.practice1.core.domain.featureOne

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "nodes")
data class Node(

    @PrimaryKey
    var id : String = UUID.randomUUID().toString(),

    var title : String? = null,

    var content  : String? = null
) : Parcelable