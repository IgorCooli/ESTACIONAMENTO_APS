/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raphaelli Bellini
 */
public class LogSingleton {
    private static LogSingleton instance;
    public String placa;
    public List<Veiculo> listaVeiculo = new ArrayList<>();
    
    protected LogSingleton() {
    }
    
    /* responsavel por gerenciar a instancia
     * o objeto só será instanciado uma única vez, ou seja,
     * se já tiver sido instanciado o retorno, senão ele é instanciado
     */
    private static LogSingleton getInstance() {
        if(instance == null) {
            instance = new LogSingleton();
        }
        return instance;
    }
    
    public void setlistaVeiculo(Veiculo v) {
        listaVeiculo.add(v);
    }
    
    public String getListaVeiculo() {
        String veiculosEstacionados = "";
        
        for(int i = 0; i <= listaVeiculo.size() - 1; i++) {
            veiculosEstacionados = veiculosEstacionados + listaVeiculo.get(i).getModelo() + ": " + listaVeiculo.get(i).getPlaca() + " ";
        }
        return veiculosEstacionados;
    }
}
