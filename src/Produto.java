


/*
 * Esta classe é o esqueleto do Objeto Produto
 * @author Elias Neto
 */
public class Produto {
    private int codigo;
    private String descricao;
    private double valorUnitario;
    private double qtde;

    public Produto(int codigo, String descricao, double valorUnitario, double qtde) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.qtde = qtde;
    }

    public Produto(){
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getQtde() {
        return qtde;
    }

    public void setQtde(double qtde) {
        this.qtde = qtde;
    }
    
}
