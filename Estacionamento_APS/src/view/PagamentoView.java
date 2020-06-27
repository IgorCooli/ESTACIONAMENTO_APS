/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PagamentoController;
import java.util.Date;
import model.Cliente;
import model.Pagamento;

/**
 *
 * @author coliv
 */
public class PagamentoView {

    public void printPagamento(Pagamento pagamento, double valor, Date dataPagamento) {
        System.out.println("EXTRATO DE PAGAMENTO: ");
        System.out.println("Cliente: " + pagamento.getCliente().getNome() + " - Placa Veículo: " + pagamento.getCliente().getVeiculo().getPlaca());
        System.out.println("Hora entrada: " + dataPagamento);
        System.out.println("Hora saida: " + pagamento.getCliente().getVeiculo().getMovimentacao().getDataSaida());        
        System.out.print("Valor: R$" + valor);
        System.out.print(" - MEIO DE PAGAMENTO: " + pagamento.getTipoPagamento());
        System.out.println("");
    }
    
    public void printTipoPagamento(){
        System.out.println("Informe o tipo de pagamento:");
        System.out.println("1 - Cartão");
        System.out.println("2 - Dinheiro");
    }
    
   
    
}
