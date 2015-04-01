package restful;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.DetalleStockMunicipalidad;
import model.StockMunicipalidad;
import model.TipoMaquinaria;
import model.Municipalidad;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import aux_model.Evento;
import aux_model.Propriedad;

import dto.ListaDetalleStockMunicipalidad;
import dto.ObtenerCodigoNombreMaquinariaDto;
import dto.ObtenerPrecioTipoMaquinaria;
import dto.TipoMaquinariaDto;

import util.HibernateUtil;
import util.Verificar;

@Path("Maquinaria")
public class Rest {
	
	@GET 
	@Path("/tipomaquinarias") 
	@Produces("application/json")
	public Response tipoMaquinarias(){
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
    	Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from TipoMaquinaria");
        List<TipoMaquinaria> tipoMaquinarias = query.list(); //retirar el campo alquileres del json...
        
        List<TipoMaquinariaDto> tipomaq = new ArrayList<TipoMaquinariaDto>();
        
        for(TipoMaquinaria tipoMaquinaria : tipoMaquinarias){
        	tipomaq.add(new TipoMaquinariaDto(tipoMaquinaria.id, tipoMaquinaria.nombre));
        }
        
        tx.commit();
        
        session.close();
        
        return Response.ok().entity(tipomaq).header("Access-Control-Allow-Origin","*")
        		.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        
	}
	
	@GET 
	@Path("/municipalidades") 
	@Produces("application/json")
	public Response municipalidades(){
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
    	Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Municipalidad");
        List<Municipalidad> municipalidades = query.list();
        
        List<Municipalidad> muni = new ArrayList<Municipalidad>();
        
        for(Municipalidad municipalidad : municipalidades){
        	muni.add(new Municipalidad(municipalidad.id, municipalidad.nombre, municipalidad.ubicacion));
        }
        
        tx.commit();
        
        session.close();
        return Response.ok().entity(muni).header("Access-Control-Allow-Origin","*")
        		.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        
	}
	
	@GET 
	@Path("/codigomaquinaria") 
	@Produces("application/json")
	public Response codigoPorMaquinaria(){
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
    	Transaction tx = session.beginTransaction();
        Query query = session.createQuery("select sk.codigo, tm.nombre from StockMunicipalidad sk inner join sk.tipoMaquinaria tm ");
        List<Object[]> stockMunicipalidades = query.list();
        
        List<ObtenerCodigoNombreMaquinariaDto> listCodigoPorMaquinaria = new ArrayList<ObtenerCodigoNombreMaquinariaDto>();
        
        for(Object[] stockMaquinaria : stockMunicipalidades){
        	String codigoMaquinaria = (String)stockMaquinaria[0];
            String nombreMaquinaria = (String)stockMaquinaria[1];
        	listCodigoPorMaquinaria.add(new ObtenerCodigoNombreMaquinariaDto(codigoMaquinaria,nombreMaquinaria));
        }
        
        tx.commit();
        
        session.close();
        return Response.ok().entity(listCodigoPorMaquinaria).header("Access-Control-Allow-Origin","*")
        		.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        
	}
	
	@GET 
	@Path("/obtenerprecio/{codigo}")
	@Produces("application/json")
	public Response obtenerPrecioPorHora(@PathParam("codigo") String codigo){
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
    	Transaction tx = session.beginTransaction();
        Query query = session.createQuery("select a.p_hora from StockMunicipalidad sk inner join sk.tipoMaquinaria tm " +
        		" inner join tm.alquileres a where sk.codigo = '" + codigo + "'");
        Double stockMunicipalidades = (Double)query.uniqueResult();
        
        ObtenerPrecioTipoMaquinaria obtenerPrecio = new ObtenerPrecioTipoMaquinaria(stockMunicipalidades);
        
        tx.commit();
        
        session.close();
        return Response.ok().entity(obtenerPrecio).header("Access-Control-Allow-Origin","*")
        		.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        
	}
	
	@GET 
	@Path("/obtenerfechas/{codigo}")
	@Produces("application/json")
	public Response obtenerFechas(@PathParam("codigo") String codigo){
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
    	Transaction tx = session.beginTransaction();
        Query query = session.createQuery("select m.fechaInicio, m.fechaFin from Movimiento m where m.stockMunicipalidad = '" + codigo + "'");
        List<Object[]> fechas = query.list();
        
        Evento evento = null;
        //String resultado = "";
        
        for(Object[] fecha : fechas){
        	List<Propriedad> lp = new ArrayList<Propriedad>();
        	Propriedad p = new Propriedad("Reservado", String.valueOf(fecha[0]).replace(" 00:00:00.0", ""), 
        			String.valueOf(fecha[1]).replace(" 00:00:00.0", ""));
        	lp.add(p);
        	
        	evento = new Evento(lp, "yellow", "black");
        	
        	/*resultado = "{ " +
        			    " events [ " +
        			    " 	{ " +
        			    "    	title: 'Reservado', " +
        			    "       start: '" + String.valueOf(fecha[0]).replace(" 00:00:00.0", "") + "'," +
        			    "       end: '" + String.valueOf(fecha[1]).replace(" 00:00:00.0", "") + "'" +
        	            "   } " +
        			    " ]" +
        	            "}";*/
        }
        
        tx.commit();
        
        session.close();
        return Response.ok().entity(evento).header("Access-Control-Allow-Origin","*")
        		.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        
	}
	
