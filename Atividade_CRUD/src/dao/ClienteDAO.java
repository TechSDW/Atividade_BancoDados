package dao;

import java.sql.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import factory.ConnectionFactory;
import model.Cliente;

public class ClienteDAO {
    private Connection connection;
    
    public ClienteDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Cliente cliente) {
    String sql = "INSERT INTO cliente (nome, cpf, email, telefone, endereco, nascimento) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEndereco());
            stmt.setDate(6, java.sql.Date.valueOf(cliente.getNascimento()));

            stmt.execute();
            stmt.close();
        }
        catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public static void mostraTabela (JTable tabela){
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);
        
        String sql = "SELECT * FROM vendas.cliente";
        
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                Object[] linha = {
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("telefone"),
                    rs.getString("endereco"),
                    rs.getDate("nascimento")
                };
                modelo.addRow(linha);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void buscarClientes(JTable tabela, String termo) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);

        String sql = "SELECT * FROM cliente WHERE nome LIKE ? OR cpf LIKE ?";

        try (Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            String busca = "%" + termo + "%";
            stmt.setString(1, busca);
            stmt.setString(2, busca);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Object[] linha = {
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getString("email"),
                rs.getString("telefone"),
                rs.getString("endereco"),
                rs.getDate("nascimento")
            };
            modelo.addRow(linha);
        }}
        catch (SQLException e) {
            e.printStackTrace();}
    }
    
    public boolean cpfExiste(String cpf) {
        String sql = "SELECT 1 FROM cliente WHERE cpf = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            boolean existe = rs.next();
            rs.close();
            stmt.close();
            return existe;}
        catch (SQLException e) {
            throw new RuntimeException(e);}
    }
    
    public void excluirCliente(int cpf){
        String sql = "DELETE FROM cliente WHERE cpf = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cpf);
            stmt.execute();
            stmt.close();}
        catch (SQLException e){
            throw new RuntimeException(e);}
    }
    
    public void atualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, email = ?, telefone = ?, endereco = ?, nascimento = ? WHERE cpf = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEndereco());
            stmt.setDate(5, java.sql.Date.valueOf(cliente.getNascimento()));
            stmt.setString(6, cliente.getCpf());

            stmt.execute();
            stmt.close();}
        catch (SQLException e) {
            throw new RuntimeException(e);}
    }
    
    public Cliente buscarPorCpf(String cpf) {
        String sql = "SELECT * FROM cliente WHERE cpf = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setID(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNascimento(rs.getDate("nascimento").toString());
                return cliente;}   

            return null;}
        catch (SQLException e) {
            throw new RuntimeException(e);}
    }
}
