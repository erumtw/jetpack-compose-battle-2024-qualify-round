package com.github.thailandandroiddeveloper.common.ui.screen.qualify1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Qualify1Screen() {
    // TODO: Qualify1
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = { /* Handle navigation icon click */ },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Icon(
                            painterResource(id = R.drawable.ic_qualify_1_menu),
                            contentDescription = null,
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = { /* Handle action icon click */ },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Icon(
                            painterResource(id = R.drawable.ic_qualify_1_profile),
                            contentDescription = null,
                        )
                    }
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
//                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
            )
        }
    ) { innerPadding ->
        UserProfileScreen(modifier = Modifier
            .padding(innerPadding)
//            .wrapContentSize()
        )
    }
}

@Composable
fun UserProfileScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = modifier.wrapContentSize().background(Color.White)
    )
    {
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
                .width(379.dp)
                .height(762.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_qualify_1_profile),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxWidth()
            )
            UserProfileDescription(
                name = "John Doe",
                gender = "Male",
                descriptions = "Lorem ipsum dolor sit amet, cd nulla lacinia, quis fringilla lorem imperdiet. Proin in quam vel odio iaculis fringilla.",
                modifier = Modifier.fillMaxWidth()
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 7.5.dp)
                .padding(horizontal = 16.dp)
        ) {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(100.dp),
                containerColor = MaterialTheme.colorScheme.errorContainer,
                contentColor = MaterialTheme.colorScheme.onErrorContainer,
                elevation = FloatingActionButtonDefaults.elevation(0.dp),
                modifier = Modifier
                    .height(48.dp)
                    .width(120.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_1_thumb_down),
                    contentDescription = "Dislike Icon",
                    modifier = Modifier
                        .padding(24.dp, 10.dp)
                )
            }
            Spacer(modifier = Modifier.width(48.dp))
            FloatingActionButton(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(100.dp),
                elevation = FloatingActionButtonDefaults.elevation(0.dp),
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier
                    .height(48.dp)
                    .width(120.dp),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_1_thumb_up),
                    contentDescription = "Like Icon",
                    modifier = Modifier
                        .padding(24.dp, 10.dp)
                )
            }
        }

    }
}

@Composable
fun UserProfileDescription(
    name: String,
    gender: String,
    descriptions: String,
    modifier: Modifier = Modifier
) {
    val verticalSpacer = 8.dp
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.primary.copy(alpha = .75f))
            .padding(20.dp)
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onPrimary,
        )
        Spacer(modifier = Modifier.height(verticalSpacer))
        Row {
            Icon(
                painterResource(id = R.drawable.ic_qualify_1_gender_male),
                contentDescription = "Male Icon",
                tint = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = gender,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
        Spacer(modifier = Modifier.height(verticalSpacer))
        Text(
            text = descriptions,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Spacer(modifier = Modifier.height(22.dp))
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify1ScreenPreview() = AppTheme {
    Qualify1Screen()
}
// endregion