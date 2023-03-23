package id.ac.unpas.pencatatanfilm.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.room.Room
import id.ac.unpas.pencatatanfilm.model.DataFilm
import id.ac.unpas.pencatatanfilm.persistences.AppDatabase


@Composable

fun PendataanFilmScreen() {
    val context = LocalContext.current
    val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "pendataan-Film"
    ).build()

    val dataFilmDao = db.dataFilmDao()

    val list: LiveData<List<DataFilm>> = dataFilmDao.loadAll()
    val items: List<DataFilm> by list.observeAsState(initial = listOf())

    Column(modifier = Modifier.fillMaxWidth()) {
        FormPendataanFilm(dataFilmDao)

        Row(modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()) {

            Column(modifier = Modifier.weight(3f)) {
                Text(text = "Kode Film", fontSize = 14.sp, textAlign = TextAlign.Center)
            }

            Column(modifier = Modifier.weight(3f)) {
                Text(text = "Nama Film", fontSize = 14.sp, textAlign = TextAlign.Center)
            }

            Column(modifier = Modifier.weight(3f)) {
                Text(text = "Harga", fontSize = 14.sp, textAlign = TextAlign.Center)
            }

            Column(modifier = Modifier.weight(2f)) {
                Text(text = "Stok", fontSize = 14.sp, textAlign = TextAlign.Center)
            }

            Column(modifier = Modifier.weight(3f)) {
                Text(text = "Jenis Film", fontSize = 14.sp, textAlign = TextAlign.Center)
            }
        }
    }
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(items = items, itemContent = { item ->
            Row(modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()) {

                Column(modifier = Modifier.weight(3f)) {
                    Text(text = item.kode_film, fontSize = 15.sp,
                        fontWeight = FontWeight.Bold)
                }

                Column(modifier = Modifier.weight(3f)) {
                    Text(text = item.nama_film, fontSize = 15.sp, fontWeight =
                    FontWeight.Bold)
                }

                Column(modifier = Modifier.weight(3f)) {
                    Text(text = "Rp. ${item.harga}", fontSize = 15.sp,
                        fontWeight = FontWeight.Bold)
                }

                Column(modifier = Modifier.weight(2f)) {
                    Text(text = item.stok, fontSize = 15.sp, fontWeight =
                    FontWeight.Bold)
                }

                Column(modifier = Modifier.weight(3f)) {
                    Text(text = item.genre_film, fontSize = 15.sp, fontWeight =
                    FontWeight.Bold)
                }
            }
            Divider(modifier = Modifier.fillMaxWidth())
        })
    }
}
