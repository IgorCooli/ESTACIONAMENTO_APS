/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Moto;
import model.Movimentacao;
import model.Veiculo;
import view.VeiculoView;

/**
 *
 * @author coliv
 */
public class MotoController {
    
    private Moto model = new Moto();
    private VeiculoView view = new VeiculoView();

    public MotoController(Moto model, VeiculoView view) {
        this.model = model;
        this.view = view;
    }

    public MotoController() {
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

    public Moto getModel() {
        return model;
    }

    public void setModel(Moto model) {
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
