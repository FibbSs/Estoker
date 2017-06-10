
import javax.swing.table.DefaultTableModel;

//@author Elias Neto

public class MeuModeloTabela extends DefaultTableModel{
    @Override
    public boolean isCellEditable(int row,int column){
        return false; // Isto fará com que a tabela não possa ser editada ao clicar nela
        // Substituindo o padrão que é escrito na classe oculta DefaultTableModel (Override)
    }
}
