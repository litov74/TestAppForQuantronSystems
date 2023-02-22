package ru.litov74dev.testapplication.network.models

import com.google.gson.annotations.SerializedName

data class TrendingListModel(
    @SerializedName("page"          ) var page         : Int?               = null,
    @SerializedName("results"       ) var results      : ArrayList<FilmModel> = arrayListOf(),
    @SerializedName("total_pages"   ) var totalPages   : Int?               = null,
    @SerializedName("total_results" ) var totalResults : Int?               = null
)
