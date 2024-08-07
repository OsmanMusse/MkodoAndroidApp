package com.example.mkodo_app.presentation.drawsList

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mkodo_app.R
import com.example.mkodo_app.domain.DrawModelClass
import com.example.mkodo_app.presentation.drawsList.components.BonusCircluarBox
import com.example.mkodo_app.presentation.drawsListDetail.viewmodel.DrawsListDetailVM
import com.example.mkodo_app.theme.euroJackpotColor
import com.example.mkodo_app.theme.mkodoMainColor
import com.example.mkodo_app.theme.vikingLottoColor


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DrawListScreen(
    onButtonClick: (DrawModelClass) -> Unit
) {

    val viewModel = hiltViewModel<DrawsListDetailVM>()

    val drawsList = viewModel.drawListResult.observeAsState().value

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                        Icon(
                            modifier = Modifier.size(120.dp),
                            imageVector = ImageVector.vectorResource(R.drawable.mkodo_logo),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = mkodoMainColor
                )
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(it),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ){
            items(count = drawsList!!.size){index ->
                val currentDraw = drawsList[index]

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clickable(interactionSource = null, enabled = false, indication = null) {},
                    shape = RectangleShape,
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    onClick = {}
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            modifier = Modifier.size(140.dp,50.dp),
                            imageVector = ImageVector.vectorResource(id = if (index == 0) R.drawable.lotto_logo else if(index == 1) R.drawable.vikinglotto_logo else R.drawable.eurojackpot_logo),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(7.dp)
                        ){
                            Text(
                                text = "${currentDraw.drawDate}",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                            )

                            Icon(
                                modifier = Modifier.size(27.dp),
                                imageVector = ImageVector.vectorResource(R.drawable.calendar_icon),
                                contentDescription = null,
                                tint = Color.Unspecified
                            )
                        }
                    }

                    Row {
                        repeat(7){
                            val number = when(it){
                                0 -> currentDraw.number1
                                1 -> currentDraw.number2
                                2 -> currentDraw.number3
                                3 -> currentDraw.number4
                                4 -> currentDraw.number5
                                5 -> currentDraw.number6
                                6 -> currentDraw.bonusBall
                                else -> 100000
                            }

                            println("Bonus Ball === ${it}")
                            if(it == 6) {
                                BonusCircluarBox(
                                    bonusNumber = currentDraw.bonusBall,
                                    color = if (index == 0) Color.Red  else if(index == 1) vikingLottoColor else euroJackpotColor
                                )
                            } else {
                                Box(
                                    modifier = Modifier
                                        .padding(4.dp)
                                        .size(44.dp)
                                        .background(
                                            color = if (index == 0) Color.Red else if (index == 1) vikingLottoColor else euroJackpotColor,
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


                    Button(
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .align(Alignment.End)
                            .border(
                                width = 1.75.dp,
                                color = Color.Black,
                                shape = RoundedCornerShape(25.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent,contentColor = Color.Black),

                        onClick = { onButtonClick(currentDraw) }
                    ) {
                        Text(
                            modifier = Modifier.padding(horizontal = 10.dp).semantics { testTag = "text1" },
                            text = "Draw Details",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center
                        )

                    }

                }

                Divider(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Gray
                )

            }


        }
    }

}


