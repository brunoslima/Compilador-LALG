/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import arquivo.Arquivo;
import decoracao.BordaNumerica;
import decoracao.TextoDecoracao;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import lexico.AnalisadorLexico;
import lexico.Item;

/**
 * @author brunoslima
 * @author leandroungari
 */
public class IUPrincipal extends javax.swing.JFrame {

    public Arquivo arq;
    public String fonte;
    public AnalisadorLexico lexico;
    public TextoDecoracao decoracao;
    public AnalisadorLexico analisador;
    public static String sistema;

    /**
     * Creates new form IUPrincipal
     */
    public IUPrincipal() {
        initComponents();

        //Interface padrão ao sistema.
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Titulo da aplicação
        this.setTitle("Compilador - Analisador Léxico");
        
        //Icone da aplicação
        ImageIcon imagemTituloJanela = new ImageIcon("imagens/logo.png");
        setIconImage(imagemTituloJanela.getImage());
                
        //Inicializando variaveis
        this.arq = new Arquivo();
        this.lexico = null;
        this.fonte = "";

        this.decoracao = new TextoDecoracao(jTextPane);
        this.analisador = new AnalisadorLexico();
        
        sistema = System.getProperty("os.name");
        
        this.jTextPane.setBorder(new BordaNumerica());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        Aba = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaLexica = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuAbrir = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        MenuFechar = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        MenuAnalisar = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1044, 634));

        jTextPane.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jTextPane.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextPaneKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTextPane);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
        );

        Aba.addTab("Novo", jPanel1);

        TabelaLexica.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TabelaLexica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lexema", "Token", "Linha", "Coluna inicial", "Coluna final"
            }
        ));
        TabelaLexica.setName("Tabela de Símbolos"); // NOI18N
        TabelaLexica.getTableHeader().setResizingAllowed(false);
        TabelaLexica.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TabelaLexica);

        MenuAbrir.setText("Arquivo");

        jMenuItem1.setIcon(new javax.swing.ImageIcon("D:\\Ciência da Computação - Unesp\\4º Ano\\2º Semestre\\Compiladores\\Trabalhos\\ProjetoCompilador\\ProjetoCompilador\\imagens\\new_file2.png")); // NOI18N
        jMenuItem1.setText("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MenuAbrir.add(jMenuItem1);

        MenuFechar.setText("Fechar");
        MenuFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFecharActionPerformed(evt);
            }
        });
        MenuAbrir.add(MenuFechar);

        jMenuItem4.setText("Sair");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        MenuAbrir.add(jMenuItem4);

        jMenuBar1.add(MenuAbrir);

        MenuAnalisar.setText("Analisar");

        jMenuItem2.setText("Análise Léxica");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        MenuAnalisar.add(jMenuItem2);

        jMenuBar1.add(MenuAnalisar);

        jMenu3.setText("Ajuda");

        jMenuItem3.setText("Sobre");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Aba)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Aba)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:

        int returnVal = jFileChooser1.showOpenDialog(this);
        File file;

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            file = jFileChooser1.getSelectedFile();
            String localizacao = file.getAbsolutePath();
            String nomeArquivo = file.getName();

            try {

                arq = new Arquivo(localizacao);
                this.fonte = arq.getTexto();
                this.jTextPane.setText(this.fonte);
                this.Aba.setTitleAt(0, nomeArquivo);
                JOptionPane.showMessageDialog(null, "Arquivo aberto com sucesso!");
                

                decoracao.colorirTexto();
                jTextPane.repaint();
                
            } catch (FileNotFoundException ex) {

                Logger.getLogger(IUPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo!");

            }
        } else {
            System.out.println("Escolha do arquivo cancelada pelo usuário!");
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        this.fonte = this.jTextPane.getText();

        DefaultTableModel model = (DefaultTableModel) this.TabelaLexica.getModel();
        if (model.getRowCount() > 0) {
            while (this.TabelaLexica.getModel().getRowCount() > 0) {
                model.removeRow(0);
            }
        }

            if (!this.fonte.equals("")) {

            this.lexico = new AnalisadorLexico();

            lexico.analisar(this.fonte, 0);

            JOptionPane.showMessageDialog(null, "Análise Léxica realizada com sucesso!");

            //Inserindo linhas na tabela
            String lexema, token, numLinha, numColunaInicial, numColunaFinal;
            for (Item i : lexico.getTabela()) {

                lexema = i.getSimbolo();
                token = i.getTipo().toString();
                numLinha = String.valueOf(i.getNumLinha());
                numColunaInicial = String.valueOf(i.getNumColunaInicial());
                numColunaFinal = String.valueOf(i.getNumColunaFinal());

                model.addRow(new String[]{lexema, token, numLinha, numColunaInicial, numColunaFinal});
            }

        } else {
            JOptionPane.showMessageDialog(null, "Area de texto vazia!\nAbra um arquivo texto ou escreva um programa na area de texto!");
        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:

        this.dispose();

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void MenuFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFecharActionPerformed
        // TODO add your handling code here:

        this.arq = null;
        this.lexico = null;
        this.jTextPane.setText("");
        this.Aba.setTitleAt(0, "Inicio");

        DefaultTableModel model = (DefaultTableModel) this.TabelaLexica.getModel();
        if (model.getRowCount() > 0) {
            while (this.TabelaLexica.getModel().getRowCount() > 0) {
                model.removeRow(0);
            }
        }

    }//GEN-LAST:event_MenuFecharActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:

        IUSobre cad = new IUSobre(this, true);
        cad.setLocationRelativeTo(this);
        cad.setVisible(true);

        cad.dispose();

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jTextPaneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPaneKeyReleased
        
        decoracao.colorirTexto();
        jTextPane.repaint();
    }//GEN-LAST:event_jTextPaneKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IUPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IUPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IUPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IUPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IUPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Aba;
    private javax.swing.JMenu MenuAbrir;
    private javax.swing.JMenu MenuAnalisar;
    private javax.swing.JMenuItem MenuFechar;
    private javax.swing.JTable TabelaLexica;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPane;
    // End of variables declaration//GEN-END:variables
}
