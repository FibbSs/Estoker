
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

// @author Elias Neto
public class Jmenu extends javax.swing.JFrame {

    Usuario usuario = null;
    String alteraSenha;
    public Jmenu() {
        initComponents();
        if(loadPrimeiroAcesso()){
            JOptionPane.showMessageDialog(this, "Primeiro acesso detectado, use\nLogin: admin\nSenha: admin01");
        }
        
        Login form = new Login(this, true);
        form.setVisible(true);
        usuario = form.getUsuario();
        txtUsuarioAtivo.setText("Logado como: " + usuario.getLogin());
        modoAdm(usuario.isAdm()); //Se tiver privilegio administrativo vai habilitar certos itens. Caso não, então irá desabilitar.

    }

    private void modoAdm(boolean adm) {
        btGerenciarContas.setEnabled(adm);
        menuRelatorio.setEnabled(adm);
    }
    
    private boolean loadPrimeiroAcesso() {
        try {
            FileInputStream arquivo = new FileInputStream("firstAcess.dat");
            ObjectInputStream leitor = new ObjectInputStream(arquivo);
            Repositorio.primeiroAcesso = leitor.readBoolean();
            leitor.close();
            arquivo.close();
            return false;
        } catch (Exception e) {
            try {
                FileOutputStream arquivo2 = new FileOutputStream("firstAcess.dat");
                ObjectOutputStream gravador = new ObjectOutputStream(arquivo2);
                gravador.writeBoolean(false);
                gravador.flush();
                gravador.close();
                arquivo2.flush();
                arquivo2.close();
                return true;
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(this, "Erro Inesperado, contate suporte");
                return true;
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuarioAtivo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuRelatorio = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        btGerenciarContas = new javax.swing.JMenuItem();
        btAlterarSenha = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estoker  0.1 Beta");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ESTOKER");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 380, 60);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Use o menu acima");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 100, 150, 16);
        getContentPane().add(txtUsuarioAtivo);
        txtUsuarioAtivo.setBounds(0, 250, 140, 30);

        jMenu1.setText("Mercadoria");

        jMenuItem1.setText("Produtos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exibirJprodutos(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Retirada");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registraSaida(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Entrada");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registraEntrada(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        menuRelatorio.setText("Relatórios");

        jMenuItem4.setText("Listar Retiradas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarRetiradas(evt);
            }
        });
        menuRelatorio.add(jMenuItem4);

        jMenuItem5.setText("Listar Entradas");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarEntradas(evt);
            }
        });
        menuRelatorio.add(jMenuItem5);

        jMenuItem7.setText("Situação do Estoque");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exibirEstoque(evt);
            }
        });
        menuRelatorio.add(jMenuItem7);

        jMenuBar1.add(menuRelatorio);

        jMenu4.setText("Conta");

        btGerenciarContas.setText("Gerenciar Contas");
        btGerenciarContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerenciarContasActionPerformed(evt);
            }
        });
        jMenu4.add(btGerenciarContas);

        btAlterarSenha.setText("Alterar senha");
        btAlterarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarSenhaActionPerformed(evt);
            }
        });
        jMenu4.add(btAlterarSenha);

        jMenuItem10.setText("Fazer Logout");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Ajuda");

        jMenuItem6.setText("Sobre");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(416, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exibirJprodutos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exibirJprodutos
        // TODO add your handling code here:
        Jprodutos form = new Jprodutos();
        form.setVisible(true);
    }//GEN-LAST:event_exibirJprodutos

    private void registraEntrada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registraEntrada
        // TODO add your handling code here:
        JEntrada form = new JEntrada();
        form.setVisible(true);
    }//GEN-LAST:event_registraEntrada

    private void registraSaida(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registraSaida
        // TODO add your handling code here:
        JRetirada form = new JRetirada();
        form.setVisible(true);
    }//GEN-LAST:event_registraSaida

    private void listarRetiradas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarRetiradas
        // TODO add your handling code here:
        JlistaRetiradas form = new JlistaRetiradas();
        form.setVisible(true);
    }//GEN-LAST:event_listarRetiradas

    private void listarEntradas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarEntradas
        // TODO add your handling code here:
        JlistaEntradas form = new JlistaEntradas();
        form.setVisible(true);
    }//GEN-LAST:event_listarEntradas

    private void exibirEstoque(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exibirEstoque
        // TODO add your handling code here:
        JexibirEstoque form = new JexibirEstoque();
        form.setVisible(true);
    }//GEN-LAST:event_exibirEstoque

    private void logout(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout
        // TODO add your handling code here:
        Login form = new Login(this, true);
        form.setVisible(true);
        usuario = form.getUsuario();
        txtUsuarioAtivo.setText("Logado como: " + usuario.getLogin());
        modoAdm(usuario.isAdm()); //Se tiver privilegio administrativo vai habilitar certos itens. Caso não, então irá desabilitar.
    }//GEN-LAST:event_logout

    private void btAlterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarSenhaActionPerformed
        // TODO add your handling code here:
        String senhaNova = null;
        alteraSenha = JOptionPane.showInputDialog("Informe a senha atual");
        if (alteraSenha != null){
            if(alteraSenha.equals(usuario.getSenha())) {
            senhaNova = (JOptionPane.showInputDialog("Digite a nova senha"));
            if(senhaNova != null && !senhaNova.equals("")){
            String query = "UPDATE `usuario` SET `senha`=\""+senhaNova+"\" WHERE `login` = \""+usuario.getLogin()+"\"";
            Repositorio.executaSQlQuery(query);
            JOptionPane.showMessageDialog(this, "Senha alterada!");
                }
            } else {
            JOptionPane.showMessageDialog(this, "Senha incorreta");
            }
        }
    }//GEN-LAST:event_btAlterarSenhaActionPerformed

    private void btGerenciarContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerenciarContasActionPerformed
        // TODO add your handling code here:
        Contas form = new Contas(usuario); //Abre o form que gerencia as contas, mas tambem passa como parametro o Atual usuario Logado para tratar que ele não altere a conta de outro ADM
        form.setVisible(true);
    }//GEN-LAST:event_btGerenciarContasActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        Sobre form = new Sobre();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Jmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Jmenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btAlterarSenha;
    private javax.swing.JMenuItem btGerenciarContas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenu menuRelatorio;
    private javax.swing.JLabel txtUsuarioAtivo;
    // End of variables declaration//GEN-END:variables
}
