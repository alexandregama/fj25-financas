package br.com.caelum.financas.modelo.crud.conta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.financas.modelo.Conta;

public class TestaListaContasJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/controlefinancas", "root", "");
		
		PreparedStatement stmt = con.prepareStatement("select * from Conta");
		ResultSet rs = stmt.executeQuery();
		
		List<Conta> contas = new ArrayList<>();
		while (rs.next()) {
			Conta conta = new Conta(rs.getString("titular"), rs.getString("numero"), rs.getString("agencia"));
			contas.add(conta);
		}
		System.out.println(contas);
	}
	
}
