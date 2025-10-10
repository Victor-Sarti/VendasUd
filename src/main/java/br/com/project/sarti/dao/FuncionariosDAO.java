/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.project.sarti.dao;

import br.com.project.jdbc.ConnectionFactory;
import br.com.project.sarti.model.Funcionarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Victo
 */
public class FuncionariosDAO {
    //conexao
     private Connection con;
    
    public FuncionariosDAO(){
        this.con = new ConnectionFactory().getConnection();
        
    }
    
    //metodo cadastrar funcionario
      public void cadastrarFuncionarios(Funcionarios obj){
        // 1- criar comando sql
        try {
            String sql = "insert into tb_funcionarios (nome,rg,cpf,email,senha,cargo,nivel_acesso,celular,cep,endereco,numero,complemento,bairro,cidade,estado) "
                                                       + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        // 2- conectar com o bd e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5,obj.getSenha());
            stmt.setString(6,obj.getCargo());
            stmt.setString(7,obj.getNivel_acesso());
            stmt.setString(8, obj.getCelular());
            stmt.setString(9, obj.getCep());
            stmt.setString(10, obj.getEndereco());
            stmt.setInt(11, obj.getNumero());
            stmt.setString(12, obj.getComplemento());
            stmt.setString(13, obj.getBairro());
            stmt.setString(14, obj.getCidade());
            stmt.setString(15, obj.getUf());
            
        // 3 - executar o comando sql
        
        stmt.execute();
        stmt.close();
        
            JOptionPane.showMessageDialog(null,"Cadastrado com Sucesso!!");
            
        } catch (SQLException erro) {
                        JOptionPane.showMessageDialog(null,"Erro" + erro);

        }
        
    }
    
    
}
