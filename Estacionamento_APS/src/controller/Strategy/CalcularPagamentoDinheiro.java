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
public class CalcularPagamentoDinheiro implements CalcularPagamentoStrategy{


    @Override
    public double calculaValorPagamento(double difSegundos) {
        
        double valorHora = 6.00;        
        double valorCalculado = 0;
        double minutosHora = 60;        
        valorCalculado = (difSegundos/60) * (valorHora/minutosHora);           
        return valorCalculado; 
    }
    
    
    
}
