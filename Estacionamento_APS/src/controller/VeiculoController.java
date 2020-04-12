/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Cliente;
import model.Movimentacao;
import model.Veiculo;
import view.ClienteView;
import view.VeiculoView;

/**
 *
 * @author coliv
 */
public class VeiculoController {
    
    private Veiculo model = new Veiculo();
    private VeiculoView view = new VeiculoView();
    

    public VeiculoController(Veiculo model, VeiculoView view) {
        this.model = model;
        this.view = view;
        
    }
    
    public VeiculoController() {
        
    }
    
    public void setPlaca(String placa){
        model.setPlaca(placa);
    }
    
    public String getPlaca(){
        return model.getPlaca();
    }
    
    public void setModelo(String modelo){
        model.setModelo(modelo);
    }
    
    public String getModelo(){
        return model.getModelo();
    }
    
    public void setCor(String cor){
        model.setCor(cor);
    }
    
    public String getCor(){
        return model.getCor();
    }
    
    public void setMovimentacao(Movimentacao mov){
        model.setMovimentacao(mov);
    }
    
    public Movimentacao getMovimentacao(){
        return model.getMovimentacao();
    }

    public Veiculo getModel() {
        return model;
    }

    public void setModel(Veiculo model) {
        this.model = model;
    }

    public VeiculoView getView() {
        return view;
    }

    public void setView(VeiculoView view) {
        this.view = view;
    }
    
    public void atualizaView(){
        view.printVeiculo(model.getPlaca(), model.getModelo(), model.getCor());
    }
    
}
