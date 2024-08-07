package com.example.mkodo_app.presentation.drawsList.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BonusCircluarBox(bonusNumber: Int, color: Color){
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .padding(4.dp)
            .border(3.dp, color, CircleShape)
            .size(44.dp)
            .background(Color.White)
            .clickable { },
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "$bonusNumber",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}