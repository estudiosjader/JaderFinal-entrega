package com.example.sistemas.jaderfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.sistemas.jaderfinal.DatosAbiertos.ApiService;
import com.example.sistemas.jaderfinal.Matriculas;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private static final String TAG = "MATRICULAS";
    private RecyclerView recyclerView;
    private boolean aptoParaCargar;
    private MatriculaAdapter matriculaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        matriculaAdapter = new MatriculaAdapter(this);
        recyclerView.setAdapter(matriculaAdapter);

        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (aptoParaCargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, " Listo.");

                            aptoParaCargar = false;
                            obtenerListaMatriculas();
                        }
                    }
                }

            }
        });


        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        aptoParaCargar = true;
        obtenerListaMatriculas();
    }

    private void obtenerListaMatriculas() {

        ApiService service = retrofit.create(ApiService.class);
        Call<ArrayList<Matriculas>> matriculasRespuestaCall = service.obtenerListaMatriculas();

       matriculasRespuestaCall.enqueue(new Callback<ArrayList<Matriculas>>() {
            @Override
            public void onResponse(Call<ArrayList<Matriculas>> call, Response<ArrayList<Matriculas>> response) {
                if(response.isSuccessful()){
                    ArrayList lista = response.body();
                    matriculaAdapter.ListaMatricula(lista);
                }
                else
                {
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }

            }

            @Override
            public void onFailure(Call<ArrayList<Matriculas>> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });

    }

    public  void acercade(View view)
    {
        Intent i = new Intent(this, AcercaDe.class );
        startActivity(i);
    }



}





