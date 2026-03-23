package com.example.shoppinglistorganizer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.shoppinglistorganizer.ui.theme.ShoppingLIstOrganizerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingLIstOrganizerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

data class ShoppingItem(
    val name: String,
    val isBought: Boolean = false
)

@Composable
fun ShoppingItemCard(item: ShoppingItem){
    Text(
        text = item.name,
        fontSize =  18.sp,
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ShoppingItemCardPreview(){
    ShoppingItemCard(ShoppingItem("молоко"))
}





@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShoppingLIstOrganizerTheme {
        Greeting("Android")
    }
}