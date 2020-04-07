/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Date;
import model.Cliente;

/**
 *
 * @author coliv
 */
public class PagamentoView {

    public void printPagamento(Cliente cliente, double valor, Date dataPagamento) {
        System.out.println("Pagamento: ");
        System.out.println("Cliente: " + cliente.getNome() + " - Veículo: " + cliente.getVeiculo().getPlaca());
        System.out.println("Hora entrada: " + dataPagamento.getHours());
        System.out.println("Hora saida: " + cliente.getVeiculo().getMovimentacao().getDataSaida());
        System.out.println("Valor: R$" + valor);
    }
}
