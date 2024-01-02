package app.iitdh.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class AcademicData(
    val category : String,
    val list : List<String>
)

@Composable
fun AcademicsView()
{
    val academicData = listOf(
        AcademicData("Departments", listOf("BioSciences and Bioengineering", "Chemical Engineering", "Chemistry", "Civil & Infrastructure Engineering", "Computer Science and Engineering", "Electrical, Electronics, and Communication Engineering", "Humanities and Social Sciences", "Mathematics", "Mechanical, Material and Aerospace Engineering", "Physics")),
        AcademicData("Programs", listOf("UG", "BS-MS", "M.TECH", "MS", "PhD")),
        AcademicData("Announcements", listOf("Calendar", "Circular", "Curriculum", "Exams", "Holidays", "Time Table")),
        AcademicData("Faculty Advisers", listOf()),
        AcademicData("Library", listOf())
    )

    LazyColumn (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(academicData)
        {
            AcademicData -> ShowAcademics(AcademicData)
        }
    }
}

@Composable
fun ShowAcademics(AcademicData: AcademicData)
{
    var isExpanded by remember { mutableStateOf(false) }

    Column {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween)
        {
            var textColor = if (isExpanded) Color(0xFF89288f) else Color.Black

            Text(AcademicData.category,
                modifier = Modifier.padding(start = 16.dp),
                fontSize = 26.sp,
                color = textColor)

            Icon(imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .clickable { isExpanded = !isExpanded })
        }

        if (isExpanded)
        {
            AcademicData.list.forEach { item ->
                showItems(item)
            }
        }

        Divider(color = Color.Black)
    }
}

@Composable
fun showItems( dept : String )
{
    Column (
        modifier = Modifier.fillMaxWidth().background(color = Color(0xFF89288f))
    ) {
        Text(dept, modifier = Modifier.padding(8.dp), color = Color.White, fontSize = 20.sp)
        Divider(color = Color.Gray)
    }
}

@Preview(showBackground = true)
@Composable
fun AcademicsPreview()
{
    AcademicsView()
}