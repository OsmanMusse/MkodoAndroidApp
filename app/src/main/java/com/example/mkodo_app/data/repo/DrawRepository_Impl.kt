package com.example.mkodo_app.data.repo

import android.content.Context
import com.example.mkodo_app.domain.Draw
import com.example.mkodo_app.domain.DrawModelClass
import com.example.mkodo_app.util.GeneralHelper
import com.google.gson.Gson
import java.io.IOException

class DrawRepository_Impl: DrawRepository {
    override suspend fun getDraws(context:Context): List<DrawModelClass> {
        try {
            val jsonString = GeneralHelper.getJSONFromAssets(context)
            val draws = Gson().fromJson(jsonString, Draw::class.java)
            // imitate an network Request by delaying
//            delay(5000)
            return draws.draws.toList()
        } catch (ex: IOException) {
            return emptyList()
        }
    }
}
