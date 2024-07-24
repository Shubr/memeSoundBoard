package com.example.soungboard

import android.content.Context
import android.media.Image
import android.media.MediaPlayer
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.unit.dp

@Composable
public fun Card(context: Context, name: String

) {

    val soundUri = "@raw/$name";
    val imgUri = "@drawable/$name"

    val soundId = context.resources.getIdentifier(soundUri, null, context.packageName);
    val imgId = context.resources.getIdentifier(imgUri, null, context.packageName);
    val audio = MediaPlayer.create(context, soundId)

    Box(modifier = Modifier
        .clickable { audio.start() }
        .clip(RoundedCornerShape(10.dp))
        .height(100.dp)
        .width(100.dp)
        .background(
            Color(0xFFD9D9D9)
        )
        ){
        Image(
            painterResource(imgId),contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize())
        var isFavorite by remember { mutableStateOf(false) }
        var color by remember{ mutableStateOf(Color.White) }
        IconToggleButton(modifier = Modifier.align(Alignment.TopEnd),
            checked = isFavorite,
            onCheckedChange = {
                isFavorite = !isFavorite
                color = if(isFavorite) Color.Red else Color.White
            }
        ) {
            Icon(
                tint = color,
                imageVector = if (isFavorite) {
                    Icons.Filled.Favorite
                } else {
                    Icons.Default.FavoriteBorder
                },
                contentDescription = null
            )
        }
    }
}
