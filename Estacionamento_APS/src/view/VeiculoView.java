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
public class VeiculoView {
    
    public void printVeiculo(String placa, String modelo, String cor){
	      System.out.println("Placa: " + placa);
	      System.out.println("Modelo: " + modelo);
	      System.out.println("Cor: " + cor);
    }
    
    public void cadastrarVeiculo(){
        System.out.println("Cadastrar veículo: ");
    }
    
    public void inputPlaca(){
        System.out.println("Digite a placa: ");
    }
    
    public void inputModelo(){
        System.out.println("Digite o modelo do veículo: ");
    }
    
    public void inputCor(){
        System.out.println("Digite a cor do veículo: ");
    }
    
    public void listarVeiculos(){
        System.out.println("Veiculos Estacionados: ");
    }
    
}
