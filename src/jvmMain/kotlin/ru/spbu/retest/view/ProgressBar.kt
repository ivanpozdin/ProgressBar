package ru.spbu.retest.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import ru.spbu.retest.ViewModel
import kotlin.time.ExperimentalTime


@Composable
fun Rectangle(shape: Shape, color: Color) {
    Column(modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center)) {
        Box(
            modifier = Modifier.clip(shape).background(color).height(20.dp).width(5.dp)
        )
    }
}

@OptIn(ExperimentalTime::class)
@Composable
fun ProgressBar(viewModel: ViewModel) {
    LazyRow(
        modifier = Modifier.border(BorderStroke(2.dp, Color.Black))
    ) {
        items(100) { index ->
            Rectangle(RectangleShape, if (viewModel.state.progress > index) Color.Red else Color.White)
        }
    }
}
