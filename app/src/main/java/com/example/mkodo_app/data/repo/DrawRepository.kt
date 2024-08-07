package com.example.mkodo_app.data.repo

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.mkodo_app.domain.DrawModelClass
import kotlinx.coroutines.flow.Flow

interface DrawRepository {
      suspend fun getDraws(context: Context): List<DrawModelClass>
}