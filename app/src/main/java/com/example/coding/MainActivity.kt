package com.example.coding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import coil3.compose.rememberAsyncImagePainter
import com.example.coding.ui.theme.CodingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val repo = ItemRepo()
        val viewModelFactory= ViewModelFactory(repo)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(ItemViewModel::class.java)
        viewModel.loadItem()
        setContent {
            MaterialTheme{
                ItemGridScreen(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun ItemGridScreen(viewModel: ItemViewModel) {
    val items by viewModel.item.collectAsState()
    LazyVerticalGrid(
        columns =  GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier.fillMaxSize()

    ) {
        items(items.size){ index ->
            val item = items[index]
            ItemCard(item = item)
        }
    }
}

@Composable
fun ItemCard(item: ItemModel){
    Column (
        modifier = Modifier.padding(8.dp).fillMaxWidth()
    ){
        Image(
            painter = rememberAsyncImagePainter(item.image_portrait),
            contentDescription = item.title,
                    modifier = Modifier.fillMaxWidth().height(150.dp)
        )
       Text(
           text = item.title,
           style = MaterialTheme.typography.bodyMedium,
           modifier = Modifier.fillMaxWidth(),
           textAlign = TextAlign.Center
       )
    }
}