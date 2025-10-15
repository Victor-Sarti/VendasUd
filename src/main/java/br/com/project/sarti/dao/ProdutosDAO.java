
package br.com.project.sarti.dao;

import br.com.project.jdbc.ConnectionFactory;
import br.com.project.sarti.model.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


    public class ProdutosDAO {
    
    private Connection con;
    
    public ProdutosDAO(){
        this.con = new ConnectionFactory().getConnection();
        
    }
    
    public void cadastrar(Produtos obj){
        try {
            String sql = "insert into tb_produtos(decricao,preco,qtd_estoque,for_id) values(?,?,?,?)";
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
    
}
