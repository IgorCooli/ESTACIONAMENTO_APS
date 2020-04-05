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

    public Pagamento() {
    }

    public Pagamento(Date dataPagamento, Cliente cliente) {
        this.dataPagamento = dataPagamento;
        this.cliente = cliente;
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
