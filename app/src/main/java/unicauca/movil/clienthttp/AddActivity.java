package unicauca.movil.clienthttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import unicauca.movil.clienthttp.models.Pelicula;
import unicauca.movil.clienthttp.models.Response;
import unicauca.movil.clienthttp.net.PeliculaService;
import unicauca.movil.clienthttp.util.Data;

public class AddActivity extends AppCompatActivity implements View.OnClickListener, Callback<Response> {

    EditText nombre, calificacion, sinopsis, duracion;
    Spinner genero;

    String[] generos;
    PeliculaService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        nombre = (EditText) findViewById(R.id.nombre);
        calificacion = (EditText) findViewById(R.id.calificacion);
        sinopsis = (EditText) findViewById(R.id.sinopsis);
        duracion = (EditText) findViewById(R.id.duracion);
        genero = (Spinner) findViewById(R.id.genero);

        generos = getResources().getStringArray(R.array.genero);

        Button add = (Button) findViewById(R.id.btnAdd);
        add.setOnClickListener(this);

        service = Data.retrofit.create(PeliculaService.class);

    }

    @Override
    public void onClick(View v) {
        Pelicula pelicula = new Pelicula();

        String nom = nombre.getText().toString();
        int cal = Integer.parseInt(calificacion.getText().toString());
        String sin = sinopsis.getText().toString();
        int dur = Integer.parseInt(duracion.getText().toString());
        String gen = generos[genero.getSelectedItemPosition()];

        pelicula.setNombre(nom);
        pelicula.setCalificacion(cal);
        pelicula.setDuracion(dur);
        pelicula.setSinopsis(sin);
        pelicula.setGenero(gen);

        service.insert(pelicula).enqueue(this);
    }

    @Override
    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
        Response res = response.body();
        if(res.isSuccess()){
            Toast.makeText(this, "Operación exitosa", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(this, "Error al insertar", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<Response> call, Throwable t) {
        Toast.makeText(this, "Error al insertar", Toast.LENGTH_SHORT).show();
    }
}
