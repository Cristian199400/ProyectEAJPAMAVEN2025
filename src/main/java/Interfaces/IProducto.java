package Interfaces;

import java.util.List;

import model.TblProducto;

public interface IProducto {

	//declaramos los metodos....
		void RegistrarProducto(TblProducto tblproducto);
		void ActualizarProducto(TblProducto tblproducto);
		void EliminarProducto(TblProducto tblproducto);
		TblProducto BuscarProducto(TblProducto tblproducto);
		List<TblProducto> ListadoProductos();

	  
}//Fin de la interface producto
