/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estacionamento_aps;

import controller.ClienteController;
import controller.VeiculoController;
import view.ClienteView;
import view.VeiculoView;

/**
 *
 * @author coliv
 */
public class Estacionamento_APS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        VeiculoView vv = new VeiculoView();
        ClienteView cv = new ClienteView();
        VeiculoController vc = new VeiculoController();
        ClienteController cc = new ClienteController();
        
        System.out.println("Entrada:");
        vv.cadastraVeiculo(vc);
        cv.cadastraCliente(cc, vc);
        
        // TODO code application logic here
    }
    
}
