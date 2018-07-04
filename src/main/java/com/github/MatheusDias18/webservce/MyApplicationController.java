/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.MatheusDias18.webservce;
/**
 *
 * @author mathe
 */
import com.google.gson.Gson;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("carro")
public class MyApplicationController {
    static CarroDAO carroDAO;    
    
    public MyApplicationController(){
        
    }
    
    @POST
    @Path("inserir")
    public Response inserir(@QueryParam("modelo") String modelo,  
                           @QueryParam("ano") double ano,
                           @QueryParam("preço") double preço,
                           @QueryParam("placa") String placa){
       Carro carro=new Carro(modelo, placa, ano, preço);
        carroDAO.getInstance().inserir(carro);
        return Response.status(Status.OK).build();
    }
    
    @GET
    @Path("recuperar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response recuperar(@QueryParam("placa") String placa){
        Carro carro = carroDAO.getInstance().recuperar(placa);
        Gson gson = new Gson();
        return Response.status(Status.OK).entity(gson.toJson(carro)).build();
    }
    
    @POST
    @Path("alterar")
    public Response alterar(@QueryParam("placa") String placa,
                           @QueryParam("ano") double ano, 
                           @QueryParam("preço") double preço,
                           @QueryParam("modelo") String modelo){
        Carro carro = new Carro(modelo, placa, ano, preço);
        carroDAO.getInstance().alterar(placa, carro);
        return Response.status(Status.OK).build();
    }
    
    @DELETE
    @Path("deletar")
    public Response deletar(@QueryParam("placa") String placa){
        carroDAO.getInstance().deletar(placa);
        return Response.status(Status.OK).build();
    }
    
    @GET
    @Path("recuperarTodos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response recuperarTodos(){
        Gson gson = new Gson();
        return Response.status(Status.OK).entity(gson.toJson(carroDAO.getInstance().recuperarTodos())).build();
    }
    
    /*
    https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Methods
    */
}
