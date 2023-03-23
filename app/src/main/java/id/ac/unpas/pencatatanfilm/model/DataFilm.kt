package id.ac.unpas.pencatatanfilm.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class  DataFilm (
    @PrimaryKey val kode_film: String,
    val nama_film: String,
    val harga: String,
    val stok: String,
    val genre_film: String
)