package com.scookie.network.models

import com.google.gson.annotations.SerializedName

data class WandDTO(

    @SerializedName("wood")
    val wood: String = "",

    @SerializedName("core")
    val core: String = "",

    @SerializedName("length")
    val length: Float = 0F

)
