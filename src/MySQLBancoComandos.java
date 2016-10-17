import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MySQLBancoComandos
{
	private Connection conexao = null;
	private Statement statement = null;
	
	private String nome_do_driver;
	private String nome_tabela = "teste";
	
	final private boolean DEBUG = true;
	
	
	public MySQLBancoComandos() throws SQLException
	{
		// TODO Auto-generated constructor stub
		CriarConexao criador_conexao = new CriarConexao();
		
		conexao = criador_conexao.criarConexaoBanco();
		
		nome_do_driver = criador_conexao.getNomedoDriver();
		
		statement = conexao.createStatement();
		
	}
	
	public MySQLBancoComandos(CriarConexao criador_conexao) throws SQLException 
	{
		conexao = criador_conexao.criarConexaoBanco();
		
		nome_do_driver = criador_conexao.getNomedoDriver();
		
		statement = conexao.createStatement();
	}
	
	public MySQLBancoComandos(String user, String senha, String server,String nome_do_banco, String nome_driver, CriarConexao criador_conexao) throws SQLException
	{
		criador_conexao.setUsuario(user);
		criador_conexao.setSenha(senha);
		criador_conexao.setNomedoBanco(nome_do_banco);
		criador_conexao.setNomedoDriver(nome_driver);
		criador_conexao.setServer(server);
		
		conexao = criador_conexao.criarConexaoBanco();
		
		nome_do_driver = criador_conexao.getNomedoDriver();
		
		statement = conexao.createStatement();
	}

	public void setNomeTabela(String nomeTabela)
	{
		nome_tabela = nomeTabela;
	}

	public String getNomeTabela()
	{
		return nome_tabela;
	}
	
	public String SQLComando(String TABELA, String CHAVE, String VALOR_CHAVE)
	{
		String COMANDO;
		
		COMANDO = "SELECT * FROM " + TABELA;
		if(CHAVE != null)
		{
			COMANDO += "WHERE ";
		}
		
		return COMANDO;
	}
	
	public ResultSet executar(String query)
	{
		ResultSet resultado = null;
		
		try
		{
			resultado = this.statement.executeQuery(query);
			return resultado;
		}
		catch(SQLException ex)
		{
			if(DEBUG)
			{
				System.err.println(ex.getMessage());
			}
		}
		return resultado;
	}
}
