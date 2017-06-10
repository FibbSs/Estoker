
import javax.swing.table.DefaultTableModel;

//@author Elias Neto

public class JlistaEntradas extends javax.swing.JFrame {

    public JlistaEntradas() {
        initComponents();
        listarEntradas();
    }
    
    public void listarEntradas() {
        DefaultTableModel model = new MeuModeloTabela();
        model.addColumn("Protocolo");
        model.addColumn("Produto");
        model.addColumn("Quantidade Entrada");
        model.addColumn("Fornecedor");
        model.addColumn("Data");
        Repositorio.buscaEntrada().stream().map((c) -> new Object[]{
            c.getProtocolo(),
            c.getProduto().getDescricao(),
            c.getQtdEntrada(),
            c.getFornecedor(),
            c.getDataHora()}).forEach((linha) -> {
            model.addRow(linha);
        });
        tabela.setModel(model);
        regularColunas();
    }

    private void regularColunas(){ //Regula a largura das colunas para abrigar corretamente o seu Título
        tabela.getColumnModel().getColumn(2).setPreferredWidth(127);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(185);
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registros de Entrada");
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
        jScrollPane1.setBounds(10, 10, 640, 570);

        setSize(new java.awt.Dimension(672, 628));
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
