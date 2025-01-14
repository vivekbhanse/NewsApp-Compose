package com.loc.newsapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.constraintlayout.widget.ConstraintLayout

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowStringList(users: List<String>) {
    var editValue by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
      

    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewList() {

    val list = listOf("Vivek", "Kishor", "Bhanse")

    ShowStringList(users = list)
}