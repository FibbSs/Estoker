import java.util.Calendar;
import javax.swing.JOptionPane;

 // @author Elias Neto

public class JRetirada extends javax.swing.JFrame {

    Retirada retirada = null;
    
    public JRetirada() { //CONSTRUTOR
        initComponents();
        ativarBotoes();
    }
    
    private void limparcampos() {
        txtCodigoProduto.setText("");
        txtDescricao.setText("");
        txtDestinatario.setText("");
        txtProtocolo.setText("");
        txtQuantidade.setText("");
        txtValorTotal.setText("");
        txtValorUnitario.setText("");
        txtEstoque.setText("");
    }
    
    private void habilitarCampos(boolean status){
        txtCodigoProduto.setEnabled(status);
        txtDestinatario.setEnabled(status);
        txtProtocolo.setEnabled(status);
        txtQuantidade.setEnabled(status);
        ativarBotoes(); //quando a disponibilidade dos campos mudam, os botoes tambem devem se adequar.
    }
    
    private boolean validaPreenchimento(){
        if (txtProtocolo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campo Protocolo é obrigatório");
            txtProtocolo.requestFocus();
            return false;
        }
        if (txtCodigoProduto.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Código do produto é obrigatório");
            txtCodigoProduto.requestFocus();
            return false;
        }
        if (txtQuantidade.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campo Quantidade Retirada é obrigatório");
            txtQuantidade.requestFocus();
            return false;
        }
        if (txtDestinatario.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campo Destinatario é obrigatório");
            txtDestinatario.requestFocus();
            return false;
        }
        return true;
    }
    
        private void ativarBotoes() {
        btNovo.setEnabled(!txtProtocolo.isEnabled());
        btRegistrar.setEnabled(txtProtocolo.isEnabled());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btNovo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtProtocolo = new javax.swing.JTextField();
        txtCodigoProduto = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        txtDestinatario = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtValorUnitario = new javax.swing.JTextField();
        btRegistrar = new javax.swing.JButton();
        txtValorTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEstoque = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novo(evt);
            }
        });
        getContentPane().add(btNovo);
        btNovo.setBounds(190, 40, 81, 23);

        jLabel1.setFont(new java.awt.Font("Caladea", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registrar retirada de mercadoria");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 10, 390, 30);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nº Protocolo");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 80, 130, 30);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Código ID do produto");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 120, 120, 30);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Quantidade retirada");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 160, 120, 30);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Destinatário");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 200, 80, 30);

        txtProtocolo.setEnabled(false);
        getContentPane().add(txtProtocolo);
        txtProtocolo.setBounds(130, 80, 70, 30);

        txtCodigoProduto.setEnabled(false);
        txtCodigoProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoProdutoFocusLost(evt);
            }
        });
        getContentPane().add(txtCodigoProduto);
        txtCodigoProduto.setBounds(130, 120, 70, 30);

        txtQuantidade.setEnabled(false);
        getContentPane().add(txtQuantidade);
        txtQuantidade.setBounds(130, 160, 70, 30);

        txtDestinatario.setEnabled(false);
        getContentPane().add(txtDestinatario);
        txtDestinatario.setBounds(130, 200, 70, 30);

        txtDescricao.setEnabled(false);
        getContentPane().add(txtDescricao);
        txtDescricao.setBounds(320, 110, 110, 30);

        jLabel6.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Descrição");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel6.setEnabled(false);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(320, 90, 110, 16);

        jLabel7.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Valor Unitário");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel7.setEnabled(false);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(320, 160, 100, 16);

        txtValorUnitario.setEnabled(false);
        getContentPane().add(txtValorUnitario);
        txtValorUnitario.setBounds(330, 180, 80, 30);

        btRegistrar.setText("Registrar");
        btRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrar(evt);
            }
        });
        getContentPane().add(btRegistrar);
        btRegistrar.setBounds(180, 340, 100, 23);

        txtValorTotal.setEnabled(false);
        getContentPane().add(txtValorTotal);
        txtValorTotal.setBounds(30, 340, 80, 30);

        jLabel8.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Valor total da carga");
        jLabel8.setEnabled(false);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 320, 120, 20);

        txtEstoque.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        txtEstoque.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(txtEstoque);
        txtEstoque.setBounds(301, 220, 140, 20);

        setSize(new java.awt.Dimension(464, 418));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void novo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novo
        // TODO add your handling code here:
        limparcampos();
        habilitarCampos(true);
        retirada = new Retirada();
        txtProtocolo.requestFocus();
    }//GEN-LAST:event_novo

    private void txtCodigoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoProdutoFocusLost
        // TODO add your handling code here:
        if (txtCodigoProduto.getText().trim().isEmpty()) {
            return; //Se a caixa de texto ta vazia, nada acontece, fim dessa função.
        }
        retirada.setProduto(Repositorio.localizarProduto(Integer.parseInt(txtCodigoProduto.getText())));
        if(retirada.getProduto() != null){
        txtDescricao.setText(retirada.getProduto().getDescricao());
        txtValorUnitario.setText(String.valueOf(retirada.getProduto().getValorUnitario()));
        txtEstoque.setText(String.valueOf(retirada.getProduto().getQtde())+" em estoque");
        }else{
            JOptionPane.showMessageDialog(null, "Código do produto inexistente!");
        }
    }//GEN-LAST:event_txtCodigoProdutoFocusLost

    private void registrar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrar
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Tem certeza?","Registrar retirada de mercadoria",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){ //INICIO DOS COMANDOS - SE CLICAR EM "SIM"
        
        if (!validaPreenchimento()) { //verifica se os campos estão todos preenchidos
            return; //se não estiverem todo preenchidos vai parar a gravação
        }
        if (Repositorio.buscaRetirada(Integer.parseInt(txtProtocolo.getText())) != null) {
            JOptionPane.showMessageDialog(null, "Ja existe retirada com este número de Protocolo");
        } else {
            retirada.setProtocolo(Integer.parseInt(txtProtocolo.getText()));
            retirada.setDestinatario(txtDestinatario.getText());
            retirada.setQtdRetirada(Double.parseDouble(txtQuantidade.getText()));
            retirada.setValorTotal(retirada.getQtdRetirada() * retirada.getProduto().getValorUnitario());
            retirada.setDataHora(Calendar.getInstance().getTime()); //Guarda a data e hora
            txtValorTotal.setText(String.valueOf(retirada.getValorTotal())); //exibe no campo de texto txtValorTotal o valor total da mercadoria saindo 
            Repositorio.registrarRetirada(retirada);
            txtEstoque.setText(String.valueOf(retirada.getProduto().getQtde())+" em estoque");
            habilitarCampos(false);
        }
    } //FIM DOS COMANDOS - SE CLICAR EM "SIM"
    }//GEN-LAST:event_registrar

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtCodigoProduto;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtDestinatario;
    private javax.swing.JLabel txtEstoque;
    private javax.swing.JTextField txtProtocolo;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtValorTotal;
    private javax.swing.JTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables
}
