package tienda.services;

import java.math.BigDecimal;

import tienda.entities.Producto;

public interface IProductoService {
	Producto insertarProducto(Producto producto);
	
	//Producto actualizarProducto(Integer id, Producto producto); se usa los de abajo para especificar la log de negocio aún maás 
	Producto actualizarPorPrecio(Integer id, BigDecimal precio);
	Producto actualizarPorCantidad(Integer id, int cantidad);
	Producto actualizarPorNombre(Integer id, String nombre);
	boolean eliminarProducto(Integer id);
	Producto productoCercanoAcabarse();
	BigDecimal calcularTotalInventario();  
	Iterable<Producto> mostrarTodos();
}
