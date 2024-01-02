package app.iitdh

sealed class Screen ( val route : String )
{
    object Home : Screen("home")
    object Academics : Screen("academics")
    object Admissions : Screen("admissions")
    object CampusLife : Screen("campuslife")
    object Research : Screen("research")
    object About : Screen("about")
    object Leadership : Screen("leadership")
    object Recruitment : Screen("recruitment")
    object Notifications : Screen("notifications")
    object Alumni : Screen("alumni")
}