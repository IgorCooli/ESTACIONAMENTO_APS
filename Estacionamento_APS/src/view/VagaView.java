/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author coliv
 */
public class VagaView {

    public void printVaga(int numero, boolean disponivel) {
        if(disponivel == true){
            System.out.println("Vaga nº " + numero + " - DISPONÍVEL");
        }else{
            System.out.println("Vaga nº " + numero + " - INDISPONÍVEL");
        }
    }
    
}
