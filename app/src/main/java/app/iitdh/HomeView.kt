package app.iitdh

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeView(
    navController: NavController,
    viewModel: MainViewModel)
{
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.wrapContentSize().background(color = Color.White).padding(16.dp).border(2.dp, color = Color(0xFF89288f))
        ) {
            Text("IIT DHARWAD", color = Color(0xFF89288f), fontSize = 32.sp,
                modifier = Modifier.padding(16.dp))
        }

        Image(
            painter = painterResource(id = R.drawable.emblem),
            contentDescription = null,
            modifier = Modifier.padding(16.dp).size(150.dp)
        )

        Text("Home Screen For IIT Dharwad Website", color = Color(0xFF89288f))

        var card_titles = listOf("ACADEMICS", "ADMISSIONS", "CAMPUS LIFE", "RESEARCH")
        var card_icons  = listOf(R.drawable.academics, R.drawable.admissions, R.drawable.campuslife, R.drawable.research)

        LazyVerticalGrid(
            GridCells.Fixed(2),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.Center)
        {
            items(card_titles.indices.toList()){
                index ->
                Cardd(card_titles[index], card_icons[index], navController, viewModel)
            }
        }
    }

    DisposableEffect(navController)
    {
        val listener = NavController.OnDestinationChangedListener { _, _, _ ->
            viewModel.currentScreen.value = when (navController.currentDestination?.route) {
                Screen.Academics.route -> "ACADEMICS"
                Screen.Admissions.route -> "ADMISSIONS"
                Screen.CampusLife.route -> "CAMPUS LIFE"
                Screen.Research.route -> "RESEARCH"
                else -> "HOME"
            }
        }

        // Add the listener
        navController.addOnDestinationChangedListener(listener)

        // Remove the listener when the composable is disposed
        onDispose {
            navController.removeOnDestinationChangedListener(listener)
        }
    }
}

@Composable
fun Cardd(
    title : String,
    icon : Int,
    navController: NavController,
    viewModel: MainViewModel)
{
    Card (
        modifier = Modifier.padding(16.dp).size(200.dp).clickable { navigateToScreen(navController, title) },
        border = BorderStroke(2.dp, color = Color.White)
    ) {
        Column (
            modifier = Modifier.fillMaxSize().background(color = Color(0xFF89288f)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.padding(16.dp).size(50.dp)
            )
            Text(title, color = Color.White, fontSize = 24.sp)
        }
    }
}

fun navigateToScreen(
    navController: NavController,
    title: String)
{
    when (title) {
        "ACADEMICS" -> navController.navigate(Screen.Academics.route)
        "ADMISSIONS" -> navController.navigate(Screen.Admissions.route)
        "CAMPUS LIFE" -> navController.navigate(Screen.CampusLife.route)
        "RESEARCH" -> navController.navigate(Screen.Research.route)
    }
}