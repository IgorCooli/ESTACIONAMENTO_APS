/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.LogSingleton;

/**
 *
 * @author Raphaelli Bellini
 */
public class AtribuiLog {
    public void executaLog(ClienteController c){
     
        LogSingleton armazenaLog = LogSingleton.getInstance();
        
        armazenaLog.setListaClienteController(c);
    }
}
