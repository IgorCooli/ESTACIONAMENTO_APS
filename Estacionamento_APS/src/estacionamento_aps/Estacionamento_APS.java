/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estacionamento_aps;

import controller.ClienteController;
import controller.VeiculoController;
import java.util.Scanner;

/**
 *
 * @author coliv
 */
public class Estacionamento_APS {

    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        ClienteController cc = new ClienteController();
        VeiculoController vc = new VeiculoController();
        //EstacionamentoController ec = new EstacionamentoController();
        
        
        boolean appOn = true;
        
        while(appOn == true){
            System.out.println("1) Entrada de veículo");
            System.out.println("2) Saída de veículo");
            System.out.println("3) Fechamento de caixa");
            System.out.println("4) Sair");
            
            
            
        }
        
        //Cadastro de Veículo
        vc.getView().cadastrarVeiculo();
        vc.getView().inputPlaca();
        vc.setPlaca(tc.next());
        tc.nextLine();
        vc.getView().inputModelo();
        vc.setModelo(tc.next());
        tc.nextLine();
        vc.getView().inputCor();
        vc.setCor(tc.next());
        tc.nextLine();
        
        //Cadastro de Cliente
        cc.getView().cadastrarCliente();
        cc.getView().inputNome();
        cc.setNome(tc.next());
        tc.nextLine();
        cc.getView().inputEndereco();
        cc.setEndereco(tc.next());
        tc.nextLine();
        cc.getView().inputTelefone();
        cc.setTelefone(tc.next());
        tc.nextLine();
        cc.setVeiculo(vc.getModel());
        
        
        
        cc.atualizaView();
        vc.atualizaView();
        
        
        
    }
    
}
