
package br.com.project.sarti.dao;

import br.com.project.jdbc.ConnectionFactory;
import br.com.project.sarti.model.Clientes;
import br.com.project.sarti.model.ItemVenda;
import br.com.project.sarti.model.Produtos;
import br.com.project.sarti.model.Vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ItemVendaDAO {
      private Connection con;
    
    public ItemVendaDAO(){
        this.con = new ConnectionFactory().getConnection();
        
    }
   public void cadastrarItem(ItemVenda obj){
         try {
            String sql = "insert into tb_itensvendas (venda_id , produto_id ,qtd, subtotal) values(?,?,?,?)";
             PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setInt(1, obj.getVenda().getId());
             stmt.setInt(2, obj.getProduto().getId());
             stmt.setInt(3, obj.getQtd());
             stmt.setDouble(4, obj.getSubtotal());
             
             stmt.execute();
             stmt.close();
                
            
        } catch (Exception erro) {
             JOptionPane.showMessageDialog(null,"Erro" + erro);
            
        }
       
   }
   
   // metodo que lista Itens de uma venda por Id
    public List<ItemVenda> listarItemPorVenda( int venda_id){
        try {
            //1- criar a lista
            List<ItemVenda> lista = new ArrayList<>();
            
            //2- criar o sql, organizar e executar
            String sql = "select i.id, p.descricao, i.qtd, p.preco, i.subtotal from tb_itensvendas as i "
                    + " inner join tb_produtos as p on (i.produto_id = p.id) where i.venda_id = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, venda_id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
               ItemVenda item = new ItemVenda();
               Produtos prod = new Produtos();
               
               item.setId(rs.getInt("i.id"));
               prod.setDescricao(rs.getString("p.descricao"));
               item.setQtd(rs.getInt("i.qtd"));
               prod.setPreco(rs.getDouble("p.preco"));
               item.setSubtotal(rs.getDouble("i.qtd"));
               
               item.setProduto(prod);
               
               lista.add(item);
               
            }
            
            return lista;
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }
    }
}
