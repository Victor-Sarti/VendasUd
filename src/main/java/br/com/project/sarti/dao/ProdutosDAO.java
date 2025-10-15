
package br.com.project.sarti.dao;

import br.com.project.jdbc.ConnectionFactory;
import br.com.project.sarti.model.Fornecedores;
import br.com.project.sarti.model.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


    public class ProdutosDAO {
    
    private Connection con;
    
    public ProdutosDAO(){
        this.con = new ConnectionFactory().getConnection();
        
    }
    
    public void cadastrar(Produtos obj){
        try {
            String sql = "insert into tb_produtos(descricao,preco,qtd_estoque,for_id) values(?,?,?,?)";
             PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setString(1, obj.getDescricao());
             stmt.setDouble(2, obj.getPreco());
             stmt.setInt(3, obj.getQtd_estoque());
             
             stmt.setInt(4, obj.getFornecedor().getId());
             
             stmt.execute();
             stmt.close();
             
              JOptionPane.showMessageDialog(null,"Produto cadastrado com Sucesso!!");
                
            
        } catch (Exception erro) {
             JOptionPane.showMessageDialog(null,"Erro" + erro);
            
        }
    }
    
      public List<Produtos> listarProdutos(){
        
        try {
            //1- criar a lista
            List<Produtos> lista = new ArrayList<>();
            
            //2- criar o sql, organizar e executar
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));
                
                obj.setFornecedor(f);
                
                lista.add(obj);
            }
            
            return lista;
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }
        
    }
      public void alterar(Produtos obj){
        try {
            String sql = "update tb_produtos set descricao=?, preco=?, qtd_estoque=?, for_id=? where id=?";
             PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setString(1, obj.getDescricao());
             stmt.setDouble(2, obj.getPreco());
             stmt.setInt(3, obj.getQtd_estoque());
             
             stmt.setInt(4, obj.getFornecedor().getId());
             stmt.setInt(5, obj.getId());
             
             stmt.execute();
             stmt.close();
             
              JOptionPane.showMessageDialog(null,"Produto alterado com Sucesso!!");
                
            
        } catch (Exception erro) {
             JOptionPane.showMessageDialog(null,"Erro" + erro);
            
        }
    }
      
        public void excluir(Produtos obj){
             // 1- criar comando sql
        try {
            String sql = " delete from tb_produtos where id = ?";
        
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
        
      public List<Produtos> listarProdutosPorNome(String nome){
        
        try {
            //1- criar a lista
            List<Produtos> lista = new ArrayList<>();
            
            //2- criar o sql, organizar e executar
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao like ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));
                
                obj.setFornecedor(f);
                
                lista.add(obj);
            }
            
            return lista;
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }
        
    }
      
       public Produtos consultaProdutosporNome(String nome){
        try {
           
            //1- criar o sql, organizar e executar
          String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao =?";
            
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
            if(rs.next()){
                 
             obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));
                
                obj.setFornecedor(f);
             stmt.execute();
             stmt.close();
                
               
            }
            
            return obj;
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
            return null;
        }
        
    }
        
    
}
