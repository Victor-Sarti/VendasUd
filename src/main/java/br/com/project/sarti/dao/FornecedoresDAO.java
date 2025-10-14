package br.com.project.sarti.dao;

import br.com.project.jdbc.ConnectionFactory;
import br.com.project.sarti.model.Fornecedores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FornecedoresDAO {

    private Connection con;

    public FornecedoresDAO() {
        this.con = new ConnectionFactory().getConnection();

    }
//metodo cadastrar fornecedores 

    public void cadastrarFornecedores(Fornecedores obj) {
        // 1- criar comando sql
        try {
            String sql = "insert into tb_fornecedores (nome,cnpj,email,celular,cep,endereco,numero,complemento,bairro,cidade,estado) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?)";

            // 2- conectar com o bd e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getCelular());
            stmt.setString(5, obj.getCep());
            stmt.setString(6, obj.getEndereco());
            stmt.setInt(7, obj.getNumero());
            stmt.setString(8, obj.getComplemento());
            stmt.setString(9, obj.getBairro());
            stmt.setString(10, obj.getCidade());
            stmt.setString(11, obj.getUf());

            // 3 - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);

        }

    }
    //metodo alterar Fornecedores    
    public void alterarFornecedores(Fornecedores obj){
         try {
            String sql = "UPDATE tb_fornecedores SET nome=?,cnpj=? ,email=? ,celular=? ,cep=? ,endereco=? ,numero=?,"
                    + "complemento=?, bairro=?, cidade=?, estado=? WHERE id=?";
                                                      
        
       // 2- conectar com o bd e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getCelular());
            stmt.setString(5, obj.getCep());
            stmt.setString(6, obj.getEndereco());
            stmt.setInt(7, obj.getNumero());
            stmt.setString(8, obj.getComplemento());
            stmt.setString(9, obj.getBairro());
            stmt.setString(10, obj.getCidade());
            stmt.setString(11, obj.getUf());
            
            stmt.setInt(12, obj.getId());
            
        // 3 - executar o comando sql
        
        stmt.execute();
        stmt.close();
        
            JOptionPane.showMessageDialog(null,"Alterado com Sucesso!!");
            
        } catch (SQLException erro) {
                        JOptionPane.showMessageDialog(null,"Erro" + erro);

        }
        
    }
    
    //excluir fornecedores 
    
    public void excluirCliente(Fornecedores obj){
             // 1- criar comando sql
        try {
            String sql = " delete from tb_fornecedores where id = ?";
        
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
}
