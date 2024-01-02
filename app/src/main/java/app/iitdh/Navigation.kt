package app.iitdh

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.iitdh.Views.AcademicsView
import app.iitdh.Views.AdmissionsView
import app.iitdh.Views.CampusLifeView
import app.iitdh.Views.HomeView
import app.iitdh.Views.ResearchView

@Composable
fun Navigation(
    navController : NavHostController,
    viewModel: MainViewModel
)
{
   NavHost(
       navController = navController,
       startDestination = Screen.Home.route
   )
   {
       composable(Screen.Home.route)
       {
           HomeView(navController, viewModel)
       }
       composable(Screen.Academics.route)
       {
           AcademicsView()
       }
       composable(Screen.Admissions.route)
       {
           AdmissionsView()
       }
       composable(Screen.CampusLife.route)
       {
           CampusLifeView()
       }
       composable(Screen.Research.route)
       {
           ResearchView()
       }
       composable(Screen.About.route)
       {
           AboutView()
       }
       composable(Screen.Leadership.route)
       {
           LeadershipView()
       }
       composable(Screen.Recruitment.route)
       {
           RecruitmentView()
       }
       composable(Screen.Notifications.route)
       {
           NotificationsView()
       }
       composable(Screen.Alumni.route)
       {
           AlumniView()
       }
   }
}