	@POST
	@Path("/principal/{dni}/{ciudadano}/{direccionCiudadano}/{ruc}/{empresa}/{direccionEmpresa}/{costoTotal}/{municipalidad}") 
	@Produces("application/json")
	@Consumes("application/x-www-form-urlencoded")
	public Response nuevoPrincipal(@PathParam("dni") String dni, @PathParam("ciudadano") String ciudadano,
			                       @PathParam("direccionCiudadano") String direccionCiudadano, @PathParam("ruc") String ruc,
			                       @PathParam("empresa") String empresa, @PathParam("direccionEmpresa") String direccionEmpresa,
			                       @PathParam("costoTotal") double costoTotal, @PathParam("municipalidad") long municipalidad) throws UnsupportedEncodingException{
		
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Municipalidad where id = " + municipalidad);
        Municipalidad municipalidadEncontrada = (Municipalidad) query.uniqueResult();
        
        model.Principal principal = new model.Principal(dni, ciudadano, direccionCiudadano, ruc, empresa, direccionEmpresa, costoTotal, municipalidadEncontrada);
        
        session.save(principal);
        
        tx.commit();
        
        session.close();
        
        Verificar verificar = new Verificar(true, "OK!");
        
		return Response.ok().entity(verificar).header("Access-Control-Allow-Origin","*")
        		.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
	}
	
	@GET 
	@Path("/detallestockmunicipalidad")
	@Produces("application/json")
	public Response listaDetalleStockMunicipalidad() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
    	Transaction tx = session.beginTransaction();
    	Query query = session.createQuery("select sm.codigo, tm.nombre, dsm.id, dsm.fechaInicio, dsm.fechaFin, dsm.costoTotal " +
    			" from DetalleStockMunicipalidad dsm inner join dsm.stockMunicipalidad sm inner join sm.tipoMaquinaria tm ");
        List<Object[]> listas = query.list();
        
        List<ListaDetalleStockMunicipalidad> detalles = new ArrayList<ListaDetalleStockMunicipalidad>();
        
        for(Object[] lista : listas){
        	
        	String codigoStockMunicipalidad = (String)lista[0];
        	String nombreTipoMaquinaria = String.valueOf(lista[1]);
        	long idDetalleStockMunicipalidad = (Long)lista[2];
        	String fechaInicio = String.valueOf(lista[3]).replace(" 00:00:00.0", "");
        	String fechaFin = String.valueOf(lista[4]).replace(" 00:00:00.0", "");
        	double costoTotal = (Double)lista[5];
        	
            detalles.add(new ListaDetalleStockMunicipalidad(codigoStockMunicipalidad, nombreTipoMaquinaria,
        			idDetalleStockMunicipalidad, fechaInicio, fechaFin,	costoTotal));
        }
        
        tx.commit();
        
        session.close();
        return Response.ok().entity(detalles).header("Access-Control-Allow-Origin","*")
        		.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        
	}
	
	@POST
	@Path("/detallestockmunicipalidad/{stockMunicipalidad}/{fechaInicio}/{fechaFin}/{costoTotal}") 
	@Produces("application/json")
	@Consumes("application/x-www-form-urlencoded")
	public Response nuevoDetalleStockMunicipalidad(@PathParam("stockMunicipalidad") String stockMunicipalidad, @PathParam("fechaInicio") String fechaInicio,
			@PathParam("fechaFin") String fechaFin, @PathParam("costoTotal") double costoTotal) throws ParseException{
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from StockMunicipalidad where codigo = '" + stockMunicipalidad + "'");
        StockMunicipalidad stockMunicipalidadEncontrada = (StockMunicipalidad) query.uniqueResult();
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        Date inicio = formatter.parse(fechaInicio);
        Date fin = formatter.parse(fechaFin);
        
        DetalleStockMunicipalidad detalle = new DetalleStockMunicipalidad(stockMunicipalidadEncontrada, inicio, fin, costoTotal);
        
        session.save(detalle);
        
        tx.commit();
        
        session.close();
        
        Verificar verificar = new Verificar(true, "OK!");
        
		return Response.ok().entity(verificar).header("Access-Control-Allow-Origin","*")
        		.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
	}
	
	
	/*@GET 
	@Path("/maquinarias/{id}") 
	@Produces("application/json")
	public Stock login(@PathParam("id") String id) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
    	Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Stock where id = " + id);
        
        List<Stock> stock = query.list();
        
        Stock s = null;
        
        if(stock.size() > 0){
        	 s = new Stock(stock.get(0).id, stock.get(0).precio, stock.get(0).maquinaria, stock.get(0).municipalidad);
        } else {
        	s = new Stock();
        }
        
        tx.commit();
        
        session.close();
        
        return s;
        
	}*/

}
