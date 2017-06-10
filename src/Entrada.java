
import java.util.Date;


//@author Elias Neto
//Esqueleto do objeto tipo Entrada
public class Entrada {
    private Produto produto;
    private int protocolo; //cod protocolo
    private double qtdEntrada;
    private double valorTotal;
    private String fornecedor;
    private Date dataHora;

    public Entrada(Produto produto, int protocolo, double qtdEntrada, double valorTotal, String fornecedor, Date dataHora) {
        this.produto = produto;
        this.protocolo = protocolo;
        this.qtdEntrada = qtdEntrada;
        this.valorTotal = valorTotal;
        this.fornecedor = fornecedor;
        this.dataHora = dataHora;
    }
    
    public Entrada(){
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(int codigo) {
        this.protocolo = codigo;
    }

    public double getQtdEntrada() {
        return qtdEntrada;
    }

    public void setQtdEntrada(double qtdEntrada) {
        this.qtdEntrada = qtdEntrada;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
    
    
    
    
}
