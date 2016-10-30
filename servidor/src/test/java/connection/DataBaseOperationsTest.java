package connection;

import java.sql.SQLException;

import org.junit.Test;

import connection.DataBaseOperations;
import entities.Usuario;
import junit.framework.Assert;

public class DataBaseOperationsTest {

	@Test
	public void updateUsuarioTest() throws SQLException {
		DataBaseOperations db = new DataBaseOperations();	
		db.actualizarUsuario(1,"Gustavo","123");
	}

	@Test
	public void insertUsuarioTest() throws SQLException {
		DataBaseOperations db = new DataBaseOperations();	
		db.agregarUsuario(2, "pepe", "123");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void getUsuarioTest() throws SQLException {
		Usuario u;
		DataBaseOperations db = new DataBaseOperations();	
		u=db.obtenerUsuario(1);
		Assert.assertEquals("Gustavo", u.getUsername());
	}
}
