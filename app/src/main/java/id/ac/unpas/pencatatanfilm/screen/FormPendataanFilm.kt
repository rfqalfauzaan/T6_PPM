package id.ac.unpas.pencatatanfilm.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.benasher44.uuid.uuid4
import id.ac.unpas.pencatatanfilm.model.DataFilm
import id.ac.unpas.pencatatanfilm.persistences.DataFilmDao
import id.ac.unpas.pencatatanfilm.ui.theme.Purple700
import id.ac.unpas.pencatatanfilm.ui.theme.Teal200

import kotlinx.coroutines.launch

@Composable
fun FormPendataanFilm(dataFilmDao: DataFilmDao) {
    val scope = rememberCoroutineScope()
    val kode_film = remember { mutableStateOf(TextFieldValue("")) }
    val nama_film = remember { mutableStateOf(TextFieldValue("")) }
    val harga = remember { mutableStateOf(TextFieldValue("")) }
    val stok = remember { mutableStateOf(TextFieldValue("")) }
    val genre_film = remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            label = { Text(text = "Kode Film") },
            value = kode_film.value,
            onValueChange = {
                kode_film.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            placeholder = { Text(text = "AM01") })

        OutlinedTextField(label = { Text(text = "Nama  Film") },
            value = nama_film.value,
            onValueChange = {
                nama_film.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text
            ),
            placeholder = { Text(text = "XXXXX") })

        OutlinedTextField(label = { Text(text = "Harga Film") },
            value = harga.value, onValueChange = {
                harga.value = it
            }, modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(), keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ), placeholder = { Text(text = "5000") })

        OutlinedTextField(label = { Text(text = "Stok") },
            value = stok.value, onValueChange = {
                stok.value = it
            }, modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(), keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ), placeholder = { Text(text = "5") })

        OutlinedTextField(label = { Text(text = "Genre Film") },
            value = genre_film.value, onValueChange = {
                genre_film.value = it
            }, modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            placeholder = { Text(text = "cth: Film Romance") })

        val loginButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Purple700, contentColor = Teal200
        )

        val resetButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Teal200, contentColor = Purple700
        )
        Row(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(horizontal = 0.dp, vertical = 5.dp)) {
                Button(onClick = {
                    val id = uuid4().toString()
                    val item = DataFilm(kode_film.value.text, nama_film.value.text,
                        harga.value.text, stok.value.text, genre_film.value.text)
                    scope.launch {
                        dataFilmDao.insertAll()
                    }
                    kode_film.value = TextFieldValue("")
                    nama_film.value = TextFieldValue("")
                    harga.value = TextFieldValue("")
                    stok.value = TextFieldValue("")
                    genre_film.value = TextFieldValue("")
                }, colors = loginButtonColors) {
                    Text(
                        text = "Simpan", style = TextStyle(
                            color = Color.White, fontSize = 18.sp
                        ), modifier = Modifier.padding(8.dp)
                    )
                }
            }

            Column(modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()) {
                Button(onClick = {
                    kode_film.value = TextFieldValue("")
                    nama_film.value = TextFieldValue("")
                    harga.value = TextFieldValue("")
                    stok.value = TextFieldValue("")
                    genre_film.value = TextFieldValue("")
                }, colors = resetButtonColors) {
                    Text(
                        text = "Reset", style = TextStyle(
                            color = Color.White, fontSize = 18.sp
                        ), modifier = Modifier.padding(8.dp)
                    )
                }
            }


        }
    }
}
