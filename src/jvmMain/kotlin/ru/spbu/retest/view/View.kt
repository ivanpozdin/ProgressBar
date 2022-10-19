package ru.spbu.retest.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import ru.spbu.retest.ViewModel


@Composable
fun View(viewModel: ViewModel) {
    MaterialTheme {
        Column {
            Button({ viewModel.doOnClick() }) {
                Text(text = "Start")
                if (viewModel.state.isClicked) {
                    LaunchedEffect(viewModel.state) {
                        viewModel.doProgress()
                        if (viewModel.state.progress > 100) {
                            return@LaunchedEffect
                        }
                    }
                }
            }
            ProgressBar(viewModel)
            Text("${if (viewModel.state.progress < 100) viewModel.state.progress else 100}%")
            if (viewModel.state.progress >= 100) {
                Button(onClick = { viewModel.doOnClickFinish() }) {
                    Text(text = "Finish")
                }
            }
        }
    }
}
