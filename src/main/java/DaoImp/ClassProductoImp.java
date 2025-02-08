package DaoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IProducto;
import model.TblProducto;

public class ClassProductoImp implements IProducto {

	@Override
	public void RegistrarProducto(TblProducto tblproducto) {
		//nos conectamos con la unidad de persistencia...
				//para poder registrar datos en la base de datos...
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoEAJPAMaven2025");
				EntityManager em=emf.createEntityManager();
					//iniciamos las transaccion...
					em.getTransaction().begin();
					//invocamos el metodo registrar...
					//esto seria en jdbc insert into tbl_producto values........
					//en jpa es persist...
					em.persist(tblproducto);
					//emitimos mensaje por pantalla...
					System.out.println("Producto registrado en BD correctamente!!!!!");
					//confirmamos
					em.getTransaction().commit();
					//cerramos
					em.close();
		} // Fin del metodo registrar producto

	@Override
	public void ActualizarProducto(TblProducto tblproducto) {
		//nos conectamos con la unidad de persistencia...
		//para poder actualizar lis registros...
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoEAJPAMaven2025");
		EntityManager em=emf.createEntityManager();
		try{
			//iniciamos las transaccion...
			em.getTransaction().begin();
			//invocamos el metodo actualizar...
			//esto seria en jdbc insert into tbl_producto values........
			//en jpa es persist...
			em.merge(tblproducto);
			//confirmamos
			em.getTransaction().commit();
		}catch(RuntimeException e){
			e.getMessage();
		}finally{
			//cerramos
			em.close();
		}//fin del finally.
	} // Fin del metodo actualizar producto

	@Override
	public void EliminarProducto(TblProducto tblproducto) {
		//nos conectamos con la unidad de persistencia...
				//para poder actualizar lis registros...
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoEAJPAMaven2025");
				EntityManager em=emf.createEntityManager();
				try{
					//iniciamos las transaccion...
					em.getTransaction().begin();
					//recuperamos el codigo a eliminar
					TblProducto tblproelim=em.find(TblProducto.class,tblproducto.getIdproducto());
					//aplicamos una condicion...
					if (tblproducto!=null){
						//eliminamos el codigo...
						em.remove(tblproelim);
						//confirmamos
						em.getTransaction().commit();
					}//fin de la condicion
				}catch(RuntimeException e){
					if(em.getTransaction().isActive()) em.getTransaction().rollback();
					e.getMessage();
				}finally{
					//cerramos
					em.close();
				}//fin del finally.
		} // Fin del metodo eliminar producto

	@Override
	public TblProducto BuscarProducto(TblProducto tblproducto) {
		//nos conectamos con la unidad de persistencia...
		//para realizar la respectiva busqueda...
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoEAJPAMaven2025");
		EntityManager em=emf.createEntityManager();
		//hacemos la respectiva instancia...
		TblProducto bustblprod=null;
		try{
			//iniciamos las transaccion...
			em.getTransaction().begin();
			//buscamos el respectivo codigo
			bustblprod=em.find(TblProducto.class,tblproducto.getIdproducto());
			//confirmamos
			em.getTransaction().commit();
		}catch(RuntimeException e){
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			//emitimos un mensaje
			e.getMessage();
		}finally{
			//cerramos
			em.close();
		}//fin del finally.
		return bustblprod;
	} // Fin del metodo buscar producto

	@Override
	public List<TblProducto> ListadoProductos() {
		//nos conectamos con la unidad de persistencia...
				//para realizar el listado del producto..
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoEAJPAMaven2025");
				EntityManager em=emf.createEntityManager();
				List<TblProducto> Listado=null;
				try{
					//iniciamos las transaccion...
					em.getTransaction().begin();
					//Aplicamos consulta JPQL
					Listado = em.createQuery("Select p from TblProducto p",TblProducto.class).getResultList();
					//confirmamos
					em.getTransaction().commit();
					
				}catch(RuntimeException e){
					//aplicamos una condicion
					if(em.getTransaction().isActive()) em.getTransaction().rollback();
					//emitimos un mensaje
					e.getMessage();
				}finally{
					//cerramos
					em.close();
				}//fin del finally.
				//retornamos el listado...
				return Listado;
		  } // Fin del metodo listado productos

		}  //Fin de la clase....
