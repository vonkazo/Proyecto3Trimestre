package com.vonkazo.proyecto3trimestre.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vonkazo.proyecto3trimestre.modelo.Eficiencia;
import com.vonkazo.proyecto3trimestre.modelo.Marca;

public class GestorBBDD {
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String BBDD="jdbc:mysql://localhost:3306/bbdd_gestmotor";
	private final static String USER="dam2018";
	private final static String PASSWORD="dam2018";
	private Connection conexion;
	
	public GestorBBDD() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		cargarConexion();
	}
	
	private void cargarConexion() throws SQLException {
		conexion = DriverManager.getConnection(BBDD, USER, PASSWORD);
	}
	
	public void cerrarConexion() throws SQLException {
		conexion.close();
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
	public ArrayList<Marca> cargaMarcas() throws SQLException {
		Marca m;
		ResultSet rs = null;
		Statement st = null;
		ArrayList <Marca> aLMarcas = new ArrayList <Marca>();
		
		String query = "SELECT * FROM marcas";
		st = conexion.createStatement();
					
		rs = st.executeQuery(query);
		while(rs.next()==true) {
			m = new Marca(rs.getInt(1), rs.getString(2));
			aLMarcas.add(m);
		}
		
		rs.close();
		st.close();
		return aLMarcas;
	}
	
	public ArrayList<Eficiencia> cargaCalificacionEnergetica() throws SQLException {
		Eficiencia e;
		ResultSet rs = null;
		Statement st = null;
		ArrayList <Eficiencia> aLEficiencia = new ArrayList <Eficiencia>();
		
		String query = "SELECT * FROM eficiencias";
		st = conexion.createStatement();
					
		rs = st.executeQuery(query);
		while(rs.next()==true) {
			e = new Eficiencia(rs.getString(1), rs.getString(2), rs.getString(3));
			aLEficiencia.add(e);
		}
		
		rs.close();
		st.close();
		return aLEficiencia;
	}
	
}
