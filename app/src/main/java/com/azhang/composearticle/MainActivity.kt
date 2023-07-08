package com.azhang.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.azhang.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArticleCard(
                        painterResource(id = R.drawable.bg_compose_background),
                        stringResource(id = R.string.title_text),
                        stringResource(id = R.string.paragraph_one_text),
                        stringResource(id = R.string.paragraph_two_text)
                    )
                }
            }
        }
    }
}

@Composable
fun ArticleCard(
    image: Painter,
    title: String,
    content1: String,
    content2: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Image(painter = image, contentDescription = null)
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = content1,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(text = content2, modifier = Modifier.padding(16.dp), textAlign = TextAlign.Justify)
    }
}

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    ComposeArticleTheme {
        ArticleCard(
            painterResource(id = R.drawable.bg_compose_background),
            stringResource(id = R.string.title_text),
            stringResource(id = R.string.paragraph_one_text),
            stringResource(id = R.string.paragraph_two_text)
        )
    }
}