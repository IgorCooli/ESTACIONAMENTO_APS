/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Vaga;
import model.VagaCarro;
import model.VagaMoto;
import model.Veiculo;
import view.VagaView;

/**
 *
 * @author coliv
 */
public class VagaMotoController {
    
    private VagaMoto model = new VagaMoto();
    private VagaView view = new VagaView();

    public VagaMotoController(VagaMoto model, VagaView view) {
        this.model = model;
        this.view = view;
    }

    public VagaMotoController() {
    }
    
    public void setNumero(int numero){
        model.setNumero(numero);
    }
    
    public int getNumero(){
        return model.getNumero();
    }
    
    public void setDisponivel(boolean disponivel){
        model.setDisponivel(disponivel);
    }
    
    public boolean getDisponivel(){
        return model.isDisponivel();
    }
    
    public void setTipo(int tipo){
        model.setTipo(tipo);
    }
    
    public int getTipo(){
        return model.getTipo();
    }
    
    public void setVeiculo(Veiculo v){
        model.setVeiculo(v);
    }
    
    public Veiculo getVeiculo(){
        return model.getVeiculo();
    }
    
    public VagaMoto getModel(){
        return model;
    }
    
    public void setModel(VagaMoto vaga){
        this.model = vaga;
    }
    
    public VagaView getView(){
        return view;
    }
    
    public void setView(VagaView view){
        this.view = view;
    }
    
    public void atualizaView(){
        view.printVaga(model.getNumero(), model.isDisponivel(), model.getTipo());
    }
    
}
