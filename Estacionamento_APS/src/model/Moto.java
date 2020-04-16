/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author coliv
 */
public class Moto extends Veiculo{

    public Moto() {
        super();
    }

    public Moto(String placa, String modelo, String cor, Movimentacao movimentacao) {
        super(placa, modelo, cor, movimentacao);
    }
    
}
