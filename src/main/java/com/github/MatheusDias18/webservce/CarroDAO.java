/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.MatheusDias18.webservce;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mathe
 */
public class CarroDAO {
     private static CarroDAO instance;
    private final Map<String,Carro> carros = new HashMap<>();
    
    public CarroDAO(){
    }
    
    public static CarroDAO getInstance(){
        if(instance==null){
            instance=new CarroDAO();
        }
        return instance;
    }
    
    public boolean inserir(Carro g){
        if(carros.isEmpty()){
            this.carros.put("0", g);
        }else{
         int count = this.carros.size();
         this.carros.put(Integer.toString(count),g);
        }
        return true;
    }
    
    public Carro recuperar(String placa){
        return this.carros.get(placa);
    }
    
    public boolean alterar(String placa, Carro after){
        this.carros.put(placa,after);
        return true;
    }
    
    public boolean deletar(String placa){
        this.carros.remove(placa);
        return true;
    }
    
    public Map recuperarTodos(){
        return this.carros;
    }
    
}
