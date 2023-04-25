package com.sumit.jetpackdemo.ui.theme.UserListCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sumit.jetpackdemo.R

class UserCard {
    @Composable
    fun ui() {
        Card(
            elevation = 12.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
        ) {
            Row(
                modifier = Modifier
                    .wrapContentHeight(Alignment.CenterVertically)
            ) {
                val painter = painterResource(R.drawable.profile_one).also {

                    Image(
                        painter = it,
                        contentDescription = "Contact profile picture",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .width(150.dp)
                            .height(150.dp)
                            .padding(start = 10.dp)
//                            .clip(CircleShape),
//                        contentScale = ContentScale.Crop

                    )
                }

                Column(
                    modifier = Modifier
                        .padding(start = 50.dp)
                ) {
                    Text("Sumit Kumar", fontWeight = FontWeight.W700)
                    Text("+91 7209998990")
                    Text("Noida city", fontWeight = FontWeight.W300)
                    Text(
                        "Noida ci aksdf la dsflasd lasdf aldsf alsd hgfjjhjhjhjjhjjvjhjhjhjhkjhkjjhjjjhkjhjhjhjhkjhjhkjhkjhjhjkhkjhkjhjkhjhmhbmhbmjhbmhmv flaksdf ads alsdkf ads sumit as dflkas ualdsty kajds faldskfj a aldskfj dsaalksd flkdsa a kdsf alkdsf akljdf asdlfkaj sdfklasd fasdlka lkdsfj asdfjlaskdf aalkdsjf ...",
                        fontWeight = FontWeight.W300
                    )
                }

            }

        }
    }


}