/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.project.sarti.model;

public class Vendas {
    //atributos
    private int id;
    private Clientes Cliente;
    private String data_venda;
    private String obs;
    
    
    //getters and setters

    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(Clientes Cliente) {
        this.Cliente = Cliente;
    }

    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
}
