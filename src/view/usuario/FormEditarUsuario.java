/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.usuario;

import resources.Resources;
import controller.UsuarioController;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.Usuario;
import view.Mensagens;

/**
 *
 * @author leona
 */
public class FormEditarUsuario extends javax.swing.JDialog {
    private UsuarioController usuarioController;
    private MaskFormatter mascaraCpf;
    /**
     * Creates new form Editar
     * @param parent
     * @param modal
     * @param usuarioController
     */
    public FormEditarUsuario(java.awt.Frame parent, boolean modal, UsuarioController usuarioController) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/logo.png")));
        this.usuarioController = usuarioController;
        try {
            mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraCpf.setPlaceholderCharacter('_');
            txtCpf.setFormatterFactory(new DefaultFormatterFactory(mascaraCpf));
        } catch (ParseException ex) {
            Logger.getLogger(FormCadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @Override
    protected JRootPane createRootPane() {
        // Definindo o ActionListener
        ActionListener actionListener = (ActionEvent e) -> {
            setVisible(false);
        };
        // Definindo o KeyStroke
        KeyStroke stroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        // Criando uma instancia de JRootPane
        JRootPane rootPane = new JRootPane();
        // Registrando o KeyStroke enquanto o JDialog estiver em foco
        rootPane.registerKeyboardAction(
        actionListener, stroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        // Retornando o novo e modificado JRootPane
        return rootPane;
    }

    public void preencherCampos(Usuario usuario){
        txtCodigo.setText(String.format("%010d", usuario.getId()));
        txtCpf.setText(usuario.getCpf());
        txtNome.setText(usuario.getNome());
        txtUsuario.setText(usuario.getUsuario());
        txtSenha.setText(usuario.getSenha());
        txtConfirmarSenha.setText(usuario.getSenha());
        checkMaster.setSelected(usuario.isMaster());
    }
    
   private boolean validarNome(){
        return usuarioController.validarNome(txtNome.getText());
    }
    
    private boolean validarUsuario(){
        return usuarioController.validarUsuario(txtUsuario.getText());
    }
    
    private boolean validarSenha(){
        return usuarioController.validarSenha(txtSenha.getPassword());
    }
    
    private boolean verificarSenha(){
        return usuarioController.verificarSenha(txtSenha.getPassword(), txtConfirmarSenha.getPassword());
    }
    
    public boolean isValido(){
        return (verificarSenha() && validarNome() && validarUsuario()&& validarSenha());
    }
    
    private void verificarCamposESalvar(){
        verificarCampos();
        salvar();
    }
    
    private void verificarCampos(){
        if(validarNome()){
            verificacaoNome.setText("");
            txtUsuario.requestFocusInWindow();
        }
        else{
            verificacaoNome.setText("Preencha este campo corretamente!");
        }
        if(validarUsuario()){
            verificacaoUsuario.setText("");
            txtSenha.requestFocusInWindow();
        }
        else{
            verificacaoUsuario.setText("Preencha este campo corretamente!");
        }
        if(validarSenha()){
            verificacaoSenha.setText("");
            txtConfirmarSenha.requestFocusInWindow();
        }
        else{
            verificacaoSenha.setText("Preencha este campo corretamente!");
        }
        if(verificarSenha()){
            verificacaoConfirmarSenha.setText("");
            checkMaster.requestFocus();
        }
        else{
            verificacaoConfirmarSenha.setText("Preencha este campo corretamente!");
        }
    }
    
    private void salvar(){
        if(isValido()){
            if(usuarioController.editar(new Usuario(
                    Integer.valueOf(txtCodigo.getText()), 
                    txtNome.getText(), 
                    Resources.removerCaracteresInvalidosCpf(txtCpf.getText()), 
                    txtUsuario.getText(),
                    String.valueOf(txtSenha.getPassword()), 
                    checkMaster.isSelected()
                    ))){
                Mensagens.mensagem(this, "Usuário editado com sucesso!", "Sucesso ao editar", Resources.SUCESSO);
                dispose();
            }
            else{
                Mensagens.mensagem(this, "Usuário não editado!", "Erro ao editar", Resources.ERRO);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        txtConfirmarSenha = new javax.swing.JPasswordField();
        checkMaster = new javax.swing.JCheckBox();
        btnSalvar = new javax.swing.JButton();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        verificacaoNome = new javax.swing.JLabel();
        verificacaoUsuario = new javax.swing.JLabel();
        verificacaoSenha = new javax.swing.JLabel();
        verificacaoConfirmarSenha = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Usuário");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar Usuário", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nome:");

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNome.setToolTipText("");
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Usuário:");

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Senha:");

        txtSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSenhaKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Confirmar senha:");

        txtConfirmarSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtConfirmarSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConfirmarSenhaKeyReleased(evt);
            }
        });

        checkMaster.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkMaster.setText("Usuário Master");
        checkMaster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMasterActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txtCpf.setEditable(false);
        txtCpf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("CPF:");

        verificacaoNome.setBackground(new java.awt.Color(255, 255, 255));
        verificacaoNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        verificacaoNome.setForeground(new java.awt.Color(255, 0, 0));
        verificacaoNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        verificacaoUsuario.setBackground(new java.awt.Color(255, 255, 255));
        verificacaoUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        verificacaoUsuario.setForeground(new java.awt.Color(255, 0, 0));
        verificacaoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        verificacaoSenha.setBackground(new java.awt.Color(255, 255, 255));
        verificacaoSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        verificacaoSenha.setForeground(new java.awt.Color(255, 0, 0));
        verificacaoSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        verificacaoConfirmarSenha.setBackground(new java.awt.Color(255, 255, 255));
        verificacaoConfirmarSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        verificacaoConfirmarSenha.setForeground(new java.awt.Color(255, 0, 0));
        verificacaoConfirmarSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCodigo.setToolTipText("");
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Código:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtConfirmarSenha)
                    .addComponent(txtSenha)
                    .addComponent(txtNome)
                    .addComponent(txtCpf)
                    .addComponent(txtUsuario)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(verificacaoSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(verificacaoNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(verificacaoConfirmarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(verificacaoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(checkMaster)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(verificacaoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(verificacaoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(verificacaoSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(verificacaoConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkMaster)
                    .addComponent(btnSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        verificarCamposESalvar();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtConfirmarSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmarSenhaKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            verificarCamposESalvar();
        }
    }//GEN-LAST:event_txtConfirmarSenhaKeyReleased

    private void txtSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            verificarCamposESalvar();
        }
    }//GEN-LAST:event_txtSenhaKeyReleased

    private void txtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            verificarCamposESalvar();
        }
    }//GEN-LAST:event_txtUsuarioKeyReleased

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            verificarCamposESalvar();
        }
    }//GEN-LAST:event_txtNomeKeyReleased

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoKeyReleased

    private void checkMasterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkMasterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkMasterActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox checkMaster;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JPasswordField txtConfirmarSenha;
    public javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JLabel verificacaoConfirmarSenha;
    private javax.swing.JLabel verificacaoNome;
    private javax.swing.JLabel verificacaoSenha;
    private javax.swing.JLabel verificacaoUsuario;
    // End of variables declaration//GEN-END:variables
}
