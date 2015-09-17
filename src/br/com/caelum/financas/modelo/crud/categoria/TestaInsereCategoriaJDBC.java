package br.com.caelum.financas.modelo.crud.categoria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaInsereCategoriaJDBC {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/controlefinancas", "root", "");
		
		PreparedStatement stmt = con.prepareStatement("insert into Categoria (id, nome) values (2, 'Poupanca')");
		stmt.execute();
		
		stmt.close();
		con.close();
	}
	
}
