package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertVehiculo {

	private static final Logger log = LogManager.getLogger(InsertVehiculo.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = Conexion.getConnection();

			String sql = """
					INSERT INTO vehiculos (placa, marca, modelo, anio, precio, color, disponible)
					VALUES (?, ? , ?, ?, ?, ?, ?);
					""";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, "PBN9004");
			ps.setString(2, "Hyundai");
			ps.setString(3, "GranI10");
			ps.setInt(4, 2018);
			ps.setDouble(5, 15500);
			ps.setString(6, "Rojo");
			ps.setBoolean(7, true);
			
			
			int filas = ps.executeUpdate();
			log.info("!!Conexion Exitosa!!");
			log.info("Filas insertadas: " + filas);
			

		} catch (Exception e) {
			log.error("Error de conexion: "+ e.getMessage());
		}finally{
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		

	}

}
