
package br.com.project.sarti.dao;

import br.com.project.sarti.model.Clientes;
import br.com.project.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClientesDAO {
    
    private Connection con;
    
    public ClientesDAO(){
        this.con = new ConnectionFactory().getConnection();
        
    }
    
//metodo cadastrar cliente    
    public void cadastrarCliente(Clientes obj){
        // 1- criar comando sql
        try {
            String sql = "insert into tb_clientes (nome,rg,cpf,email,celular,cep,endereco,numero,complemento,bairro,cidade,estado) "
                                                       + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
        
        // 2- conectar com o bd e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setInt(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getUf());
            
        // 3 - executar o comando sql
        
        stmt.execute();
        stmt.close();
        
            JOptionPane.showMessageDialog(null,"Cadastrado com Sucesso!!");
            
        } catch (SQLException erro) {
                        JOptionPane.showMessageDialog(null,"Erro" + erro);

        }
        
    }
    
//metodo alterar cliente    
    public void alterarCliente(Clientes obj){
         try {
            String sql = "update tb_clientes set (nome=? ,rg=? ,cpf=? ,email=? ,celular=? ,cep=? ,endereco=? ,numero=?,"
                    + "complemento=?, bairro=?, cidade=?, estado=? where id=?";
                                                      
        
        // 2- conectar com o bd e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setInt(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getUf());
            
        // 3 - executar o comando sql
        
        stmt.execute();
        stmt.close();
        
            JOptionPane.showMessageDialog(null,"Alterado com Sucesso!!");
            
        } catch (SQLException erro) {
                        JOptionPane.showMessageDialog(null,"Erro" + erro);

        }
        
    }
    
//metodo excluir cliente    
    public void excluirCliente(Clientes obj){
             // 1- criar comando sql
        try {
            String sql = " delete from tb_clientes where id = ?";
        
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
    
//metodo listar cliente    
    public List<Clientes> listarClientes(){
        
        try {
            //1- criar a lista
            List<Clientes> lista = new ArrayList<>();
            
            //2- criar o sql, organizar e executar
            String sql = "select * from tb_clientes";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Clientes obj = new Clientes();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
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
}
