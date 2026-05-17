package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UpdateVehiculo {

	private static final Logger log = LogManager.getLogger(UpdateVehiculo.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement ps = null;
		
		
		try {
			con = Conexion.getConnection();
			
			String sql = """ 
					update vehiculos set marca = ?, modelo = ?, anio =?, precio =?, color =?, disponible =?
					where placa = ?
					""";
			ps = con.prepareStatement(sql);
			ps.setString(1, "Kia");
			ps.setString(2, "Picanto");
			ps.setInt(3, 2018);
			ps.setDouble(4, 16000);
			ps.setString(5, "Blanco");
			ps.setBoolean(6, false);
			ps.setString(7, "PBN9003");
	
			int filas = ps.executeUpdate();
			
			log.info("Filas actualizadas: " + filas );

		} catch (Exception e) {
			log.error("Error al actualizar: "+ e.getMessage());
		}finally{
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		

	}

}
