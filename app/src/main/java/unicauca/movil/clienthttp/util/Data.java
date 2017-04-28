package unicauca.movil.clienthttp.util;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by darfe on 28/04/2017.
 */

public class Data {

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create(new Gson()))
            .build();

}















