package com.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Path("RestService")
public class Rest {
	
	@GET 
	@Path("/listaStocksXML") 
	@Produces(MediaType.APPLICATION_XML + ";charset=utf-8")
	public String listaStocksXML(){
		
		StringBuffer xml = new StringBuffer("<stocks>");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
    	Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Stock");
        List<Stock> stocks = query.list();
        
        for(Stock stock : stocks){
        	xml.append("<stock>");
        	xml.append("<id>"+stock.id+"</id>");
        	xml.append("<precio>"+stock.precio+"</precio>");
        	xml.append("<maquinaria>"+stock.maquinaria+"</maquinaria>");
        	xml.append("<municipalidad>"+stock.municipalidad+"</municipalidad>");
        	xml.append("</stock>");
        }
        
        xml.append("</stocks>");
        
        tx.commit();
        
        session.close();
        return xml.toString();
        
	}
	
	@GET 
	@Path("/listaStocks") 
	@Produces("application/json")
	public Stock listaStocks(){
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
    	Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Stock");
        List<Stock> stocks = query.list();
        
        Stock s = null;
        
        for(Stock stock : stocks){
        	s = new Stock(stock.id, stock.precio, stock.maquinaria, stock.municipalidad);
        }
        
        tx.commit();
        
        session.close();
        return s;
        
	}
	
	@GET 
	@Path("/buscarMaquinaria") 
	@Produces("application/json")
	public Stock login(@QueryParam("id") String id) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
    	Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Stock where id = " + id);
        
        List<Stock> stock = query.list();
        
        Stock s = null;
        
        if(stock != null){
        	 s = new Stock(stock.get(0).id, stock.get(0).precio, stock.get(0).maquinaria, stock.get(0).municipalidad);
        }
        
        tx.commit();
        
        session.close();
        
        return s;
        
	}

}
