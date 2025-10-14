/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.project.sarti.dao;

import br.com.project.jdbc.ConnectionFactory;
import br.com.project.sarti.model.Funcionarios;
  import br.com.project.sarti.view.FrmMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
      //alterar funcionario 
      public void alterarFuncionario(Funcionarios obj){
         try {
            String sql = "UPDATE tb_funcionarios SET nome=? ,rg=? ,cpf=? ,email=?, senha=?, cargo=? ,nivel_acesso=? ,celular=? ,cep=? ,endereco=? ,numero=?,"
                    + "complemento=?, bairro=?, cidade=?, estado=? WHERE id=?";
                                                      
        
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
            
            stmt.setInt(16, obj.getId());
            
        // 3 - executar o comando sql
        
        stmt.execute();
        stmt.close();
        
            JOptionPane.showMessageDialog(null,"Alterado com Sucesso!!");
            
        } catch (SQLException erro) {
                        JOptionPane.showMessageDialog(null,"Erro" + erro);

        }
       
         
    }
      
      

    //excluir funcionario 
      public void excluirFuncionario(Funcionarios obj){
             // 1- criar comando sql
        try {
            String sql = " delete from tb_funcionarios where id = ?";
        
        // 2- conectar com o bd e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());    
        // 3 - executar o comando sql
        
        stmt.execute();
        stmt.close();
        
            JOptionPane.showMessageDialog(null,"Excluido com Sucesso!!");
            
        } catch (SQLException erro) {
                        JOptionPane.showMessageDialog(null,"Erro" + erro);

        }
    }
      
      //metodo listar Funcionarios    
    public List<Funcionarios> listarFuncionarios(){
        
        try {
            //1- criar a lista
            List<Funcionarios> lista = new ArrayList<>();
            
            //2- criar o sql, organizar e executar
            String sql = "select * from tb_funcionarios";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Funcionarios obj = new Funcionarios();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("Complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                
                lista.add(obj);
            }
            
            return lista;
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }
        
    }
    
    //metodo consulta Funcionarios por cpf
    public Funcionarios consultaFuncionariosporCPF(String cpf){
        try {
           
            //1- criar o sql, organizar e executar
            String sql = "select * from tb_funcionarios where cpf = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            Funcionarios obj = new Funcionarios();

            if(rs.next()){
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("Complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
            }
            
            return obj;
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");
            return null;
        }
        
    }
        
    
    //metodo listar Funcionarios por nome - return list
     public List<Funcionarios> ListaFuncionariosPorNome(String nome){
        
        try {
            //1- criar a lista
            List<Funcionarios> lista = new ArrayList<>();
            
            //2- criar o sql, organizar e executar
            String sql = "select * from tb_funcionarios where nome like ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Funcionarios obj = new Funcionarios();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("Complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                
                lista.add(obj);
            }
            
            return lista;
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }
        
    }
    //metodo efetua login
     
     public void efetuarLogin( String cpf, String senha){
         try {
             // 1 passo - SQL
             String sql = "select * from tb_funcionarios where cpf = ? and senha = ?";
             PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.setString(2, senha);
            
            //toda vez que usar o comando SELECT - use o ResultSet
             ResultSet rs = stmt.executeQuery();
             
             if(rs.next()){
                 //Usuario logou
              JOptionPane.showMessageDialog(null, "Seja Bem Vindo ao Sistema");
                 FrmMenu tela = new FrmMenu();
                 tela.usuariologado = rs.getString("nome");
                 tela.setVisible(true);
                 

                 
             } else{
                 //dados incorreto
               JOptionPane.showMessageDialog(null, "Dados Incorreto");

             }

         } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
         }
     }
     
}
