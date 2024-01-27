package com.github.thailandandroiddeveloper.common.ui.screen.qualify3

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Qualify3Screen() {
    // TODO: Qualify3
    var tagState by remember {
        mutableIntStateOf(value = 0)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "John Doe",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_qualify_3_back),
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_qualify_3_copy),
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer

                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_qualify_3_calendar),
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer

                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_qualify_3_menu),
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer

                        )
                    }
                }
            )
        },

        ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .background(color = Color.White)
        ) {
            ProfilePhotoSection(Modifier.padding(top = 16.dp, start = 16.dp))
            Spacer(
                modifier = Modifier
                    .height(16.dp)
                    .fillMaxWidth()
            )
            TagsSection(4, tagState) { newTag ->
                tagState = newTag
            }
            Spacer(
                modifier = Modifier
                    .height(16.dp)
                    .fillMaxWidth()
            )
            ChatSection(currentTag = tagState)
        }
    }
}

@Composable
fun ProfilePhotoSection(modifier: Modifier = Modifier) {
    val images = mutableListOf(
        R.drawable.img_qualify_3_photo_1,
        R.drawable.img_qualify_3_photo_2,
        R.drawable.img_qualify_3_photo_3
    )

    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .height(320.dp)
    ) {
        items(images) { img ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp)
                    .padding(end = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = img),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(320.dp)
                        .width(160.dp)
                )
            }
        }
    }
}

@Composable
fun TagsSection(tagAmount: Int, currentTag: Int, onTagClick: (Int) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
    ) {
        repeat(tagAmount) { count ->
            OutlinedButton(
                onClick = {
                    onTagClick(count)
                },
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(
                    1.dp,
                    if (count == currentTag) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline
                ),
                modifier = Modifier
                    .padding(end = 8.dp)
                    .width(68.dp)
                    .height(32.dp)
            ) {
                Text(
                    text = "Tag ${count + 1}",
                    style = MaterialTheme.typography.labelLarge,
                    color = if (count == currentTag) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Composable
fun ChatSection(currentTag: Int) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {
        var chatsTag = when (currentTag) {
            0 -> tag1Messages
            1 -> tag2Messages
            2 -> tag3Messages
            else -> tag4Messages
        }

        repeat(chatsTag.size) { index ->
            ProfileCard(
                name = chatsTag[index].name,
                massage = chatsTag[index].message,
                imgProfile = chatsTag[index].img
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ProfileCard(name: String, massage: String, imgProfile: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.surfaceVariant),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = imgProfile),
                contentDescription = null,
                Modifier
                    .padding(end = 8.dp)
                    .clip(CircleShape)
            )
            Column {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = massage,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    softWrap = true,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,

                    )
            }
        }
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify3ScreenPreview() = AppTheme {
    Qualify3Screen()
}
// endregion