package unicauca.movil.clienthttp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import unicauca.movil.clienthttp.adapters.PeliculaAdapter;
import unicauca.movil.clienthttp.models.Pelicula;
import unicauca.movil.clienthttp.net.PeliculaService;
import unicauca.movil.clienthttp.util.Data;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Callback<List<Pelicula>> {

    ListView list;
    PeliculaAdapter adapter;
    PeliculaService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        adapter =  new PeliculaAdapter(getLayoutInflater(), new ArrayList<Pelicula>());
        list.setAdapter(adapter);

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        service = Data.retrofit.create(PeliculaService.class);


    }

    @Override
    protected void onResume() {
        super.onResume();
        Call<List<Pelicula>> response = service.getAll();
        response.enqueue(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResponse(Call<List<Pelicula>> call, Response<List<Pelicula>> response) {
        adapter.setData(response.body());
    }

    @Override
    public void onFailure(Call<List<Pelicula>> call, Throwable t) {
        Toast.makeText(this, "error al realizar consulta", Toast.LENGTH_SHORT).show();
    }
}
