/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.MatheusDias18.webservce;

import java.util.Objects;

/**
 *
 * @author mathe
 */
public class Carro {

    private String modelo;
    private String placa;
    private double ano;
    private double preço;

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public Carro() {

    }

    public Carro(String modelo, String placa, double ano, double preço) {
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.preço = preço;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getAno() {
        return ano;
    }

    public void setAno(double ano) {
        this.ano = ano;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carro other = (Carro) obj;
        if (Double.doubleToLongBits(this.preço) != Double.doubleToLongBits(other.preço)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ano) != Double.doubleToLongBits(other.ano)) {
            return false;
        }
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        
        return true;
    }
}
