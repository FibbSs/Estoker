
import javax.swing.table.DefaultTableModel;

//@author Elias Neto

public class JexibirEstoque extends javax.swing.JFrame {

    public JexibirEstoque() {
        initComponents();
        listarProdutos();
    }

    public void listarProdutos() {
        DefaultTableModel model = new MeuModeloTabela();
        model.addColumn("Código");
        model.addColumn("Descrição");
        model.addColumn("Valor Unitário");
        model.addColumn("Quantidade em estoque");
        Repositorio.localizarProduto("").stream().map((c) -> new Object[]{
            c.getCodigo(),
            c.getDescricao(),
            c.getValorUnitario(),
            c.getQtde() }).forEach((linha) -> {model.addRow(linha);
        });
        tabela.setModel(model);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(148);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(148);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Situação do Estoque");
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
        jScrollPane1.setViewportView(tabela);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 500, 450);

        setSize(new java.awt.Dimension(540, 506));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
