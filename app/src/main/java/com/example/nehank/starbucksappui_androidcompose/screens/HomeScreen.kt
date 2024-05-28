package com.example.nehank.starbucksappui_androidcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nehank.starbucksappui_androidcompose.R
import com.example.nehank.starbucksappui_androidcompose.common_components.CircularImageDrawable
import com.example.nehank.starbucksappui_androidcompose.common_components.CircularImageVector
import com.example.nehank.starbucksappui_androidcompose.common_components.SpacerHeight
import com.example.nehank.starbucksappui_androidcompose.common_components.SpacerWidth
import com.example.nehank.starbucksappui_androidcompose.data.menuList
import com.example.nehank.starbucksappui_androidcompose.ui.theme.GrayColor200
import com.example.nehank.starbucksappui_androidcompose.ui.theme.GrayColor500
import com.example.nehank.starbucksappui_androidcompose.ui.theme.GreenColor700

@Composable
fun HomeScreen(modifier: Modifier = Modifier,  onItemClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopAppBarHomeScreen()
        SpacerHeight(height = 16.dp)
        Text(
            text = stringResource(id = R.string.our_way_of_loving_you_back), style = TextStyle(
                color = Color.Black,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            ), modifier = Modifier.padding(start = 16.dp)
        )
        SpacerHeight(height = 16.dp)
        CustomTextField()
        SpacerHeight(height = 16.dp)
        ChipLayoutRow()
        SpacerHeight(height = 16.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.popular), style = TextStyle(
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = stringResource(id = R.string.see_all), style = TextStyle(
                    color = GreenColor700,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        SpacerHeight(height = 16.dp)
        OrderMenuRowLayout{
            onItemClicked()
        }
    }
}

@Composable
fun OrderMenuRowLayout(modifier: Modifier = Modifier,  onItemClicked: () -> Unit) {
    LazyRow {
        items(6) {
            OrderMenuRowItem {
                onItemClicked()
            }
        }
    }
}

@Composable
fun OrderMenuRowItem(modifier: Modifier = Modifier, onItemClicked: () -> Unit) {

    var isBookmarked by remember {
        mutableStateOf(false)
    }

    val name = buildAnnotatedString {
        append("Chocolate")
        append("\n")
        append("Cappuccino")
    }

    Column(
        Modifier
            .clickable {
                onItemClicked()
            }
            .padding(16.dp)
            .background(
                color = GrayColor500,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 0.dp
            ),

            ) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(GrayColor200)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = "",
                    modifier = Modifier
                        .size(200.dp)
                        .padding(vertical = 16.dp)
                )
            }
        }
        SpacerHeight(height = 16.dp)

        Text(
            text = name, style = TextStyle(
                color = Color.DarkGray,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ), modifier = Modifier.padding(start = 8.dp)
        )
        SpacerHeight(height = 4.dp)
        Row {
            Text(
                text = stringResource(id = R.string._20_00), style = TextStyle(
                    color = GreenColor700,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ), modifier = Modifier.padding(start = 8.dp)
            )
            SpacerWidth(width = 95.dp)
            Icon(
                painter = painterResource(id = R.drawable.love),
                contentDescription = "",
                modifier = Modifier
                    .size(20.dp)
                    .clickable {
                        isBookmarked = !isBookmarked
                    },
                tint = if (isBookmarked) Color.Red else Color.White
            )
        }
        SpacerHeight(height = 8.dp)
    }


}


@Composable
fun ChipLayoutRow(modifier: Modifier = Modifier) {

    var chipSelected by remember {
        mutableStateOf("All")
    }

    LazyRow(modifier = modifier.fillMaxWidth()) {
        items(menuList) { it ->
            ChipLayoutRowItem(
                modifier = Modifier.padding(all = 8.dp),
                titleText = it.title,
                isSelected = chipSelected == it.title
            ) { onChipSelectedText ->
                chipSelected = onChipSelectedText
            }
        }
    }
}

@Composable
fun ChipLayoutRowItem(
    modifier: Modifier = Modifier,
    titleText: String,
    isSelected: Boolean,
    textColor: Color = if (isSelected) Color.White else Color.DarkGray,
    backgroundColor: Color = if (isSelected) GreenColor700 else Color.LightGray,
    onChipSelected: (String) -> Unit
) {
    Text(
        text = titleText,
        style = TextStyle(
            color = textColor,
            fontSize = 20.sp,
        ),
        modifier = modifier
            .background(color = backgroundColor, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable {
                onChipSelected(titleText)
            }
    )
}

@Composable
fun CustomTextField(modifier: Modifier = Modifier) {
    var name by remember {
        mutableStateOf("")
    }

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(color = Color.LightGray, shape = CircleShape)
            .clip(RoundedCornerShape(100.dp)),
        value = name,
        onValueChange = {
            name = it
        },
        leadingIcon = {
            CircularImageVector(
                icon = R.drawable.search,
                size = 20.dp,
                backgroundSize = 40.dp,
                tint = Color.Gray
            ){}
        },
        trailingIcon = {
            CircularImageVector(
                icon = R.drawable.filter,
                size = 20.dp,
                backgroundSize = 40.dp,
                tint = Color.White,
                backgroundColor = GreenColor700
            ){}
        },
        placeholder = {
            Text(text = stringResource(id = R.string.search))
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun TopAppBarHomeScreen(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.Top
    ) {


        CircularImageVector(
            icon = R.drawable.menu,
            size = 20.dp,
            backgroundSize = 40.dp,
            tint = Color.White,
            backgroundColor = Color.LightGray
        ){}
        CircularImageDrawable(icon = R.drawable.logo, size = 80.dp)
        CircularImageVector(
            icon = R.drawable.bag,
            size = 20.dp,
            backgroundSize = 40.dp,
            tint = Color.White,
            backgroundColor = Color.LightGray
        ){}
    }
}
