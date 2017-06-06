package com.example.sistemas.jaderfinal;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sistemas.jaderfinal.Matriculas;



import java.util.ArrayList;

/**
 * Created by sistemas on 5/06/17.
 */

public class MatriculaAdapter extends RecyclerView.Adapter<MatriculaAdapter.ViewHolder> {
    private ArrayList<Matriculas> dataset;

    private Context context;

    public MatriculaAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_matriculas, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Matriculas a = dataset.get(position);
        holder.contratista.setText(a.getContratista().toString());
        holder.nCtr.setText(a.getNCtr().toString());
        holder.objetoDelcontr.setText(a.getObjetoDelcontr().toString());
        holder.plazo.setText(a.getPlazo().toString());
        holder.tipoContrato.setText(a.getTipoContrato().toString());


    }

    @Override
    public int getItemCount() {

        return dataset.size();
    }

    public void ListaMatricula(ArrayList<Matriculas> listaMatricula) {
        dataset.addAll(listaMatricula);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView contratista;
        private TextView nCtr;
        private TextView objetoDelcontr;
        private TextView plazo;
        private TextView tipoContrato;

        public ViewHolder(View itemView) {
            super(itemView);


            contratista = (TextView) itemView.findViewById(R.id.contratista);
            nCtr= (TextView) itemView.findViewById(R.id.nCtr);
            objetoDelcontr=(TextView) itemView.findViewById(R.id.objetoDelcontr);
            plazo=(TextView) itemView.findViewById(R.id.plazo);
            tipoContrato=(TextView) itemView.findViewById(R.id.tipoContrato);
        }
    }
}


