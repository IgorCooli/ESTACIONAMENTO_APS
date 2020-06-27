/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Strategy;

import model.TipoPagamento;

/**
 *
 * @author leomh
 */
public interface CalcularPagamentoStrategy {
       
    public double calculaValorPagamento(double difSegundos);
    
}
