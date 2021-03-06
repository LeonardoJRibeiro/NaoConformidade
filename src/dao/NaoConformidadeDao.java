/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import model.NaoConformidade;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Consumer;
import model.Responsavel;
import model.Setor;

/**
 *
 * @author leona
 */
public class NaoConformidadeDao implements Crud<NaoConformidade>{

    @Override
    public boolean criar(NaoConformidade dados) {
        Connection conexao = new Conexao().abreConexao();
        String query = "insert into naoConformidade ("
                + "descricao, dataRegistro, dataAcontecimento, reincidencia, abrangencia, "
                + "origem, acaoCorrecao, caminhoImagem, idResponsavel , idSetor) VALUES ("
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setString(1, dados.getDescricao());
            ps.setDate(2, new Date(dados.getDataRegistro().getTime()));
            ps.setDate(3, new Date(dados.getDataAcontecimento().getTime()));
            ps.setBoolean(4, dados.isReincidencia());
            ps.setString(5, dados.getAbrangencia());
            ps.setString(6, dados.getOrigem());
            ps.setString(7, dados.getAcaoCorrecao());
            ps.setString(8, dados.getImagem());
            ps.setInt(9, dados.getResponsavel().getId());
            ps.setInt(10, dados.getSetor().getId());
            return ps.executeUpdate()>0;
            
        }
        catch(SQLException sqlex){
            System.out.println("erro na inserção "+sqlex.getMessage());
            return false;
        }
        finally{
            Conexao.fechaConexao(conexao);
        }
    }

    
    //ATENÇÂO"!!!! esse é o unico método que está funcionando corretamente!
    
    @Override
    public void listarTodos(Consumer<? super NaoConformidade> resultado) {
        Connection conexao = new Conexao().abreConexao();
        String query = "select * from naoConformidade AS nc "
                + "INNER JOIN setor as s "
                + "INNER JOIN  responsavel AS rs "
                + "INNER JOIN responsavel as r "
                + "ON nc.idSetor = s.id "
                + "and s.idResponsavel = rs.id "
                + "and nc.idResponsavel = r.id;";
        try{
            Statement stm = conexao.createStatement();
            ResultSet res = stm.executeQuery(query);
            while (res.next()){
                resultado.accept(new NaoConformidade(
                        res.getInt("id"),
                        res.getString("abrangencia"),
                        res.getString("acaoCorrecao"),
                        res.getDate("dataAcontecimento"),
                        res.getDate("dataRegistro"),
                        res.getString("descricao"),
                        res.getString("caminhoImagem"),
                        res.getString("origem"),
                        res.getBoolean("reincidencia"),
                        new Setor(
                                res.getInt(12),//id do setor
                                res.getString(13), //nome do setor
                                new Responsavel(
                                        res.getInt(15),//id do responsavel pelo setor 
                                        res.getString(17),//cpf do responsavel pelo setor
                                        res.getString(16)//nome do responsável pelo setor
                                )
                        ),
                        new Responsavel(
                                res.getInt(18),//id do responsavel pelo não conformidade
                                res.getString(20),//cpf do do responsavel pelo não conformidade
                                res.getString(19)//nome do responsavel pelo não conformidade
                        )
                ));
            }
        }
        catch(SQLException e){
            System.out.println("erro na listagem "+e.getMessage());
        }
        finally{
            Conexao.fechaConexao(conexao);
        }
    }

    @Override
    public NaoConformidade listarPorId(int id) {
        Connection conexao = new Conexao().abreConexao();
        String query = "select * from naoConformidade AS nc "
                + "INNER JOIN setor as s "
                + "INNER JOIN  responsavel AS rs "
                + "INNER JOIN responsavel as r "
                + "ON nc.idSetor = s.id "
                + "and s.idResponsavel = rs.id "
                + "and nc.idResponsavel = r.id where nc.id=?;";
        try{
            PreparedStatement stm = conexao.prepareStatement(query);
            stm.setInt(1, id);
            ResultSet res = stm.executeQuery();
            while (res.next()){
                return new NaoConformidade(
                        res.getInt("id"),
                        res.getString("abrangencia"),
                        res.getString("acaoCorrecao"),
                        res.getDate("dataAcontecimento"),
                        res.getDate("dataRegistro"),
                        res.getString("descricao"),
                        res.getString("caminhoImagem"),
                        res.getString("origem"),
                        res.getBoolean("reincidencia"),
                        new Setor(
                                res.getInt(12),//id do setor
                                res.getString(13), //nome do setor
                                new Responsavel(
                                        res.getInt(15),//id do responsavel pelo setor 
                                        res.getString(17),//cpf do responsavel pelo setor
                                        res.getString(16)//nome do responsável pelo setor
                                )
                        ),
                        new Responsavel(
                                res.getInt(18),//id do responsavel pelo não conformidade
                                res.getString(20),//cpf do do responsavel pelo não conformidade
                                res.getString(19)//nome do responsavel pelo não conformidade
                        )
                );
            }
        }
        catch(SQLException e){
            System.out.println("erro na listagem "+e.getMessage());
        }
        finally{
            Conexao.fechaConexao(conexao);
        }
        return null;
    }
    public void listarPorDescricao(Consumer<? super NaoConformidade> resultado, String descricao) {
        String query = "select * from naoConformidade AS nc "
                + "INNER JOIN setor as s "
                + "INNER JOIN  responsavel AS rs "
                + "INNER JOIN responsavel as r "
                + "ON nc.idSetor = s.id "
                + "and s.idResponsavel = rs.id "
                + "and nc.idResponsavel = r.id where nc.descricao LIKE ?;";
        Connection conexao = new Conexao().abreConexao();
        try{
            PreparedStatement stm = conexao.prepareStatement(query);
            stm.setString(1, "%"+descricao+"%");
            ResultSet res = stm.executeQuery();
            while (res.next()){
                resultado.accept(new NaoConformidade(
                        res.getInt("id"),
                        res.getString("abrangencia"),
                        res.getString("acaoCorrecao"),
                        res.getDate("dataAcontecimento"),
                        res.getDate("dataRegistro"),
                        res.getString("descricao"),
                        res.getString("caminhoImagem"),
                        res.getString("origem"),
                        res.getBoolean("reincidencia"),
                        new Setor(
                                res.getInt(12),//id do setor
                                res.getString(13), //nome do setor
                                new Responsavel(
                                        res.getInt(15),//id do responsavel pelo setor 
                                        res.getString(17),//cpf do responsavel pelo setor
                                        res.getString(16)//nome do responsável pelo setor
                                )
                        ),
                        new Responsavel(
                                res.getInt(18),//id do responsavel pelo não conformidade
                                res.getString(20),//cpf do do responsavel pelo não conformidade
                                res.getString(19)//nome do responsavel pelo não conformidade
                        )
                ));
            }
        }
        catch(SQLException e){
            System.out.println("erro na listagem "+e.getMessage());
        }
        finally{
            Conexao.fechaConexao(conexao);
        }
    }

    @Override
    public boolean editar(NaoConformidade dados) {
        Connection conexao = new Conexao().abreConexao();
        String query = "update naoConformidade set descricao = ?, dataRegistro = ?, dataAcontecimento = ?, reincidencia = ?, abrangencia = ?, "
                + "origem = ?, acaoCorrecao = ?, caminhoImagem = ?, idResponsavel = ?, idSetor = ? where id = ?";
        try{
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setString(1, dados.getDescricao());
            ps.setDate(2, new Date(dados.getDataRegistro().getTime()));
            ps.setDate(3, new Date(dados.getDataAcontecimento().getTime()));
            ps.setBoolean(4, dados.isReincidencia());
            ps.setString(5, dados.getAbrangencia());
            ps.setString(6, dados.getOrigem());
            ps.setString(7, dados.getAcaoCorrecao());
            ps.setString(8, dados.getImagem());
            ps.setInt(9, dados.getResponsavel().getId());
            ps.setInt(10, dados.getSetor().getId());
            ps.setInt(11, dados.getId());
            
            return ps.executeUpdate()>0;
        }
        catch(SQLException e){
            System.out.println("erro na alteração "+e.getMessage());
            return false;
        }
        finally{
            Conexao.fechaConexao(conexao);
        }    
    }

    @Override
    public boolean excluir(int id) {
        Connection conexao = new Conexao().abreConexao();
        String query = "delete from naoConformidade where id = ?";
        try{
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setInt(1, id);
            return ps.executeUpdate()>0;
        }
        catch(SQLException e){
            System.out.println("erro na exclusao "+e.getMessage());
            return false;
        }
        finally{
            Conexao.fechaConexao(conexao);
        }
    }
    
    public int listarUltimoId(){
        Connection conexao = new Conexao().abreConexao();
        String query = "select max(id) as maxId from naoConformidade;";
        try{
            Statement stm = conexao.createStatement();
            ResultSet res = stm.executeQuery(query);
            while (res.next()){
                return res.getInt("maxId");
            }
        }
        catch(SQLException e){
            System.out.println("erro na listagem "+e.getMessage());
        }
        finally{
            Conexao.fechaConexao(conexao);
        }
        return 0; 
    }
    
    @Override
     public int getLastId(){
        Connection conexao = new Conexao().abreConexao();
        String query = "select max(id) as maxId from naoConformidade;";
        try{
            Statement stm = conexao.createStatement();
            ResultSet res = stm.executeQuery(query);
            while (res.next()){
                return res.getInt("maxId");
            }
        }
        catch(SQLException e){
            System.out.println("erro na listagem "+e.getMessage());
        }
        finally{
            Conexao.fechaConexao(conexao);
        }
        return 0; 
    }

    public void listarPorIntevaloData(Consumer<NaoConformidade> resultado, java.util.Date dataInicio, java.util.Date dataFim) {
        Connection conexao = new Conexao().abreConexao();
        String query = "select * from naoConformidade AS nc "
                + "INNER JOIN setor as s "
                + "INNER JOIN  responsavel AS rs "
                + "INNER JOIN responsavel as r "
                + "ON nc.idSetor = s.id "
                + "and s.idResponsavel = rs.id "
                + "and nc.idResponsavel = r.id "
                + "WHERE nc.dataAcontecimento BETWEEN ? AND ?";
        try{
            PreparedStatement stm = conexao.prepareStatement(query);
            stm.setDate(1, new Date(dataInicio.getTime()));
            stm.setDate(2, new Date(dataFim.getTime()));
            ResultSet res = stm.executeQuery();
            while (res.next()){
                resultado.accept(new NaoConformidade(
                        res.getInt("id"),
                        res.getString("abrangencia"),
                        res.getString("acaoCorrecao"),
                        res.getDate("dataAcontecimento"),
                        res.getDate("dataRegistro"),
                        res.getString("descricao"),
                        res.getString("caminhoImagem"),
                        res.getString("origem"),
                        res.getBoolean("reincidencia"),
                        new Setor(
                                res.getInt(12),//id do setor
                                res.getString(13), //nome do setor
                                new Responsavel(
                                        res.getInt(15),//id do responsavel pelo setor 
                                        res.getString(17),//cpf do responsavel pelo setor
                                        res.getString(16)//nome do responsável pelo setor
                                )
                        ),
                        new Responsavel(
                                res.getInt(18),//id do responsavel pelo não conformidade
                                res.getString(20),//cpf do do responsavel pelo não conformidade
                                res.getString(19)//nome do responsavel pelo não conformidade
                        )
                ));
            }
        }
        catch(SQLException e){
            System.out.println("erro na listagem "+e.getMessage());
        }
        finally{
            Conexao.fechaConexao(conexao);
        }
    }
}
