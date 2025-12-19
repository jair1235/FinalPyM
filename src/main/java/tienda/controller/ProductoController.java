package tienda.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tienda.entities.Producto;
import tienda.services.IProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	
	private final IProductoService productoServiceI;

	public ProductoController(IProductoService productoServiceI) {
		this.productoServiceI = productoServiceI;
	}
	@GetMapping("/mostrar")
	public String mostrarProductos(Model model) {
		model.addAttribute("productos", productoServiceI.mostrarTodos());
		return "productos/mostrar";
	}
	
	@PostMapping("/crear")
	public String crearProducto(
			@RequestParam String nombre,
			@RequestParam BigDecimal precio,
			@RequestParam int cantidad,
			Model model) {
		Producto producto = new Producto();
		producto.setNombreProducto(nombre);
		producto.setCantidadProducto(cantidad);
		producto.setPrecioProducto(precio);
		productoServiceI.insertarProducto(producto);
		return "redirect:/productos/mostrar";
	}
	@PostMapping("/actualizar-precio")
	public String actualizarProducto(
			@RequestParam Integer id, 
			@RequestParam BigDecimal precio,
			Model model) {
		Producto productoActualizado = productoServiceI.actualizarPorPrecio(id, precio);
		if(productoActualizado==null) {
			model.addAttribute("error", "no se pudo realizar la operación");
		}
		return "redirect:/productos/mostrar";
	}
	@PostMapping("/actualizar-nombre")
	public String actualizarNombre(
			@RequestParam Integer id,
			@RequestParam String nombre,
			Model model) {
		Producto productoActualizadoNombre = productoServiceI.actualizarPorNombre(id, nombre);
		if (productoActualizadoNombre == null) {
			model.addAttribute("error", "no se pudo realizar la operación");
		}
		return "redirect:/productos/mostrar";
	};
	@PostMapping("/actualizar-cantidad")
	public String actualizarCantidad(
			@RequestParam Integer id, 
			@RequestParam Integer cantidad,
			Model model) {
		Producto productoActualizadoCantidad = productoServiceI.actualizarPorCantidad(id, cantidad);
		if(productoActualizadoCantidad==null) {
			model.addAttribute("error", "no se pudo completar la operaacion");
		}
		return("redirect:/productos/mostrar");
	};
	@PostMapping("/eliminar-producto")
	public String eliminarProducto(
			@RequestParam Integer id, 
			Model model) {
		productoServiceI.eliminarProducto(id);
		return "redirect:/productos/mostrar";
	};
	@GetMapping("/dashboard")
	public String dashboard(Model model) {

		Producto productoCritico = productoServiceI.productoCercanoAcabarse();
		BigDecimal totalInventario = productoServiceI.calcularTotalInventario();

		model.addAttribute("productoCritico", productoCritico);
		model.addAttribute("totalInventario", totalInventario);

		return "productos/dashboard";
	}

	
}
