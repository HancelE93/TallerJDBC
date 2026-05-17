package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteVehiculo {
	
	private static final Logger log = LogManager.getLogger(DeleteVehiculo.class);
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = Conexion.getConnection();
			
			String sql = """ 
					delete from vehiculos where placa = ?
					""";
			ps = con.prepareStatement(sql);
			ps.setString(1, "PBN9003");
			
			int filas = ps.executeUpdate();
			
			log.info("Filas eliminadas: " + filas );

		} catch (Exception e) {
			log.error("Error al eliminar filas: "+ e.getMessage());
		}finally{
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		

	}

}
