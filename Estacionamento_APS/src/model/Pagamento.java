/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author coliv
 */
public class Pagamento {
    
    private Date dataPagamento;
    private Cliente cliente;
    private double valor;
    private TipoPagamento tipoPagamento;

    public Pagamento() { 
    }

    public Pagamento(Date dataPagamento, Cliente cliente, double valor, TipoPagamento tipoPagamento) {
        this.dataPagamento = dataPagamento;
        this.cliente = cliente;
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    
    

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
