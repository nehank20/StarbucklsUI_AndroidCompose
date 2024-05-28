package com.example.nehank.starbucksappui_androidcompose.common_components

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp

@Composable
fun SpacerWidth(width: Dp, modifier: Modifier = Modifier) {
    Spacer(modifier = Modifier.width(width))
}

@Composable
fun SpacerHeight(height: Dp, modifier: Modifier = Modifier) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun CircularImageDrawable(@DrawableRes icon: Int, size: Dp, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .size(size), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = icon), contentDescription = "",
            modifier = Modifier
                .clip(
                    CircleShape
                )
                .size(size)
        )
    }
}

@Composable
fun CircularImageVector(
    @DrawableRes icon: Int,
    size: Dp,
    backgroundSize: Dp,
    tint: Color = Color.Unspecified,
    backgroundColor: Color = Color.Transparent,
    modifier: Modifier = Modifier,
    onButtonClicked: () -> Unit
) {
    Box(
        modifier = modifier
            .clickable {
                onButtonClicked()
            }
            .clip(CircleShape)
            .size(backgroundSize)
            .background(color = backgroundColor, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(painter = painterResource(id = icon), contentDescription = "", tint = tint, modifier = Modifier.size(size))
    }
}