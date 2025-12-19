package tienda.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {
	@Test
	void verificarNombre(){
		Producto producto = new Producto();
		producto.setNombreProducto("queso");
		assertEquals("queso", producto.getNombreProducto());
	}
}
