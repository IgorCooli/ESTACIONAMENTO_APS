/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author coliv
 */
public class Estacionamento {
    private String nome;
    private String endereco;
    private ArrayList<VagaMoto> vagasMoto = new ArrayList<>();
    private ArrayList<VagaCarro> vagasCarro = new ArrayList<>();
    private ArrayList<Pagamento> pagamentos = new ArrayList<>();

    public Estacionamento() {
    }

    public Estacionamento(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<VagaCarro> getVagasCarro() {
        return vagasCarro;
    }

    public void setVagasCarro(ArrayList<VagaCarro> vagasCarro) {
        this.vagasCarro = vagasCarro;
    }
    
    public ArrayList<VagaMoto> getVagasMoto() {
        return vagasMoto;
    }

    public void setVagasMoto(ArrayList<VagaMoto> vagasMoto) {
        this.vagasMoto = vagasMoto;
    }

    public ArrayList<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(ArrayList<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }
    
    
    
}

