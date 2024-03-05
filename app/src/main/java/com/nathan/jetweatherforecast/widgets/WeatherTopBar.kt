package com.nathan.jetweatherforecast.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherTopBar(
    title: String = "Title",
    icon: ImageVector? = null,
    isMainScreen: Boolean = true,
    elevation: Dp = 0.dp,
    navController: NavController,
    onAddActionClicked: () -> Unit = {},
    onButtonClicked: () -> Unit = {},
    ) {
    Surface(shadowElevation = elevation) {
        TopAppBar(
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color.Transparent,
                titleContentColor = MaterialTheme.colorScheme.secondary,
            ),
            title = {
                Text(text = title,
                    modifier = Modifier.padding(start = 30.dp),
                )
            },
            actions = {
                      if (isMainScreen) {
                          IconButton(onClick = { /*TODO*/ }) {
                              Icon(imageVector = Icons.Default.Search,
                                  contentDescription = "Search Icon")

                          }
                          IconButton(onClick = { /*TODO*/ }) {
                              Icon(imageVector = Icons.Rounded.MoreVert,
                                  contentDescription = "More Icon")
                          }
                      } else {
                          Box{}
                      }
            },
            navigationIcon = {
                if (icon != null) {
                    Icon(imageVector = icon, contentDescription = null,
                        tint = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.clickable { onButtonClicked.invoke() },
                        )
                } else {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null,
                        tint = Color.Transparent,
                        )
                }
            }
        )
    }
}