/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Cliente;
import model.Veiculo;
import view.ClienteView;

/**
 *
 * @author coliv
 */
public class ClienteController {
    
    private Cliente model;
    private ClienteView view;

    public ClienteController(Cliente model, ClienteView view) {
        this.model = model;
        this.view = view;
    }

    public ClienteController() {
    }
    
    public void setNome(String nome){
        model.setNome(nome);
    }
    
    public String getNome(){
        return model.getNome();
    }
    
    public void setEndereco(String end){
        model.setEndereco(end);
    }
    
    public String getEndereco(){
        return model.getEndereco();
    }
    
    public void setTelefone(String tel){
        model.setTelefone(tel);
    }
    
    public String getTelefone(){
        return model.getTelefone();
    }
    
    public void setVeiculo(Veiculo v){
        model.setVeiculo(v);
    }

    public Cliente getModel() {
        return model;
    }

    public void setModel(Cliente model) {
        this.model = model;
    }

    public ClienteView getView() {
        return view;
    }

    public void setView(ClienteView view) {
        this.view = view;
    }
    
    
    
}
