
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

// @author Elias Neto

public class Contas extends javax.swing.JFrame {

    
    Usuario contaSelecionada = null;
    Usuario usuarioLogado = null;
    
    public Contas(Usuario usuarioAtivo) { //Construtor
        initComponents();
        usuarioLogado = usuarioAtivo;
        preencherTabela();
    }
    
    private void preencherTabela(){
        DefaultTableModel model = new MeuModeloTabela();
        model.addColumn("Login");
        model.addColumn("Privilégio ADM");
        Repositorio.localizaUsuarios().stream().map((c) -> new Object[]{
            c.getLogin(), c.isAdm()}).forEach((linha) -> {
                model.addRow(linha);
            });
        tabela.setModel(model);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btNovaConta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Contas");
        getContentPane().setLayout(null);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selecionarConta(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 310, 403);

        jLabel1.setText("Dê um clique duplo sobre a conta para opções");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 10, 290, 16);

        btNovaConta.setText("Nova Conta");
        btNovaConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovaContaActionPerformed(evt);
            }
        });
        getContentPane().add(btNovaConta);
        btNovaConta.setBounds(111, 460, 110, 26);

        setSize(new java.awt.Dimension(347, 533));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void selecionarConta(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selecionarConta
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){ // "SE" for clicado duas vezes:
            contaSelecionada = new Usuario();
            contaSelecionada = Repositorio.localizaUsuarios().get(tabela.getSelectedRow()); //Seleciona a conta clicada na lista
            
            if(contaSelecionada.isAdm()  &&  !contaSelecionada.getLogin().equals(usuarioLogado.getLogin())){//Verifica se está tentando alterar uma conta ADM que não seja a dele, e impede
                JOptionPane.showMessageDialog(this, "Não pode alterar a conta de outro Administrador");
            }else{
                JalterarConta form = new JalterarConta(this, true, contaSelecionada);
                form.setVisible(true);
                preencherTabela();
            }
            
        }
    }//GEN-LAST:event_selecionarConta

    private void btNovaContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovaContaActionPerformed
        // TODO add your handling code here:
        contaSelecionada = new Usuario();
        contaSelecionada.setLogin(JOptionPane.showInputDialog("Informe o nome de usuario"));
        contaSelecionada.setSenha(JOptionPane.showInputDialog("Informe a senha"));
        contaSelecionada.setCpf(JOptionPane.showInputDialog("Informe o cpf"));
        if(JOptionPane.showConfirmDialog(this, "Dar privilégios administrativos?","Adicionar Conta",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            contaSelecionada.setAdm(true);
            }else{
            contaSelecionada.setAdm(false);
        }
        if(contaSelecionada.getLogin() != null && contaSelecionada.getSenha() != null && contaSelecionada.getCpf()!= null && !contaSelecionada.getLogin().equals("") && !contaSelecionada.getSenha().equals("") && !contaSelecionada.getCpf().equals("")){
            if(Repositorio.localizarUsuario("", contaSelecionada.getCpf()) == null){
            Repositorio.adicionarUsuario(contaSelecionada); //Adiciona a conta
            }else{
            JOptionPane.showMessageDialog(this," Já existe um usuário cadastrado neste cpf!" );
            }
        }
        preencherTabela(); //Atualiza a tabela
    }//GEN-LAST:event_btNovaContaActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btNovaConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
