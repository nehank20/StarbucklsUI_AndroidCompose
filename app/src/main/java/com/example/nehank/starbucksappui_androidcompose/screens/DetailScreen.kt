package com.example.nehank.starbucksappui_androidcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nehank.starbucksappui_androidcompose.R
import com.example.nehank.starbucksappui_androidcompose.common_components.CircularImageDrawable
import com.example.nehank.starbucksappui_androidcompose.common_components.CircularImageVector
import com.example.nehank.starbucksappui_androidcompose.common_components.SpacerHeight
import com.example.nehank.starbucksappui_androidcompose.common_components.SpacerWidth
import com.example.nehank.starbucksappui_androidcompose.ui.theme.GrayColor200
import com.example.nehank.starbucksappui_androidcompose.ui.theme.GreenColor700

@Composable
fun DetailScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopAppBarDetailScreen()
        SpacerHeight(height = 16.dp)
        CounterLayout()
        SpacerHeight(height = 8.dp)
        ProductDescription()

    }
}

@Composable
fun ProductDescription(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter)
        ) {
            Text(
                text = stringResource(id = R.string.coffee), style = TextStyle(
                    fontSize = 20.sp,
                    color = GreenColor700
                )
            )
            SpacerHeight(height = 8.dp)

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(id = R.string.chocolate_cappuccino), style = TextStyle(
                        fontSize = 24.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                )

                Row {
                    Image(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = "",
                        modifier = Modifier.size(20.dp)
                    )
                    SpacerWidth(width = 2.dp)
                    Text(text = "4.5", style = TextStyle(
                        fontSize = 18.sp,
                        color = Color.DarkGray
                    ))
                }

            }

            SpacerHeight(height = 16.dp)
            Text(
                text = stringResource(id = R.string.lorem_ipsum_), style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Gray
                )
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter), onClick = { }, colors = ButtonDefaults.buttonColors(
                containerColor = GreenColor700,
                contentColor = Color.White
            )
        ) {
            Text(text = stringResource(id = R.string.add_to_bag), style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold))
        }
    }
}

@Composable
fun CounterLayout(modifier: Modifier = Modifier) {

    var counter by remember {
        mutableIntStateOf(0)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(color = GrayColor200, shape = RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "",
            modifier = Modifier.size(250.dp)
        )
        SpacerHeight(height = 32.dp)
        Row(
            modifier = Modifier.background(Color.White, shape = RoundedCornerShape(100.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularImageVector(
                icon = R.drawable.plus,
                size = 20.dp,
                backgroundSize = 40.dp,
                backgroundColor = GreenColor700
            ) {
                counter++
            }
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = counter.toString(), style = TextStyle(
                    fontSize = 32.sp,
                    color = GreenColor700
                )
            )
            CircularImageVector(
                icon = R.drawable.minus,
                size = 20.dp,
                backgroundSize = 40.dp,
                backgroundColor = GreenColor700
            ) {
                if (counter != 0) {
                    counter--
                }

            }
        }
        SpacerHeight(height = 24.dp)
    }
}

@Composable
fun TopAppBarDetailScreen(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.Top
    ) {


        CircularImageVector(
            icon = R.drawable.back,
            size = 20.dp,
            backgroundSize = 40.dp,
            tint = Color.White,
            backgroundColor = Color.LightGray
        ) {

        }
        CircularImageDrawable(icon = R.drawable.logo, size = 80.dp)
        CircularImageVector(
            icon = R.drawable.bag,
            size = 20.dp,
            backgroundSize = 40.dp,
            tint = Color.White,
            backgroundColor = Color.LightGray
        ) {

        }
    }
}

@Preview
@Composable
private fun DetailScreen_Preview() {
    DetailScreen()
}