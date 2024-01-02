package app.iitdh

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView()
{
    val navController : NavHostController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val viewModel : MainViewModel = viewModel()
    val drawerList = listOf("About", "Leadership", "Recruitment", "Notifications", "Alumni")
    val currentScreen = remember{ viewModel.currentScreen.value }
    val controller : NavController = rememberNavController()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val headtitle = remember { mutableStateOf(currentScreen) }

    Scaffold (
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(viewModel.currentScreen.value, color = Color.White) },
                navigationIcon = { IconButton( onClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                } )
                {
                    Icon(imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        Modifier.background(Color.White))
                } },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF89288f)) )
        },
        drawerContent = {
            LazyColumn (modifier = Modifier.padding(16.dp)
            ) {
                items(drawerList)
                {
                    item -> DrawerItem(
                    selected = currentRoute == item,
                    title = item,
                    onDrawerClicked = {
                        headtitle.value = item
                        viewModel.currentScreen.value = item
                        navController.navigate(item){
                            popUpTo("home") {
                                inclusive = false
                            }
                        }
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }}
                    )
                }
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Navigation(navController, viewModel)
        }
    }
}

@Composable
fun DrawerItem(
    selected : Boolean,
    title : String,
    onDrawerClicked : () -> Unit
)
{
    val background = if (selected) Color(0xFF89288f) else Color.White
    val textColor = if (selected) Color.White else Color(0xFF89288f)

    Column {
        Row (modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp).background(background),
            horizontalArrangement = Arrangement.SpaceBetween)
        {
            Text(title, modifier = Modifier.padding(start = 16.dp), fontSize = 20.sp, color = textColor)

            Icon(imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.padding(end = 16.dp).clickable { onDrawerClicked() })
        }
        Divider(color = Color.Gray)
    }
}

@Composable
fun AboutView()
{
    val drawerList = listOf("IIT Dharwad", "Campus", "Reports", "Ranking")

    LazyColumn (modifier = Modifier.padding(16.dp)
    ) {
        items(drawerList)
        {
                item -> DrawerItem(
            selected = false,
            title = item,
            onDrawerClicked = {  }
        )
        }
    }
}

@Composable
fun LeadershipView()
{
    val drawerList = listOf("Board of Governance", "Senate Members", "Committee", "Administration")

    LazyColumn (modifier = Modifier.padding(16.dp)
    ) {
        items(drawerList)
        {
                item -> DrawerItem(
            selected = false,
            title = item,
            onDrawerClicked = {  }
        )
        }
    }
}

@Composable
fun RecruitmentView()
{
    val drawerList = listOf("Faculty", "Staff", "iPDFs & Others", "Announcements")

    LazyColumn (modifier = Modifier.padding(16.dp)
    ) {
        items(drawerList)
        {
                item -> DrawerItem(
            selected = false,
            title = item,
            onDrawerClicked = {  }
        )
        }
    }
}

@Composable
fun NotificationsView()
{
    val drawerList = listOf("Events", "News", "Outreach", "Tenders")

    LazyColumn (modifier = Modifier.padding(16.dp)
    ) {
        items(drawerList)
        {
                item -> DrawerItem(
            selected = false,
            title = item,
            onDrawerClicked = {  }
        )
        }
    }
}

@Composable
fun AlumniView()
{
    val drawerList = listOf("Details", "Alumni Corner", "Alumni Center", "Donate to us")

    LazyColumn (modifier = Modifier.padding(16.dp)
    ) {
        items(drawerList)
        {
                item -> DrawerItem(
            selected = false,
            title = item,
            onDrawerClicked = {  }
        )
        }
    }
}