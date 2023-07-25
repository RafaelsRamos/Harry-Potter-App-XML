package com.scookie.network.models

import com.google.gson.annotations.SerializedName
import com.scookie.domainmodel.Wand

data class WandDTO(

    @SerializedName("wood")
    val wood: String = "",

    @SerializedName("core")
    val core: String = "",

    @SerializedName("length")
    val length: Float = 0F

)

internal fun WandDTO.toModel() = Wand(
    wood = wood,
    core = core,
    length = length
)
