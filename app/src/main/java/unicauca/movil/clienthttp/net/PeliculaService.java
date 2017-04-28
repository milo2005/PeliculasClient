package unicauca.movil.clienthttp.net;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import unicauca.movil.clienthttp.models.Pelicula;
import unicauca.movil.clienthttp.models.Response;

public interface PeliculaService {
    @GET("peliculas")
    Call<List<Pelicula>> getAll();

    @POST("peliculas")
    Call<Response> insert(@Body Pelicula pelicula);
}


