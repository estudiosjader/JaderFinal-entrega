package com.example.sistemas.jaderfinal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sistemas on 5/06/17.
 */

public class Matriculas {

    @SerializedName("contratista")
    @Expose
    private String contratista;
    @SerializedName("n_ctr")
    @Expose
    private String nCtr;
    @SerializedName("objeto_delcontr")
    @Expose
    private String objetoDelcontr;
    @SerializedName("plazo")
    @Expose
    private String plazo;
    @SerializedName("tipo_contrato")
    @Expose
    private String tipoContrato;
    @SerializedName("valor_iva")
    @Expose
    private String valorIva;

    public String getContratista() {
        return contratista;
    }

    public void setContratista(String contratista) {
        this.contratista = contratista;
    }

    public String getNCtr() {
        return nCtr;
    }

    public void setNCtr(String nCtr) {
        this.nCtr = nCtr;
    }

    public String getObjetoDelcontr() {
        return  objetoDelcontr;
    }

    public void setObjetoDelcontr(String objetoDelcontr) {
        this.objetoDelcontr = objetoDelcontr;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getValorIva() {
        return valorIva;
    }

    public void setValorIva(String valorIva) {
        this.valorIva = valorIva;
    }

}

