/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ClienteController;
import controller.VeiculoController;
import java.util.Scanner;

/**
 *
 * @author coliv
 */
public class ClienteView {
    
    /*
    public void cadastraCliente(ClienteController c, VeiculoController v){
        Scanner tc = new Scanner(System.in);
        
        System.out.println("Entre com os dados do cliente: ");
        System.out.println("Digite o nome: ");
        c.setNome(tc.next());
        System.out.println("Endereço do cliente: ");
        c.setEndereco(tc.next());
        System.out.println("Telefone de contato: ");
        c.setTelefone(tc.next());
        c.setVeiculo(v.getModel());
    }
    */
    
    public void exibeNomeCliente(){
        System.out.println("Nome Cliente: ");
    }     
    
     public void exibeEnderecoCliente(){
        System.out.println("Endereco Cliente: ");
    }  
     
    public void exibeTelefoneCliente(){
        System.out.println("Telefone Cliente: ");
    }
}
