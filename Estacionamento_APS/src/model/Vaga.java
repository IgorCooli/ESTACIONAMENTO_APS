/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author coliv
 */
public abstract class Vaga {
    
    private int numero;
    private boolean disponivel;
    private Veiculo veiculo;
    private int tipo;

    public Vaga() {
        this.disponivel = true;
    }

    public Vaga(int numero, boolean disponivel, Veiculo veiculo, int tipo) {
        this.numero = numero;
        this.disponivel = disponivel;
        this.veiculo = veiculo;
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    
    
}
