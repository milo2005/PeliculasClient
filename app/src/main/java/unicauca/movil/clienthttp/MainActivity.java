package unicauca.movil.clienthttp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import unicauca.movil.clienthttp.adapters.PeliculaAdapter;
import unicauca.movil.clienthttp.models.Pelicula;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView list;
    PeliculaAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        adapter =  new PeliculaAdapter(getLayoutInflater(), new ArrayList<Pelicula>());
        list.setAdapter(adapter);

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }
}
