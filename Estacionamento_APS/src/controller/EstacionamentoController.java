/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Estacionamento;
import model.Pagamento;
import model.Vaga;
import view.EstacionamentoView;

/**
 *
 * @author coliv
 */
public class EstacionamentoController {
    
    private Estacionamento model = new Estacionamento();
    private EstacionamentoView view = new EstacionamentoView();

    public EstacionamentoController(Estacionamento model, EstacionamentoView view) {
        this.model = model;
        this.view = view;
    }

    public EstacionamentoController() {
    }
    
    
    
    public void setNome(String nome){
        model.setNome(nome);
    }
    
    public String getNome(){
        return model.getNome();
    }
    
    public void setEndereco(String endereco){
        model.setEndereco(endereco);
    }
    
    public String getEndereco(){
        return model.getEndereco();
    }
    
    public void addVaga(Vaga vaga){
        model.getVagas().add(vaga);
    }
    
    public ArrayList<Vaga> getVagas(){
        return model.getVagas();
    }
    
    public void removeVaga(int i){
        model.getVagas().remove(i);
    }
    
    public void addPagamento(Pagamento pag){
        model.getPagamentos().add(pag);
    }
    
    public ArrayList<Pagamento> getPagamentos(){
        return model.getPagamentos();
    }
    
    public void removePagamento(int i){
        model.getPagamentos().remove(i);
    }
    
    public void setModel(Estacionamento model){
        this.model = model;
    }
    
    public Estacionamento getModel(){
        return this.model;
    }
    
    public void setView(EstacionamentoView view){
        this.view = view;
    }
    
    public EstacionamentoView getView(){
        return this.view;
    }
    
    public void atualizaView(){
        view.printEstacionamento(model.getNome(), model.getEndereco(), model.getVagas());
    }
    
    public double fechamentoCaixa(){
        double val = 0;
        for(Pagamento p : getPagamentos()){
            val += p.getValor();
        }
        return val;
    }
    
    public void fechamentoView(){
        view.printFechamento(model.getPagamentos(), fechamentoCaixa());
    }
    
    
    
}
