/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Command;

import controller.PagamentoController;

/**
 *
 * @author leomh
 */
public class ProcessarPagamentoDinheiro implements ProcessarPagamento{

    @Override
    public void processarPagamento(PagamentoController pag) {
        System.out.println("Pagamento processado! \n");
        pag.getView().printPagamento(pag.getModel(), pag.getValor(), pag.getData());
    }
    
}
