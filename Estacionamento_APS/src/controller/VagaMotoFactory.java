/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Vaga;
import model.VagaMoto;

/**
 *
 * @author coliv
 */
public class VagaMotoFactory implements VagaFactory{
    
    @Override 
    public Vaga criarVaga(){
        return new VagaMoto();
    }
    
}
