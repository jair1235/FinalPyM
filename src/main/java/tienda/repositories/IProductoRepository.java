package tienda.repositories;

import org.springframework.data.repository.CrudRepository;

import tienda.entities.Producto;

public interface IProductoRepository extends CrudRepository<Producto, Integer>{
 
}
