
// Modern Dashboard UI with Jetpack Compose
// Created by ChatGPT - Inspired by futuristic design

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModernDashboardUI()
        }
    }
}

@Composable
fun ModernDashboardUI() {
    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF0F2027), Color(0xFF203A43), Color(0xFF2C5364))
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradient)
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome Back",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            DashboardCard("Balance", "$3,250", R.drawable.ic_wallet)
            DashboardCard("Tasks", "12 Pending", R.drawable.ic_task)
            DashboardCard("Analytics", "View Report", R.drawable.ic_chart)
        }
    }
}

@Composable
fun DashboardCard(title: String, value: String, iconResId: Int) {
    Card(
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color.White.copy(alpha = 0.1f),
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .border(
                width = 1.dp,
                color = Color.White.copy(alpha = 0.2f),
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Row(
            Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = iconResId),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(text = title, color = Color.White, fontSize = 16.sp)
                Text(text = value, color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}
