import java.sql.*;
import com.mysql.*;
import com.mysql.jdbc.DatabaseMetaData;


public class testeConexaoBanco
{
	
	public static void main(String[] args)
	{
		
		
		System.out.println(String.valueOf(Calendar.getInstance()));
		new CriarConexao().criarConexaoBanco();
	}
}