import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

 // @author Elias Neto

public class Repositorio {
    
    public static boolean adminMode;
    public static boolean primeiroAcesso;

    public Repositorio(){ //Construtor
        
    }
    //Conexao com o banco de dados
    public static Connection getConnection() {
        try {                                                   //seuIp   nomeDaDb  login  senha
                return DriverManager.getConnection("jdbc:mysql://localhost/estoque","root","123");
            }         
	catch(SQLException excecao) {
		throw new RuntimeException(excecao);
	}
    }
    // executa a maioria das querys INSERT, UPDATE ou DELETE 
    public static void executaSQlQuery(String query){
	Connection con = getConnection();
	Statement st;
	try{
		st = con.createStatement();
		st.executeUpdate(query);
 	}catch(Exception e){
		e.printStackTrace();	
	}
    }
    // localiza produto por codigo e retorna ele
    public static Produto localizarProduto(int codigo) {
        Connection connection = getConnection();

        String query = "SELECT * FROM  `produto`  WHERE `codigo` =\""+codigo+"\"";
        Statement st;
        ResultSet rs;
        Produto produto = null;

    try{
	st = connection.createStatement();
	rs = st.executeQuery(query);
        
	while(rs.next()){
	    produto = new Produto(rs.getInt("codigo"), rs.getString("descricao"), rs.getDouble("valorUnitario"), rs.getDouble("qtde"));	
        }
    }catch (Exception e){
	e.printStackTrace();
        }
        return produto;
    }
    // retorna todos produtos da db por descriçao
    public static List<Produto> localizarProduto(String descricao) {
        Connection connection = getConnection();
        String query;
        List<Produto> produtos = new ArrayList<Produto>();
        Produto produto;
        
        if(descricao.equals("")){
        query = "SELECT * FROM  `produto` ";
        }else{
        query = "SELECT * FROM  `produto`  WHERE `descricao` =\""+descricao+"\"";
        }
        
        Statement st;
        ResultSet rs;
    try{
	st = connection.createStatement();
	rs = st.executeQuery(query);
        
	while(rs.next()){
	    produto = new Produto(rs.getInt("codigo"), rs.getString("descricao"), rs.getDouble("valorUnitario"), rs.getDouble("qtde"));
	    produtos.add(produto);
        }
    }catch (Exception e){
	e.printStackTrace();
    }
        return produtos;
    }
    // transforma boolean para int
    public static int booleanToInt(boolean bool){
        int i;
        i = bool ? 1 : 0;
        return i;
    }
    //adiciona um produto
    public static void adicionar(Produto produto){
        if(localizarProduto(produto.getCodigo()) != null){
            JOptionPane.showMessageDialog(null, "Ja existe um produto com este código");
        }else{
            String query = "INSERT INTO `produto`(`descricao`, `codigo`, `valorUnitario`, `qtde`) VALUES (\""+produto.getDescricao()+"\",\""+produto.getCodigo()+"\",\""+produto.getValorUnitario()+"\",\""+produto.getQtde()+"\")";
            Repositorio.executaSQlQuery(query);
            JOptionPane.showMessageDialog(null, "Produto gravado com sucesso");
        }
        
    }
    //atualiza/altera o produto
    static void updateProduto(Produto produto, int codigo) {
        String query = "UPDATE `produto` SET`descricao`=\""+produto.getDescricao()+"\",`codigo`=\""+produto.getCodigo()+"\",`valorUnitario`=\""+produto.getValorUnitario()+"\",`qtde`=\""+produto.getQtde()+"\" WHERE `codigo` =\""+codigo+"\"";
        Repositorio.executaSQlQuery(query);
    }
    //
    public static void remover(Produto produto){
        String query = "DELETE FROM `produto` WHERE `descricao` =\""+produto.getDescricao()+"\" AND `codigo` =\""+produto.getCodigo()+"\" AND `valorUnitario` =\""+produto.getValorUnitario()+"\"";
        executaSQlQuery(query);       
    }
    //localizar entradas pelo protocolo
    public static Entrada buscaEntrada(int protocolo) {
        Connection connection = getConnection();

        String query = "SELECT * FROM  `entrada`  WHERE `protocolo` =\""+protocolo+"\"";
        Statement st;
        ResultSet rs;
        Entrada entrada = null;
        Produto produto;

    try{
	st = connection.createStatement();
	rs = st.executeQuery(query);
        
	while(rs.next()){
            String produtoDB = rs.getString("produto");
            produto = Repositorio.localizarProduto(Integer.parseInt(produtoDB));
            String dataDB = rs.getString("dataHora");
            //isso é uma conversao da data do db q esta em String para o tipo Date do java
            Date data = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(dataDB);
            
	    entrada = new Entrada(produto, rs.getInt("protocolo"), rs.getDouble("qtdEntrada"), rs.getDouble("valorTotal"), rs.getString("fornecedor"), data);
	    }
    }catch (Exception e){
	e.printStackTrace();
    }
        return entrada;
    }
    // regista as entradas
    public static void registrarEntrada(Entrada entrada){
        String query = "INSERT INTO `entrada`(`qtdEntrada`, `produto`, `protocolo`, `valorTotal`, `fornecedor`, `dataHora`) VALUES (\""+entrada.getQtdEntrada()+"\",\""+entrada.getProduto().getCodigo()+"\",\""+entrada.getProtocolo()+"\",\""+entrada.getValorTotal()+"\",\""+entrada.getFornecedor()+"\",\""+entrada.getDataHora()+"\")";
        Repositorio.executaSQlQuery(query);
        query = "UPDATE `produto` SET `qtde`=\""+(entrada.getProduto().getQtde() + entrada.getQtdEntrada())+"\" WHERE `codigo`= \""+entrada.getProduto().getCodigo()+"\"";
        Repositorio.executaSQlQuery(query);
        entrada.getProduto().setQtde(entrada.getProduto().getQtde() + entrada.getQtdEntrada());// adiciona sobre a quantidade que havia em estoque
        JOptionPane.showMessageDialog(null, "Entrada registrada com sucesso");
    }
    //registra as retiradas
    public static void registrarRetirada(Retirada retirada){
        String query = "INSERT INTO `retirada` (`produto`, `protocolo`, `qtdRetirada`, `destinatario`, `dataHora`, `valorTotal`) VALUES (\""+retirada.getProduto().getCodigo()+"\",\""+retirada.getProtocolo()+"\",\""+retirada.getQtdRetirada()+"\",\""+retirada.getDestinatario()+"\",\""+retirada.getDataHora()+"\",\""+retirada.getValorTotal()+"\")";
        Repositorio.executaSQlQuery(query);
        query = "UPDATE `produto` SET `qtde`=\""+(retirada.getProduto().getQtde() - retirada.getQtdRetirada())+"\" WHERE `codigo`= \""+retirada.getProduto().getCodigo()+"\"";
        Repositorio.executaSQlQuery(query);
        retirada.getProduto().setQtde(retirada.getProduto().getQtde() - retirada.getQtdRetirada());// remove sobre a quantidade que havia em estoque
        JOptionPane.showMessageDialog(null, "Retirada registrada com sucesso");
    }
    //localiza as retiradas pelo protocolo
    public static Retirada buscaRetirada(int protocolo) {
        Connection connection = getConnection();

        String query = "SELECT * FROM  `retirada`  WHERE `protocolo` =\""+protocolo+"\"";
        Statement st;
        ResultSet rs;
        Retirada retirada = null;
        Produto produto;

    try{
	st = connection.createStatement();
	rs = st.executeQuery(query);
        
	while(rs.next()){
            String produtoDB = rs.getString("produto");
            produto = Repositorio.localizarProduto(Integer.parseInt(produtoDB));
            String dataDB = rs.getString("dataHora");
            Date data = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(dataDB);
            
	    retirada = new Retirada(produto, rs.getInt("protocolo"), rs.getDouble("qtdRetirada"), rs.getDouble("valorTotal"), rs.getString("destinatario"), data);
	    }
    }catch (Exception e){
	e.printStackTrace();
    }
        return retirada;
    }
    // retorna todas retiradas
    public static List<Retirada> buscaRetirada() {
        Connection connection = getConnection();

        String query = "SELECT * FROM  `retirada`";
        Statement st;
        ResultSet rs;
        List<Retirada> retiradas = new ArrayList();
        Retirada retirada;
        Produto produto;

    try{
	st = connection.createStatement();
	rs = st.executeQuery(query);
        
	while(rs.next()){
            String produtoDB = rs.getString("produto");
            produto = Repositorio.localizarProduto(Integer.parseInt(produtoDB));
            String dataDB = rs.getString("dataHora");
            Date data = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(dataDB);
            
	    retirada = new Retirada(produto, rs.getInt("protocolo"), rs.getDouble("qtdRetirada"), rs.getDouble("valorTotal"), rs.getString("destinatario"), data);
            retiradas.add(retirada);
        }
    }catch (Exception e){
	e.printStackTrace();
    }
        return retiradas;
    }
    //retorna todas entradas
    public static List<Entrada> buscaEntrada() {
        Connection connection = getConnection();

        String query = "SELECT * FROM  `retirada`";
        Statement st;
        ResultSet rs;
        List<Entrada> entradas = new ArrayList();
        Entrada entrada;
        Produto produto;

    try{
	st = connection.createStatement();
	rs = st.executeQuery(query);
        
	while(rs.next()){
            String produtoDB = rs.getString("produto");
            produto = Repositorio.localizarProduto(Integer.parseInt(produtoDB));
            String dataDB = rs.getString("dataHora");
            Date data = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(dataDB);
            
	    entrada = new Entrada(produto, rs.getInt("protocolo"), rs.getDouble("qtdRetirada"), rs.getDouble("valorTotal"), rs.getString("destinatario"), data);
            entradas.add(entrada);
        }
    }catch (Exception e){
	e.printStackTrace();
    }
        return entradas;
    }
    //retorna todos usuarios
    public static List<Usuario> localizaUsuarios() {
        Connection connection = getConnection();

        String query = "SELECT * FROM  `usuario`";
        Statement st;
        ResultSet rs;
        List<Usuario> usuarios = new ArrayList();
        Usuario usuario;
        Produto produto;

    try{
	st = connection.createStatement();
	rs = st.executeQuery(query);
        
	while(rs.next()){
	    usuario = new Usuario(rs.getString("login"), rs.getString("senha"), rs.getString("cpf"), rs.getBoolean("adm"));
	    usuarios.add(usuario);
        }
    }catch (Exception e){
	e.printStackTrace();
    }
        return usuarios;
    }
    //localiza usuario por login ou cpf, isso é meio uma gambiarra, se tu achar alguem 
    //chamando esse metodo tipo: localizaUsuario("",cpf) ou (login, "")
    //é o primeiro jeito q encontrei para n criar um método que localiza por cpf tbm 
    public static Usuario localizarUsuario(String login, String cpf){
        Connection connection = getConnection();
        String query;
        
        if(!login.equalsIgnoreCase("")){
        query = "SELECT * FROM  `usuario` WHERE `login`=\""+login+"\"";
        }else{
        query = "SELECT * FROM  `usuario` WHERE `cpf`=\""+cpf+"\"";
        }
        Statement st;
        ResultSet rs;
        Usuario usuario = null;

    try{
	st = connection.createStatement();
	rs = st.executeQuery(query);
        
	while(rs.next()){
	    usuario = new Usuario(rs.getString("login"), rs.getString("senha"), rs.getString("cpf"), rs.getBoolean("adm"));
        }
    }catch (Exception e){
	e.printStackTrace();
    }
        return usuario;
    }
    //adiciona usuario
    public static void adicionarUsuario(Usuario usuario){
        int adm = booleanToInt(usuario.isAdm());
        String query = "INSERT INTO `usuario`(`login`, `senha`,`cpf`, `adm`) VALUES (\""+usuario.getLogin()+"\",\""+usuario.getSenha()+"\",\""+usuario.getCpf()+"\",\""+adm+"\")";
        Repositorio.executaSQlQuery(query);
    }
    //remove usuario
    public static void removerUsuario(Usuario usuario){
        String query = "DELETE FROM `usuario` WHERE `login` =\""+usuario.getLogin()+"\" AND `senha` =\""+usuario.getSenha()+"\"";
        executaSQlQuery(query); 
    }
    //autaliza/altera usuario
    public static void updateUsuario(String txtLogin, String txtSenha, boolean boxAdm, Usuario usuario){
        int adm = Repositorio.booleanToInt(boxAdm);
        String query = "UPDATE  `usuario` SET  `login` = \""+txtLogin+"\",`senha` =  \""+txtSenha+"\",`adm` =  \""+adm+"\" WHERE  `login` =  \""+usuario.getLogin()+"\"";
        Repositorio.executaSQlQuery(query);
    } 
}
