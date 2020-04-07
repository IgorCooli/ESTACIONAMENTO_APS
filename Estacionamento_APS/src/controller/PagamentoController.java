/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.Cliente;
import model.Pagamento;
import view.PagamentoView;

/**
 *
 * @author coliv
 */
public class PagamentoController {
    
    private Pagamento model = new Pagamento();
    private PagamentoView view = new PagamentoView();
    private double valorHora;

    public PagamentoController(Pagamento model, PagamentoView view) {
        this.valorHora = 6.00;
        this.model = model;
        this.view = view;
    }

    public PagamentoController() {
        this.valorHora = 6.00;
    }
    
    
    
    public void setData(Date date){
        model.setDataPagamento(date);
    }
    
    public Date getData(){
        return model.getDataPagamento();
    }
    
    public void setCliente(Cliente cliente){
        model.setCliente(cliente);
    }
    
    public Cliente getCliente(){
        return model.getCliente();
    }
    
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }
    
    public void setValor(){
        Date entrada = model.getCliente().getVeiculo().getMovimentacao().getDataEntrada();
        Date saida = model.getCliente().getVeiculo().getMovimentacao().getDataSaida();
        long minutos = getDateDiff(saida,entrada,TimeUnit.MINUTES);
        double valor = this.valorHora * minutos;
        model.setValor(valor);
    }
    
    public double getValor(){
        return model.getValor();
    }
    
    public void setModel(Pagamento pag){
        this.model = model;
    }
    
    public Pagamento getModel(){
        return model;
    }
    
    public void setView(PagamentoView view){
        this.view = view;
    }
    
    public PagamentoView getView(){
        return this.view;
    }
    
    
    public void atualizaView(){
        view.printPagamento(model.getCliente(), model.getValor(), model.getDataPagamento());
    }
    
}
