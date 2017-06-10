
import java.util.Date;


// @author Elias Neto

public class Retirada {
    private Produto produto;
    private int protocolo; //cod protocolo da retirada
    private double qtdRetirada;
    private double valorTotal;
    private String destinatario;
    private Date dataHora;

    public Retirada(Produto produto, int protocolo, double qtdRetirada, double valorTotal, String destinatario, Date dataHora) {
        this.produto = produto;
        this.protocolo = protocolo;
        this.qtdRetirada = qtdRetirada;
        this.valorTotal = valorTotal;
        this.destinatario = destinatario;
        this.dataHora = dataHora;
    }

    public Retirada(){
    }
    
    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
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

    public double getQtdRetirada() {
        return qtdRetirada;
    }

    public void setQtdRetirada(double qtdRetirada) {
        this.qtdRetirada = qtdRetirada;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }  
    
}
