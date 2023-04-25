package com.sumit.jetpackdemo.ui.theme.BackgroundImage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sumit.jetpackdemo.R

class Background {
    @Composable
    fun BackgroundImage() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Card(
                elevation = 4.dp,
            ) {
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.profile_one),
                        contentDescription = null
                    )
                    Column(modifier = Modifier.padding(10.dp)) {
                        Text("Sumit Kumar", fontWeight = FontWeight.W700)
                        Text("+91 7209998990")
                        Text("Noida city", fontWeight = FontWeight.W300)
                    }
                }
            }
        }
    }
}