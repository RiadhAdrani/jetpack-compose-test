package com.adrani.jetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adrani.jetpackcompose.ui.theme.*

@Preview
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            ChipSection(chip = listOf("Sweet Sleep", "Insomnia", "Depression"))
            CurrentMeditation()
        }
    }
}

@Composable
fun GreetingSection(name: String = "Riadh") {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .padding(10.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Good Morning $name",
                color = Color.White,
                fontSize = 40.sp
            )
            Text(
                text = "We wish you have a good day",
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ChipSection(chip: List<String>) {
    var selectChipIndex by remember {
        mutableStateOf(value = 0)
    }
    LazyRow {
        items(chip.size) {
            Box(
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable { selectChipIndex = it }
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (selectChipIndex == it) ButtonBlue else DarkerButtonBlue)
                    .padding(15.dp),
                contentAlignment = Alignment.Center) {
                Text(text = chip[it], color = TextWhite)
            }
        }
    }
}

@Composable
fun CurrentMeditation(color: Color = LightRed) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .clip(RoundedCornerShape(5.dp))
            .fillMaxWidth()
            .background(color = color)
            .padding(10.dp)
    ) {
        Column {
            Text(
                text = "Daily Thought",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = "Meditation 3 - 10 min",
                fontSize= 16.sp,
                color = TextWhite
            )
        }
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(
                    ButtonBlue
                )
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }

    }
}