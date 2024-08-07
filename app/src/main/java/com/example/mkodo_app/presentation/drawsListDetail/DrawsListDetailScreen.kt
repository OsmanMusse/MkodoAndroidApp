package com.example.mkodo_app.presentation.drawsListDetail

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mkodo_app.R
import com.example.mkodo_app.domain.DrawModelClass
import com.example.mkodo_app.presentation.drawsList.components.BonusCircluarBox
import com.example.mkodo_app.theme.euroJackpotColor
import com.example.mkodo_app.theme.mkodoMainColor
import com.example.mkodo_app.theme.vikingLottoColor
import java.text.NumberFormat

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawsListDetailScreen(onBackClick:() -> Unit, draw: DrawModelClass) {
    println("DETAILS SCREEN == ${draw}")

    val index = draw.id
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = { onBackClick() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }

                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = mkodoMainColor
                )
            )
        }
    ) {
        Card(
            elevation = CardDefaults.elevatedCardElevation(4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
                .clickable(interactionSource = null, enabled = false, indication = null) {},
            shape = RectangleShape,
            colors = CardDefaults.cardColors(containerColor = Color.White),
            onClick = {}
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(7.dp)
                ){

                    Icon(
                        modifier = Modifier.size(27.dp),
                        imageVector = ImageVector.vectorResource(R.drawable.calendar_icon),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )

                    Text(
                        text = "${draw.drawDate}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(7.dp)
                ){

                    Text(
                        text = "Draw Number: ${draw.id}",
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Row(
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {
                repeat(7){
                    val number = when(it){
                        0 -> draw.number1
                        1 -> draw.number2
                        2 -> draw.number3
                        3 -> draw.number4
                        4 -> draw.number5
                        5 -> draw.number6
                        6 -> draw.bonusBall
                        else -> 100000
                    }

                    println("Bonus Ball === ${it}")
                    if(it == 6) {
                        BonusCircluarBox(
                            bonusNumber = draw.bonusBall,
                            color = if (index == "draw-1") Color.Red  else if(index == "draw-2") vikingLottoColor else euroJackpotColor
                        )
                    } else {
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .size(44.dp)
                                .background(
                                    color = if (index == "draw-1") Color.Red else if (index == "draw-2") vikingLottoColor else euroJackpotColor,
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                text = "$number",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                horizontalArrangement = Arrangement.Center
            ){
                val formattedPrice = NumberFormat.getIntegerInstance().format(draw.topPrize)
                Text(
                    text = "Total Prize: "
                )
                Text(

                    text = " £$formattedPrice",
                    color = Color.Black,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold

                )
                
                Spacer(modifier = Modifier.height(50.dp))
            }



        }
        

    }
}