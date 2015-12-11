package net.codejava.spring.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;












import net.codejava.spring.model.Category;
import net.codejava.spring.model.Stock;
import net.codejava.spring.model.StockDailyRecord;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

public class StockDAOImpl  {
	private SessionFactory sessionFactory;
    private Session session ;
	public StockDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


    public void add() {
        Transaction trns = null;
        Session session = sessionFactory.openSession();
        try {
        	session.beginTransaction();

        	Stock stock = new Stock();
                stock.setStockCode("7052");
                stock.setStockName("PADINI");
                session.save(stock);
                
                StockDailyRecord stockDailyRecords = new StockDailyRecord();
                stockDailyRecords.setPriceOpen(new Float("1.2"));
                stockDailyRecords.setPriceClose(new Float("1.1"));
                stockDailyRecords.setPriceChange(new Float("10.0"));
                stockDailyRecords.setVolume(3000000L);
                stockDailyRecords.setDate(new Date());
                
                stockDailyRecords.setStock(stock);        
                stock.getStockDailyRecords().add(stockDailyRecords);

                session.save(stockDailyRecords);

        	session.getTransaction().commit();
        		}catch(Exception e){
        			e.printStackTrace();
        		}
         finally {
        	session.clear();
            session.flush();
            session.close();
        }
    }



	}






    

