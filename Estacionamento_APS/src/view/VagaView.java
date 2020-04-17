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

    public void printVaga(int numero, boolean disponivel, int tipo) {
        if(disponivel == true){
            if(tipo == 1){
                System.out.println("Vaga de Carro nº " + numero + " - DISPONÍVEL");
            }
            else if(tipo == 2){
                System.out.println("Vaga de Moto nº " + numero + " - DISPONÍVEL");
            }
            
        }else{
            if (tipo == 1){
                System.out.println("Vaga de Carro nº " + numero + " - INDISPONÍVEL");
            }
            else if(tipo == 2){
                System.out.println("Vaga de Moto nº " + numero + " - INDISPONÍVEL");
            }
            
        }
    }
    
}
