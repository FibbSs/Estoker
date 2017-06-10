
import java.awt.Color;
import javax.swing.JOptionPane;


// @author Elias Neto

public class Login extends javax.swing.JDialog {
    
    Usuario usuario = null;

    public Login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txtLogin.setText("lucas");
        txtSenha.setText("1");
        getContentPane().setBackground(Color.black);
    }

    public Usuario getUsuario() { //Getter, para passar pra outra classe
        return usuario;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btEntrar = new javax.swing.JButton();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Estoker");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 380, 40);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Gerenciador universal para almoxarifados");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 50, 380, 16);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Usuario");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(91, 100, 60, 30);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Senha");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(91, 140, 60, 30);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("© Elias Neto / João Victor / Lucas Barreto");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 280, 380, 16);

        btEntrar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btEntrar.setText("ENTRAR");
        btEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(btEntrar);
        btEntrar.setBounds(140, 220, 140, 40);
        getContentPane().add(txtLogin);
        txtLogin.setBounds(160, 100, 110, 30);
        getContentPane().add(txtSenha);
        txtSenha.setBounds(160, 140, 110, 30);

        setSize(new java.awt.Dimension(416, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntrarActionPerformed
        // TODO add your handling code here:        
        if(Repositorio.localizarUsuario(txtLogin.getText(),"") != null){ //Verifica se encontra o usuário na nossa ArrayList do Repositório, retorna null se falhar, e usuario se der certo.
            
            usuario = Repositorio.localizarUsuario(txtLogin.getText(),""); //O usuario digitado é carregado na nossa variavel 'usuario'
            
            if(txtSenha.getText().equals(usuario.getSenha())){ //Verifica se a senha bate com a cadastrada
                JOptionPane.showMessageDialog(this, "Bem-vindo "+usuario.getLogin());
                Repositorio.adminMode =  usuario.isAdm();
                dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Senha incorreta");
            }
            
        }else{
            
            JOptionPane.showMessageDialog(this, "Usuario não encontrado");
            return;
            
        }
    }//GEN-LAST:event_btEntrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        System.exit(0); //Isso faz com que, se o usuario tentar fechar a tela de login, o frame Menu seja encerrado para evitar entrada forçada no sistema, programa é encerrado ao invés de fazer Dispose.
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
