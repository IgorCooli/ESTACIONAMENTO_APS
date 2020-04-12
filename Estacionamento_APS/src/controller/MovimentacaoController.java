/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import model.Movimentacao;
import view.MovimentacaoView;

/**
 *
 * @author coliv
 */
public class MovimentacaoController {
    
    private Movimentacao model = new Movimentacao();
    private MovimentacaoView view = new MovimentacaoView();
    
    public MovimentacaoController() {
       
    }

    public MovimentacaoController(Movimentacao model, MovimentacaoView view) {
        this.model = model;
        this.view = view;
    }
    
    public void setDataEntrada(Date entrada){
        model.setDataEntrada(entrada);
    }
    
    public Date getDataEntrada(){
        return model.getDataEntrada();
    }
    
    public void setDataSaida(Date saida){
        model.setDataSaida(saida);
    }
    
    public Date getDataSaida(){
        return model.getDataSaida();
    }
    
    public void setModel(Movimentacao model){
        this.model = model;
    }
    
    public Movimentacao getModel(){
        return this.model;
    }
    
    public void setView(MovimentacaoView view){
        this.view = view;
    }
    
    public MovimentacaoView getView(){
        return this.view;
    }
    
}
