
package br.com.project.sarti.dao;

import br.com.project.jdbc.ConnectionFactory;
import br.com.project.sarti.model.ItemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ItemVendaDAO {
      private Connection con;
    
    public ItemVendaDAO(){
        this.con = new ConnectionFactory().getConnection();
        
    }
   public void cadastrarItem(ItemVenda obj){
         try {
            String sql = "insert into tb_vendas (venda_id , produto_id ,qtd, subtotal) values(?,?,?,?)";
             PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setInt(1, obj.getVenda().getId());
             stmt.setInt(2, obj.getProduto().getId());
             stmt.setInt(3, obj.getQtd());
             stmt.setDouble(4, obj.getSubtotal());
             
             stmt.execute();
             stmt.close();
             
              JOptionPane.showMessageDialog(null,"Item Registrado com Sucesso!!");
                
            
        } catch (Exception erro) {
             JOptionPane.showMessageDialog(null,"Erro" + erro);
            
        }
       
   }
}
