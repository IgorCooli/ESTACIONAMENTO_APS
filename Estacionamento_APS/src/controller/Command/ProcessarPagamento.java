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
public interface ProcessarPagamento {
    
    void processarPagamento(PagamentoController pag);
    
}
