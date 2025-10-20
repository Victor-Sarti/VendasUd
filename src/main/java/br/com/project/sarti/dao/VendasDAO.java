
package br.com.project.sarti.dao;

import br.com.project.jdbc.ConnectionFactory;
import br.com.project.sarti.model.Vendas;
import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class VendasDAO {
       private Connection con;
    
    public VendasDAO(){
        this.con = new ConnectionFactory().getConnection();
        
    }
    
    public void cadastrarVenda(Vendas obj){
           try {
            String sql = "insert into tb_vendas (cliente_id , data_venda ,total_venda, observacoes) values(?,?,?,?)";
             PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setInt(1, obj.getCliente().getId());
             stmt.setString(2, obj.getData_venda());
             stmt.setDouble(3, obj.getTotal_venda());
             stmt.setString(4, obj.getObs());
             
             stmt.execute();
             stmt.close();
             
              JOptionPane.showMessageDialog(null,"Venda Registrada com Sucesso!!");
                
            
        } catch (Exception erro) {
             JOptionPane.showMessageDialog(null,"Erro" + erro);
            
        }
        }
    
    //retorna a ultima venda 
    
        public int retornaUltimaVenda(){
            try {
                int idvenda = 0;
                
                String sql = "select max(id) id from tb_vendas"; //comando do sql que faz retornar o maior id feito por ultimo
                        
                PreparedStatement ps = con.prepareStatement(sql);
                
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                Vendas p = new Vendas();
                p.setId(rs.getInt("id"));
                idvenda = p.getId();
                }
                return idvenda;

                        
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
}

