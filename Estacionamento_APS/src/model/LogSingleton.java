/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ClienteController;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raphaelli Bellini
 */
public class LogSingleton {
    private static LogSingleton instance;
    public String placa;
    public List<ClienteController> listaClienteController = new ArrayList<>();
    
    protected LogSingleton() {
    }
    
    /* responsavel por gerenciar a instancia
     * o objeto só será instanciado uma única vez, ou seja,
     * se já tiver sido instanciado o retorno, senão ele é instanciado
     */
    public static LogSingleton getInstance() {
        if(instance == null) {
            instance = new LogSingleton();
        }
        return instance;
    }
    
    public void setListaClienteController(ClienteController c) {
        listaClienteController.add(c);
    }
    
    public String getListaClienteController() {
        String veiculosEstacionados = "###### REGISTRO DE CARROS ######\n\n";
        
        for(int i = 0; i <= listaClienteController.size() - 1; i++) {
            veiculosEstacionados = veiculosEstacionados + "PLACA: " + listaClienteController.get(i).getVeiculo().getPlaca() 
                                                        + "\nCOR: " + listaClienteController.get(i).getVeiculo().getCor() 
                                                        + "\nMODELO: " + listaClienteController.get(i).getVeiculo().getModelo() 
                                                        + "\nHORA DE ENTRADA: " + listaClienteController.get(i).getVeiculo().getMovimentacao().getDataEntrada() 
                                                        + "\nHORA DE SAÍDA: " + listaClienteController.get(i).getVeiculo().getMovimentacao().getDataSaida() + "\n\n";
        }
        return veiculosEstacionados;
    }
}
