package TestEntidades;

import java.util.Date;
import java.util.List;

import DaoImp.ClassProductoImp;
import model.TblProducto;

public class TestEntidaProducto {

	public static void main(String[] args) {
		//realizamos nuestrar respetivas instancias....
		TblProducto tblprod=new TblProducto();
		ClassProductoImp crudimp=new ClassProductoImp();
		//*******************testeando el metodo registrar.....
		//asignamos valores
		/*tblprod.setCantidad(4);
		tblprod.setPrecio(3);
		tblprod.setTotal(tblprod.getCantidad()*tblprod.getPrecio());
		tblprod.setNomprod("mantequilla");
		tblprod.setNrolote("lot5555");
		tblprod.setCodbarras("cod787859");
		// Utilizamos java.sql.Date para la fecha
		Date fecha=new Date(0);
		Date fechasql=new Date(fecha.getTime());
		tblprod.setFechaven(fechasql);
        
		//invocamos el metodo registrar...
		crudimp.RegistrarProducto(tblprod);
		//emitimos mensaje por consola
		System.out.println("Dato registrado correctamente en BD!!!!!!");
		*/
		
		//********************testeando el metodo actualizar.....
		//asigno el codigo a actualizar...
		/*tblprod.setIdproducto(6);
		tblprod.setCantidad(10);
		tblprod.setPrecio(5);
		tblprod.setTotal(tblprod.getCantidad()*tblprod.getPrecio());
		tblprod.setNomprod("fideos");
		tblprod.setNrolote("lote2025");
		tblprod.setCodbarras("cod789456");
		// Utilizamos java.sql.Date para la fecha
		Date fecha=new Date();
		Date fechasql=new Date(fecha.getTime());
		tblprod.setFechaven(fechasql);
        
		//invocamos el metodo registrar...
		crudimp.ActualizarProducto(tblprod);
		//emitimos mensaje por consola
		System.out.println("Dato actualizado correctamente en BD!!!!!!");
		*/
		
		
		//********************testeando el metodo eliminar.....
		//eliminamos el codigo de numero 5
		/*tblprod.setIdproducto(8);
		//invocamos el metodo eliminar...
		crudimp.EliminarProducto(tblprod);
		//emitimos mensaje por consola
		System.out.println(" Dato eliminado correctamente en BD!!!!!!");
		*/
		
		//********************testeando el metodo buscar.....
		//buscamos el codigo  4
		/*tblprod.setIdproducto(7);
		//invocamos el metodo buscar...
		TblProducto tblproducto=crudimp.BuscarProducto(tblprod);
		//emitimos mensaje por consola
		System.out.println( " Codigo "+tblproducto.getIdproducto()+ 
				" Nombre del Producto "+tblproducto.getNomprod()+
				" Cantidad "+tblproducto.getCantidad()+
				" Precio "+tblproducto.getPrecio() + " Total "+tblproducto.getTotal()+
				" Nro lote "+tblproducto.getNrolote());
		*/
		
		//********************testeando el metodo listar.....
		
		List<TblProducto> listadoproducto=crudimp.ListadoProductos();
		
		for(TblProducto prod:listadoproducto){
	
		//emitimos mensaje por consola
		System.out.println("Codigo "+prod.getIdproducto()+ " producto "
		+prod.getNomprod()+" precio "+prod.getPrecio() +" cantidad "
				+prod.getCantidad()+" total "+prod.getTotal()+
				" codigo de barras "+prod.getCodbarras());		
		}//Fin del bucle for ...
		
		
		
   }// fin del metodo principal..

} // Fin de la clase...
