package id.ac.unpas.pencatatanfilm.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.unpas.pencatatanfilm.model.DataFilm


@Database(entities = [DataFilm::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun dataFilmDao(): DataFilmDao
}