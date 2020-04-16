/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Carro;
import model.Moto;
import model.Veiculo;

/**
 *
 * @author coliv
 */
public class VeiculoFactory {

    public Veiculo VeiculoFactory(int tipo) {
        if(tipo == 1){
            return new Carro();
        }
        else if(tipo == 2){
            return new Moto();
        }
        return null;
    }
      
}
