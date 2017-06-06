package com.example.sistemas.jaderfinal.DatosAbiertos;


import com.example.sistemas.jaderfinal.Matriculas;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sistemas on 5/06/17.
 */

public interface ApiService {

    @GET("b78q-f3qz.json")
    Call<ArrayList<Matriculas>> obtenerListaMatriculas();
}
