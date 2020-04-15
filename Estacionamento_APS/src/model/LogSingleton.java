/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.VeiculoController;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raphaelli Bellini
 */
public class LogSingleton {
    private static LogSingleton instance;
    public String placa;
    public List<VeiculoController> listaVeiculoController = new ArrayList<>();
    
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
    
    public void setListaVeiculoController(VeiculoController v) {
        listaVeiculoController.add(v);
    }
    
    public String getListaVeiculoController() {
        String veiculosEstacionados = "###### REGISTRO DE CARROS ######\n\n";
        
        for(int i = 0; i <= listaVeiculoController.size() - 1; i++) {
            veiculosEstacionados = veiculosEstacionados + "PLACA: " + listaVeiculoController.get(i).getPlaca() 
                                                        + "\nCOR: " + listaVeiculoController.get(i).getCor() 
                                                        + "\nMODELO: " + listaVeiculoController.get(i).getModelo() 
                                                        + "\nHORA DE ENTRADA: " + listaVeiculoController.get(i).getMovimentacao().getDataEntrada() 
                                                        + "\nHORA DE SAÍDA: " + listaVeiculoController.get(i).getMovimentacao().getDataSaida() + "\n\n";
        }
        return veiculosEstacionados;
    }
}
