/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Memento;

import controller.PagamentoController;
import java.util.ArrayList;
import model.Pagamento;

/**
 *
 * @author leomh
 */
public class PagamentoMemento {

    public PagamentoMemento() {
        
    }
    
    ArrayList<Pagamento> pagamentosMemento = new ArrayList<Pagamento>();

    public ArrayList<Pagamento> getPagamentosMemento() {
        return pagamentosMemento;
    }

    public void setPagamentosMemento(ArrayList<Pagamento> pagamentosMemento) {
        this.pagamentosMemento = pagamentosMemento;
    }
    
    

    
    
}
