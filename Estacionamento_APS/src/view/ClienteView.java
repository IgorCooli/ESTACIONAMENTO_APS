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
    
    public void printCliente(String nome, String endereco, String telefone){
	      System.out.println("Nome: " + nome);
	      System.out.println("Endereco: " + endereco);
	      System.out.println("Telefone: " + telefone);
    }
    
    public void cadastrarCliente(){
        System.out.println("Cadastrar cliente: ");
    }
    
    public void inputNome(){
        System.out.println("Nome Cliente: ");
    }     
    
     public void inputEndereco(){
        System.out.println("Endereco Cliente: ");
    }  
     
    public void inputTelefone(){
        System.out.println("Telefone Cliente: ");
    }
    
    
    
}
