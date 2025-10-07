/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.project.jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author Victo
 */
public class TestConnection {
    public static void main(String[] args) {
        try {
            
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado Com Sucesso");
        } catch (Exception erro) {
                         JOptionPane.showMessageDialog(null, "Ops aconteceu o erro:" + erro);

        }
    }
}
