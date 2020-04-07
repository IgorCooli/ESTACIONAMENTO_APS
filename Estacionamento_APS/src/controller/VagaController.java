/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Vaga;
import model.Veiculo;
import view.VagaView;

/**
 *
 * @author coliv
 */
public class VagaController {
    
    private Vaga model = new Vaga();
    private VagaView view = new VagaView();

    public VagaController(Vaga model, VagaView view) {
        this.model = model;
        this.view = view;
    }

    public VagaController() {
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
    
    public void setVeiculo(Veiculo v){
        model.setVeiculo(v);
    }
    
    public Veiculo getVeiculo(){
        return model.getVeiculo();
    }
    
    public Vaga getModel(){
        return model;
    }
    
    public void setModel(Vaga vaga){
        this.model = vaga;
    }
    
    public VagaView getView(){
        return view;
    }
    
    public void setView(VagaView view){
        this.view = view;
    }
    
    public void atualizaView(){
        view.printVaga(model.getNumero(), model.isDisponivel());
    }
    
}
