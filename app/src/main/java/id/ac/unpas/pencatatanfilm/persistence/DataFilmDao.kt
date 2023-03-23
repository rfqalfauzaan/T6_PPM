package id.ac.unpas.pencatatanfilm.persistences


import androidx.lifecycle.LiveData
import androidx.room.*
import id.ac.unpas.pencatatanfilm.model.DataFilm


@Dao
interface  DataFilmDao{
   @Query("SELECT * FROM datafilm")
   fun loadAll(): LiveData<List<DataFilm>>

   @Query("SELECT * FROM datafilm WHERE kode_film = :kode_film")
   fun find(kode_film: String): DataFilm?

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertAll(vararg items: DataFilm)

   @Delete
   fun delete(items: DataFilm)

}
