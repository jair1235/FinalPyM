package tienda.services.impl;



import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tienda.entities.Producto;
import tienda.repositories.IProductoRepository;
import tienda.services.IProductoService;

@Service
public class ProductoService  implements IProductoService {

	
	@Autowired 
	private IProductoRepository productoRepo;
	
   

	@Override
	public Producto insertarProducto(Producto producto) {
		return productoRepo.save(producto);
	}

	@Override
	public Producto actualizarPorPrecio(Integer id, BigDecimal precio) {
		Producto producto = productoRepo.findById(id).orElse(null);
		if(producto!=null) {
			producto.setPrecioProducto(precio);
			return productoRepo.save(producto);
		}
		return null;
	}

	@Override
	public Producto actualizarPorCantidad(Integer id, int cantidad) {
		Producto producto= productoRepo.findById(id).orElse(null);
		if(producto!=null) {
			if(cantidad>=0) {
				producto.setCantidadProducto(cantidad);
				return productoRepo.save(producto);
			}else {return null;}
		}
		return null;
	}

	@Override
	public Producto actualizarPorNombre(Integer id, String nombre) {
		Producto producto = productoRepo.findById(id).orElse(null);
		if(producto!=null) {
			if(nombre!=null) {
				producto.setNombreProducto(nombre);
				return productoRepo.save(producto);
			}
		}
		return null;
	}

	@Override
	public boolean eliminarProducto(Integer id) {
		Producto producto = productoRepo.findById(id).orElse(null);
		if(producto!=null) {
			productoRepo.delete(producto);
			return true;
		}
		return false;
	}

	@Override
	public Producto productoCercanoAcabarse() {
		Iterable<Producto>productos=productoRepo.findAll();
		Producto menorInicio=null;
		for(Producto producto: productos) {
			if(menorInicio==null|| producto.getCantidadProducto()<menorInicio.getCantidadProducto()) {
				menorInicio=producto;
			}
		}
		return menorInicio;
	}

	@Override
	public BigDecimal calcularTotalInventario() {
		Iterable<Producto>productosaCalcular=productoRepo.findAll();
		BigDecimal calcularTotal= BigDecimal.ZERO;
		for(Producto producto:productosaCalcular) {
			BigDecimal totalizadora= producto.getPrecioProducto().multiply(BigDecimal.valueOf(producto.getCantidadProducto()));
			calcularTotal=calcularTotal.add(totalizadora); 
		}
		return calcularTotal;
	}

	@Override
	public Iterable<Producto> mostrarTodos() {
		
		return productoRepo.findAll();
	}
	
}
