
package br.com.project.sarti.dao;

import br.com.project.sarti.model.Clientes;
import br.com.project.jdbc.ConnectionFactory;
import br.com.project.sarti.model.WebServiceCep;
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
            String sql = "UPDATE tb_clientes SET nome=? ,rg=? ,cpf=? ,email=? ,celular=? ,cep=? ,endereco=? ,numero=?,"
                    + "complemento=?, bairro=?, cidade=?, estado=? WHERE id=?";
                                                      
        
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
            stmt.setInt(13, obj.getId());
            
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
            String sql = "delete from tb_clientes where id = ?";
        
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
    
    //metodo consulta Cliente por cpf
    public Clientes consultaClienteporCPF(String cpf){
        try {
           
            //1- criar o sql, organizar e executar
            String sql = "select * from tb_clientes where cpf = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            Clientes obj = new Clientes();

            if(rs.next()){
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
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
        
    
    //metodo buscar cliente por nome
     public List<Clientes> BucarCliente(String nome){
        
        try {
            //1- criar a lista
            List<Clientes> lista = new ArrayList<>();
            
            //2- criar o sql, organizar e executar
            String sql = "select * from tb_clientes where nome like ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
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
     
     //buscar cep
     public Clientes buscaCep(String cep) {
       
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
       

        Clientes obj = new Clientes();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setUf(webServiceCep.getUf());
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }

    }
	

}
