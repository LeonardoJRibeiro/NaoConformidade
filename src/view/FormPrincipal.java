/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.SwingWorker;

/**
 *
 * @author leona
 */
public class FormPrincipal extends javax.swing.JFrame {
    private final Controller controller;
    /**
     * Creates new form Principal
     * @param controller
     */
    public FormPrincipal(Controller controller) {
        this.controller = controller;
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setIcon();
        this.controller.setComponentePai(this);
        setImagemBackground();
    }
    
    private void setImagemBackground(){
        int largura = getWidth()-35;
        int altura= getHeight()-180;
        bg.setIcon(
            controller.getNaoConformidadeController().getImagem().lerImagem(
                    getClass().getResource("/imagens/UEG.png"),
                    largura,
                    altura,
                    new Color(240, 240, 240)
            )
        );
        controller.getNaoConformidadeController().getImagem().removerImagem();
    }
    
    @Override
    protected JRootPane createRootPane() {
        // Definindo o ActionListener
        ActionListener acaoEsc = (ActionEvent e) -> {
            fechar();
        };
        ActionListener acaoF1 = (ActionEvent e) -> {
            controller.abreTelaUsuario();
        };
        ActionListener acaoF2 = (ActionEvent e) -> {
            controller.abreTelaResponsavel();
        };
        ActionListener acaoF3 = (ActionEvent e) -> {
            controller.abreTelaNaoConformidade();
        };
        ActionListener acaoF4 = (ActionEvent e) -> {
            controller.abreTelaSetor();
        };
         ActionListener acaoF5 = (ActionEvent e) -> {
            controller.abrirTelaRelatorio();
        };
        // Definindo o KeyStroke
        KeyStroke strokeEsc = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        KeyStroke strokeF1 = KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0);
        KeyStroke strokeF2 = KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0);
        KeyStroke strokeF3 = KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0);
        KeyStroke strokeF4 = KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0);
        KeyStroke strokeF5 = KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0);
        
        // Criando uma instancia de JRootPane
        JRootPane rootPane = new JRootPane();
        // Registrando o KeyStroke enquanto o JDialog estiver em foco
        rootPane.registerKeyboardAction(acaoEsc, strokeEsc, JComponent.WHEN_IN_FOCUSED_WINDOW);
        rootPane.registerKeyboardAction(acaoF1, strokeF1, JComponent.WHEN_IN_FOCUSED_WINDOW);
        rootPane.registerKeyboardAction(acaoF2, strokeF2, JComponent.WHEN_IN_FOCUSED_WINDOW);
        rootPane.registerKeyboardAction(acaoF3, strokeF3, JComponent.WHEN_IN_FOCUSED_WINDOW);
        rootPane.registerKeyboardAction(acaoF4, strokeF4, JComponent.WHEN_IN_FOCUSED_WINDOW);
        rootPane.registerKeyboardAction(acaoF5, strokeF5, JComponent.WHEN_IN_FOCUSED_WINDOW);
        // Retornando o novo e modificado JRootPane
        return rootPane;
    }
    
    private void fechar(){
        controller.fechar();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        menuImportar = new javax.swing.JMenuItem();
        menuExportar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuSair = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        menuConfirmar = new javax.swing.JMenuItem();
        munuNaoConfirmar = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuAjuda = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gerenciamento de Não Conformidades");
        setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        setMinimumSize(new java.awt.Dimension(800, 600));

        bg.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                bgComponentResized(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.png"))); // NOI18N
        jButton1.setText("Usuário");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMaximumSize(new java.awt.Dimension(100, 75));
        jButton1.setMinimumSize(new java.awt.Dimension(75, 75));
        jButton1.setPreferredSize(new java.awt.Dimension(100, 75));
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.png"))); // NOI18N
        jButton2.setText("Responsável");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setMaximumSize(new java.awt.Dimension(100, 75));
        jButton2.setMinimumSize(new java.awt.Dimension(75, 75));
        jButton2.setPreferredSize(new java.awt.Dimension(75, 75));
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        jButton3.setText("Não Conformidad");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMaximumSize(new java.awt.Dimension(100, 75));
        jButton3.setMinimumSize(new java.awt.Dimension(75, 75));
        jButton3.setPreferredSize(new java.awt.Dimension(75, 75));
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        jButton4.setText("Setor");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setMaximumSize(new java.awt.Dimension(100, 75));
        jButton4.setMinimumSize(new java.awt.Dimension(75, 75));
        jButton4.setPreferredSize(new java.awt.Dimension(75, 75));
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir.png"))); // NOI18N
        jButton5.setText("Relatórios");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setMaximumSize(new java.awt.Dimension(100, 75));
        jButton5.setMinimumSize(new java.awt.Dimension(75, 75));
        jButton5.setPreferredSize(new java.awt.Dimension(75, 75));
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sair.png"))); // NOI18N
        jButton6.setText("Sair");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setMaximumSize(new java.awt.Dimension(100, 75));
        jButton6.setMinimumSize(new java.awt.Dimension(75, 75));
        jButton6.setPreferredSize(new java.awt.Dimension(75, 75));
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jMenu2.setText("Arquivo");

        menuImportar.setText("Importar Banco de dados");
        menuImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuImportarActionPerformed(evt);
            }
        });
        jMenu2.add(menuImportar);

        menuExportar.setText("Exportar Banco de dados");
        menuExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExportarActionPerformed(evt);
            }
        });
        jMenu2.add(menuExportar);
        jMenu2.add(jSeparator1);

        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        jMenu2.add(menuSair);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Opções");

        jMenu4.setText("Confirmar antes de sair");

        menuConfirmar.setText("Confirmar");
        menuConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConfirmarActionPerformed(evt);
            }
        });
        jMenu4.add(menuConfirmar);

        munuNaoConfirmar.setText("Não Confirmar");
        munuNaoConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                munuNaoConfirmarActionPerformed(evt);
            }
        });
        jMenu4.add(munuNaoConfirmar);

        jMenu3.add(jMenu4);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Ajuda");

        menuAjuda.setText("Ajuda");
        menuAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAjudaActionPerformed(evt);
            }
        });
        jMenu1.add(menuAjuda);
        jMenu1.add(jSeparator2);

        menuSobre.setText("Sobre");
        menuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSobreActionPerformed(evt);
            }
        });
        jMenu1.add(menuSobre);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addContainerGap())
        );

        bg.getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuImportarActionPerformed
        new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                controller.getDadosController().importarBanco(false);
                return null;
            }
        }.execute();
    }//GEN-LAST:event_menuImportarActionPerformed

    private void menuExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExportarActionPerformed
        new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                controller.getDadosController().exportarBanco();
                return null;
            }
        }.execute();
    }//GEN-LAST:event_menuExportarActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSairActionPerformed

    private void munuNaoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_munuNaoConfirmarActionPerformed
        controller.setConfirmarFechar(false);
    }//GEN-LAST:event_munuNaoConfirmarActionPerformed

    private void menuConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConfirmarActionPerformed
        controller.setConfirmarFechar(true);
    }//GEN-LAST:event_menuConfirmarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        controller.abreTelaUsuario();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        controller.abreTelaResponsavel();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        controller.abreTelaNaoConformidade();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        controller.abreTelaSetor();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        controller.abrirTelaRelatorio();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        fechar();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void bgComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_bgComponentResized
        setImagemBackground();
    }//GEN-LAST:event_bgComponentResized

    private void menuAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAjudaActionPerformed
        new Help(this, true).setVisible(true);
    }//GEN-LAST:event_menuAjudaActionPerformed

    private void menuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSobreActionPerformed
        new Sobre(this, true).setVisible(true);
    }//GEN-LAST:event_menuSobreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem menuAjuda;
    private javax.swing.JMenuItem menuConfirmar;
    private javax.swing.JMenuItem menuExportar;
    private javax.swing.JMenuItem menuImportar;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenuItem menuSobre;
    private javax.swing.JMenuItem munuNaoConfirmar;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/logo.png")));
    }
}
