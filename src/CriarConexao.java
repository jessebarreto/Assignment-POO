import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


final public class CriarConexao
{
	
	final private boolean DEBUG = true;
	
	private String usuario = "root"; //Usuario DEFAULT
	private String senha = "12"; //Senha DEFAULT
	private String server = "localhost"; //Server DEFAULT
	private String nome_do_banco = "mural"; //Banco DEFAULT
	private String nome_do_driver = "com.mysql.jdbc.Driver"; //DRIVER DEFAULT
	private String url;

	
	public void setSenha(String senha)
	{
		this.senha = senha;
	}
	
	public void setNomedoBanco(String nomeDoBanco)
	{
		nome_do_banco = nomeDoBanco;
	}
	
	public void setUsuario(String usuario)
	{
		this.usuario = usuario;
	}
	
	public void setServer(String server)
	{
		this.server = server;
	}
	
	public void setNomedoDriver(String nomeDoDriver)
	{
		nome_do_driver = nomeDoDriver;
	}
	
	public void setUrl(String server, String nome_do_banco)
	{
		this.url = "jdbc:mysql://" + server + "/" + nome_do_banco;;
	}
	
	public String getNomedoBanco()
	{
		return nome_do_banco;
	}
	
	public String getSenha()
	{
		if(this.senha != null)
			return senha;
		else
			return "null";
	}
	
	public String getUsuario()
	{
		return usuario;
	}
	
	public String getServer()
	{
		return server;
	}
	
	public String getUrl()
	{
		return url;
	}
	
	public String getNomedoDriver() {
		return nome_do_driver;
	}
	
	private void printDEBUG()
	{
		if(this.DEBUG)
		{
			System.out.println("usuario: " + this.usuario + " " + this.getUsuario());
			System.out.println("senha: " + this.senha + " " + this.getSenha());
			System.out.println("server_name: " + this.server + " " + this.getServer());
			System.out.println("url_conexao: " + this.url + " " + this.getUrl());
			System.out.println("nome_banco: " + this.nome_do_banco + " " + this.getNomedoBanco());
			System.out.println("nome_driver: " + this.nome_do_driver);
		}
	}
	
	public Connection criarConexaoBanco()
	{
		this.setUrl(this.getServer(), this.getNomedoBanco());
		try
		{
			Class.forName(this.getNomedoDriver()).newInstance();
			Connection conexao = DriverManager.getConnection(this.getUrl(), this.getUsuario(), this.getSenha());
			if(DEBUG)
			{
				System.out.println("Conexão com o banco bem sucedida.");
			}
			return conexao;
		}
		catch(ClassNotFoundException ex)
		{
			if(DEBUG)
			{
				System.err.println("O driver expecificado nao foi encontrado.");  
	            return null;
			}
		}
		catch(SQLException ex)
		{
			if(DEBUG)
			{
				System.err.println("Problema na conexão com o banco.");
				System.err.println("SQLException: " + ex.getMessage());
				System.err.println("SQLState: " + ex.getSQLState());
				System.err.println("VendorError: " + ex.getErrorCode());
			}
			return null;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			printDEBUG();
		}
		return null;
	}
	
	
}
