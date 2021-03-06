/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package red.torch.composespeed.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import red.torch.composespeed.R
import red.torch.composespeed.data.gardenMocks
import red.torch.composespeed.data.themeMocks
import red.torch.composespeed.ui.common.firstBaselineToTopAndBottom
import red.torch.composespeed.ui.theme.MyTheme

@Composable
fun HomeScreen() {

    Scaffold(
        bottomBar = {
            HomeNavigationBar()
        },
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            item {
                Spacer(Modifier.height(40.dp))
            }
            item {
                HomeSearchField()
            }
            item {
                Text(
                    stringResource(id = R.string.home_browse_theme),
                    style = typography.h1,
                    modifier = Modifier
                        .firstBaselineToTopAndBottom(32.dp, 0.dp)
                        .padding(horizontal = 16.dp)
                )
                LazyRow(
                    contentPadding = PaddingValues(16.dp)
                ) {
                    themeMocks.forEach {
                        item {
                            ThemeItem(it.first, it.second)
                            Spacer(modifier = Modifier.width(8.dp))
                        }
                    }
                }
            }
            item {
                GardenTitle()
            }
            gardenMocks.forEach {
                item {
                    GardenItem(it.first, it.second, it.third)
                }
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun WelcomeScreenLight() {
    MyTheme(darkTheme = false) {
        HomeScreen()
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun WelcomeScreenDark() {
    MyTheme(darkTheme = true) {
        HomeScreen()
    }
}
