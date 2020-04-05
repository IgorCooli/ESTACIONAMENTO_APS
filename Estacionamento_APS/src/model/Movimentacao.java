/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author coliv
 */
class Movimentacao {
    private Date dataEntrada;
    private Date dataSaida;

    public Movimentacao() {
    }

    public Movimentacao(Date dataEntrada, Date dataSaida) {
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }


}
