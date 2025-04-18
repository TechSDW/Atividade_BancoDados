package gui;

import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import model.Cliente;
import dao.ClienteDAO;
import factory.ConnectionFactory;

public class ClienteGUI extends javax.swing.JFrame {
    boolean editando = false;
    
    public ClienteGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnVerificar = new javax.swing.JButton();
        lblCPF = new javax.swing.JLabel();
        textCPF = new javax.swing.JTextField();
        textEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        textTelefone = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        textEndereco = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        lblNascimento = new javax.swing.JLabel();
        textNascimento = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Cliente");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastrar novo Cliente"));

        lblNome.setText("Nome");

        textNome.setToolTipText("");
        textNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNomeActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnVerificar.setText("Verificar BD");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });

        lblCPF.setText("CPF");

        textCPF.setToolTipText("");
        textCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCPFActionPerformed(evt);
            }
        });

        textEmail.setToolTipText("");

        lblEmail.setText("E-mail");

        textTelefone.setToolTipText("");

        lblTelefone.setText("Telefone");

        textEndereco.setToolTipText("");
        textEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEnderecoActionPerformed(evt);
            }
        });

        lblEndereco.setText("Endereço");

        lblNascimento.setText("Data de nasc.");

        textNascimento.setToolTipText("");
        textNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNascimentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerificar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNascimento)
                            .addComponent(lblEndereco, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTelefone, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCPF, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNome, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textNome)
                            .addComponent(textCPF)
                            .addComponent(textEmail)
                            .addComponent(textTelefone)
                            .addComponent(textEndereco)
                            .addComponent(textNascimento))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPF)
                    .addComponent(textCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone)
                    .addComponent(textTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco)
                    .addComponent(textEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNascimento)
                    .addComponent(textNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnVerificar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        Cliente cliente = new Cliente();
        cliente.setNome(textNome.getText());
        cliente.setCpf(textCPF.getText());
        cliente.setEmail(textEmail.getText());
        cliente.setTelefone(textTelefone.getText());
        cliente.setEndereco(textEndereco.getText());
        cliente.setNascimento(textNascimento.getText());
        
        if (!editando) {
            if (textNome.getText().isEmpty() || textCPF.getText().isEmpty() || textEmail.getText().isEmpty() || textTelefone.getText().isEmpty() || textEndereco.getText().isEmpty() || textNascimento.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazio");}
            else{
                ClienteDAO dao = new ClienteDAO();
                dao.adiciona(cliente);
                JOptionPane.showMessageDialog(null, "Cliente " + textNome.getText() + " inserido com sucesso!");}
                
                textNome.setText("");
                textCPF.setText("");
                textEmail.setText("");
                textTelefone.setText("");
                textEndereco.setText("");
                textNascimento.setText("");}
        else{
            ClienteDAO dao = new ClienteDAO();
            dao.atualizar(cliente);
            JOptionPane.showMessageDialog(this, "Informações atualizadas com sucesso");
            editando = false;
            btnCadastrar.setText("Cadastrar");
            textCPF.setEnabled(false);}
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        btnCadastrar.setText("Atualizar");
        editando = true;
        
        String cpf = JOptionPane.showInputDialog(this, "Digite o CPF do cliente que deseja editar:");

        if (cpf == null || cpf.trim().isEmpty()) {
            btnCadastrar.setText("Cadastrar");
            editando = false;
            return;
        }

        ClienteDAO dao = new ClienteDAO();
        Cliente cliente = dao.buscarPorCpf(cpf);

        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Cliente com CPF não encontrado.");
            btnCadastrar.setText("Cadastrar");
            editando = false;
            return;
        }

        textNome.setText(cliente.getNome());
        textCPF.setText(cliente.getCpf());
        textCPF.setEnabled(false);
        textEmail.setText(cliente.getEmail());
        textTelefone.setText(cliente.getTelefone());
        textEndereco.setText(cliente.getEndereco());
        textNascimento.setText(cliente.getNascimento());
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        BDCliente tela = new BDCliente();
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void textEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEnderecoActionPerformed

    private void textNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNomeActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String excluiCPF = JOptionPane.showInputDialog("Digite o CPF que você deseja excluir");
        
        if (excluiCPF.isEmpty()){
            JOptionPane.showMessageDialog(this, "Digite um CPF");
            return;
        }
        int cpf = Integer.parseInt(excluiCPF);
        
        ClienteDAO dao = new ClienteDAO();
        
        if (!dao.cpfExiste(excluiCPF)) {
            JOptionPane.showMessageDialog(this, "CPF não encontrado no banco de dados.");
            return;
        }
        
        dao.excluirCliente(cpf);
        JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso!");
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void textNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNascimentoActionPerformed

    }//GEN-LAST:event_textNascimentoActionPerformed

    private void textCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCPFActionPerformed
        try{
            int cpf = Integer.parseInt(textCPF.getText());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Digite um CPF válido (wwwxxxyyyzz)");
        }
    }//GEN-LAST:event_textCPFActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                new ClienteGUI().setVisible(true);
            }
        });
    }
    
    public boolean verificarCPF(String cpf) throws SQLException {
        Connection connection = new ConnectionFactory().getConnection();
        String sql = "SELECT COUNT(*) FROM vendas WHERE cpf = ?";
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, cpf);
        
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        
        connection.close();
        return count > 0;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNascimento;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTextField textCPF;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textEndereco;
    private javax.swing.JTextField textNascimento;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textTelefone;
    // End of variables declaration//GEN-END:variables
}