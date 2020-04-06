/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.VeiculoController;
import java.util.Scanner;

/**
 *
 * @author coliv
 */
public class VeiculoView {
    Scanner tc = new Scanner(System.in);
    
    public void cadastraVeiculo(VeiculoController v){
        System.out.println("Entre com os dados do veículo: ");
        System.out.println("Digite a placa: ");
        v.setPlaca(tc.next());
        System.out.println("Digite o modelo: ");
        v.setModelo(tc.next());
        System.out.println("Digite a cor: ");
        v.setCor(tc.next());
    }
    
}
