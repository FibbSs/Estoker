import javax.swing.JOptionPane;


// @author Elias Neto
public class JalterarConta extends javax.swing.JDialog {

    Usuario conta = null;
    JalterarConta(java.awt.Frame parent, boolean modal, Usuario contaSelecionada) {
        super(parent, modal);
        initComponents();
        conta = contaSelecionada;
        txtLogin.setText(conta.getLogin());
        txtSenha.setText(conta.getSenha());
        boxAdm.setSelected(conta.isAdm());
    }
    
    public void habilitaEditar() {
        btExcluir.setEnabled(btAlterar.isEnabled());
        btGravar.setEnabled(!btAlterar.isEnabled());
        txtLogin.setEnabled(!btAlterar.isEnabled());
        txtSenha.setEnabled(!btAlterar.isEnabled());
        boxAdm.setEnabled(!btAlterar.isEnabled());
    }
    
    //Getter e Setter:
    public Usuario getConta() {
        return conta;
    }

    public void setConta(Usuario conta) {
        this.conta = conta;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        btGravar = new javax.swing.JButton();
        boxAdm = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btAlterar);
        btAlterar.setBounds(10, 10, 73, 26);

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btExcluir);
        btExcluir.setBounds(120, 10, 73, 26);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 70, 90, 16);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Senha");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(61, 140, 90, 16);

        txtLogin.setEnabled(false);
        getContentPane().add(txtLogin);
        txtLogin.setBounds(60, 90, 90, 30);

        txtSenha.setEnabled(false);
        getContentPane().add(txtSenha);
        txtSenha.setBounds(60, 160, 90, 30);

        btGravar.setText("Gravar");
        btGravar.setEnabled(false);
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });
        getContentPane().add(btGravar);
        btGravar.setBounds(60, 240, 90, 26);

        boxAdm.setText("Administrador");
        boxAdm.setEnabled(false);
        getContentPane().add(boxAdm);
        boxAdm.setBounds(53, 200, 110, 24);

        setSize(new java.awt.Dimension(224, 317));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        // TODO add your handling code here:
        Repositorio.updateUsuario(txtLogin.getText(),txtSenha.getText(), boxAdm.isSelected(), conta);
        conta.setLogin(txtLogin.getText());
        conta.setSenha(txtSenha.getText());
        conta.setAdm(boxAdm.isSelected());
        JOptionPane.showMessageDialog(this, "Conta alterada");
        dispose();
    }//GEN-LAST:event_btGravarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        // TODO add your handling code here:
        btAlterar.setEnabled(false);
        habilitaEditar();
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Tem certeza?","Excluir usuario",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                Repositorio.removerUsuario(conta);
                dispose();
            }
        
        
    }//GEN-LAST:event_btExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox boxAdm;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGravar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
