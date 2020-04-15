/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import model.Pagamento;
import model.Vaga;

/**
 *
 * @author coliv
 */
public class EstacionamentoView {

    public void printEstacionamento(String nome, String endereco, ArrayList<Vaga> vagas) {
        System.out.println("Estacionamento " + nome);
        System.out.println("Vagas: ");
        for(Vaga v : vagas){
            if(v.isDisponivel()){
                System.out.println("Vaga: " + v.getNumero() 
                        + " - Disponível"
                );
            }else{
                System.out.println("Vaga: " + v.getNumero() 
                        + " - Indisponível"
                );
            }
        }
    }

    public void printFechamento(ArrayList<Pagamento> pagamentos, double fechamentoCaixa) {
        System.out.println("Fechamento de caixa: ");
        System.out.println("Pagamentos: ");
        for(Pagamento p : pagamentos){
            System.out.println("Hora: " + p.getDataPagamento().getHours() 
                                        + ":" + p.getDataPagamento().getMinutes()                                        
                                        + " - Valor: R$" + p.getValor());
        }
        System.out.println("Valor total do dia: R$" + fechamentoCaixa);
    }
    
    public void printMenuEstacionamento(){
         System.out.println("MENU ESTACIONAMENTO: ");
         System.out.println("1) Entrada de veículo"); 
         System.out.println("2) Listar Veiculos");      
         System.out.println("3) Saída de veículo");
         System.out.println("4) Fechamento de caixa");
         System.out.println("5) Histórico(LOG)");
         System.out.println("6) Sair");
         System.out.println();
         
         System.out.println("Opção Escolhida: ");
    }
    
    public void falhaCadastro(){
        System.out.println("Cadastro não efetuado, favor realizar o procedimento novamente.");
    }
    
    public void saidaVeiculo(){
        System.out.println("Digite a placa do carro que está de saída: ");
    }
}
