package com.example.mvp_basic;

public class AlCuadradoModel implements AlCuadrado.Model {

    private AlCuadrado.Presenter presenter;
    private double resultado;

    public AlCuadradoModel(AlCuadrado.Presenter presenter){
        this.presenter=presenter;
    }


    @Override
    public void alCuadrado(String data) {
        if(data.equals("")){
            presenter.showError("Campo Vacio");
        }else{
            resultado= Double.parseDouble(data);
            presenter.showResult(String.valueOf(resultado));
        }
    }
