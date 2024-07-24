package com.example.soungboard

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.nio.file.Files

@Composable
fun Home(context: Context,modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .background(Color(0xFF232222))
            .padding(vertical = 50.dp, horizontal = 20.dp)) {
        Card(context = context,"what_the_dog_doin")
    }

}