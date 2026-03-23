package com.example.shoppinglistorganizer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import android.R.attr.checked
import android.icu.text.ListFormatter
import androidx.compose.foundation.clickable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoppinglistorganizer.ui.theme.ShoppingLIstOrganizerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingLIstOrganizerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)) {
                        Text("Hello,Android")

                }
            }
        }
    }
}

data class ShoppingItem(
    val name: String,
    val isBought: Boolean = false
)



    class ShoppingListViewModel : ViewModel() {
        val shoppingList = mutableStateListOf(
            ShoppingItem("молоко"),
            ShoppingItem("хліб"),
            ShoppingItem("масло"),
            ShoppingItem("олія"),
        )

        fun toggleBought(index: Int) {
            shoppingList[index] = shoppingList[index].copy(
                isBought = !shoppingList[index].isBought
            )
        }
    }


@Composable
fun ShoppingItemCard(
    item: ShoppingItem,
    onToggleBought : () -> Unit = {}
){


    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.surfaceDim,
                MaterialTheme.shapes.medium
            )
            .clickable{onToggleBought() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = item.isBought, onCheckedChange = {
            onToggleBought()
        })
        Text(
            text = item.name,
            modifier = Modifier.weight(1f),
            fontSize = 18.sp
        )

    }
}

@Composable
fun ShoppingListScreen(viewModel: ShoppingListViewModel= viewModel()) {

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
    ) {
        itemsIndexed(viewModel.shoppingList) { ix, item ->
            ShoppingItemCard(item){
                viewModel.toggleBought(ix)
            }

    }
}
}



    @Preview
    @Composable
    fun ShoppingListScreenPreview() {
            ShoppingListScreen()

    }



@Preview(showBackground = true)
@Composable
fun ShoppingItemCardPreview() {
        var toggleState by remember { mutableStateOf(false) }
        ShoppingItemCard(
            item = ShoppingItem("Молоко", isBought = toggleState)
        ) {
            toggleState = !toggleState
        }
    }}






