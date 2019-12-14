package com.fruit.dao.impl;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.fruit.dao.FruitDao;
import com.fruit.dao.entity.FruitEntity;
import com.fruit.dao.entity.FruitPaginationEntity;

@Repository("IFruitDao")
public class IFruitDao implements FruitDao {
	
	@Autowired
	@Qualifier("fruitDataSource")
	private DataSource dataSource; 
	
	private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	public void mayur(){
		jdbcTemplate=new JdbcTemplate(dataSource);
	}

	@Override
	@Transactional(timeout=2,value="fruitTransactionManager",propagation=Propagation.NOT_SUPPORTED)
	public String addUpdateFruit(FruitEntity entity) {
	    LobHandler lobHandler = new DefaultLobHandler();
	    SqlLobValue sqlLobValue=null;
	    if(entity.getImage()!= null && entity.getImage().length==0){
	    	byte[] dimage=findImageByFid(entity.getSno()+"");
	    	sqlLobValue=new SqlLobValue(dimage,lobHandler);
	    }else{
	    	sqlLobValue=new SqlLobValue(entity.getImage(),lobHandler);	
	    }
        
        String query="";
        Object[] data={};
        int[] dataType={};
        if(entity.getSno()==0){
    		
        	query="insert into fruit_tbl (name,price,taste,quantity,pcity,image,doe) values(?,?,?,?,?,?,?)";
    		data=new Object[]{entity.getName(),entity.getPrice(),entity.getTaste(),entity.getQuantity(),entity.getPcity(),sqlLobValue,new Timestamp(new Date().getTime())};
    	    dataType=new int[] { Types.VARCHAR, Types.INTEGER,
                    Types.VARCHAR, Types.INTEGER, Types.VARCHAR,
                    Types.BLOB,Types.TIMESTAMP };
    	    jdbcTemplate.update(query,data,dataType);
    	    
    	    query="insert into fruit_tbl (name,price,taste,quantity,pcity,image,doe) values(?,?,?,?,?,?,?)";
    		data=new Object[]{entity.getName(),entity.getPrice(),entity.getTaste(),entity.getQuantity(),entity.getPcity(),sqlLobValue,new Timestamp(new Date().getTime())};
    	    dataType=new int[] { Types.VARCHAR, Types.INTEGER,
                    Types.VARCHAR, Types.INTEGER, Types.VARCHAR,
                    Types.BLOB,Types.TIMESTAMP };
    	    jdbcTemplate.update(query,data,dataType);
    	    //jdbcTemplate=null;
    	    try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	    query="insert into fruit_tbl (name,price,taste,quantity,pcity,image,doe) values(?,?,?,?,?,?,?)";
    		data=new Object[]{entity.getName(),entity.getPrice(),entity.getTaste(),entity.getQuantity(),entity.getPcity(),sqlLobValue,new Timestamp(new Date().getTime())};
    	    dataType=new int[] { Types.VARCHAR, Types.INTEGER,
                    Types.VARCHAR, Types.INTEGER, Types.VARCHAR,
                    Types.BLOB,Types.TIMESTAMP };
    	    jdbcTemplate.update(query,data,dataType);
        }else{
        	query="update fruit_tbl set name=?,price=?,taste=?,quantity=?,pcity=?,image=?  where sno=?";
    		data=new Object[]{entity.getName(),entity.getPrice(),entity.getTaste(),entity.getQuantity(),entity.getPcity(),sqlLobValue,entity.getSno()};
    	    dataType=new int[] { Types.VARCHAR, Types.INTEGER,
                    Types.VARCHAR, Types.INTEGER, Types.VARCHAR,
                    Types.BLOB,Types.INTEGER };
    	    jdbcTemplate.update(query,data,dataType);
        }
		
		return "success";
	}

	@Override
	public List<FruitEntity> findFruits() {
		String query="select sno,name,price,taste,quantity,pcity,doe from fruit_tbl";
		List<FruitEntity> fruitList=jdbcTemplate.query(query, new BeanPropertyRowMapper(FruitEntity.class));
		return fruitList;
	}
	
	@Override
	public List<FruitEntity> findFruitsByCity(String search) {
		String query="select sno,name,price,taste,quantity,pcity,doe from fruit_tbl where name like '%"+search+"%' or taste like '%"+search+"%' or pcity like '%"+search+"%' order by sno LIMIT 5";
		List<FruitEntity> fruitList=jdbcTemplate.query(query,new BeanPropertyRowMapper(FruitEntity.class));
		return fruitList;
	}
	
	@Override
	public String deleteFruitByFid(String fid) {
		String query="delete  from fruit_tbl where sno="+fid;
		int p=jdbcTemplate.update(query);
		return p==0?"fail":"deleted";
	}
	
	
	
	@Override
	public FruitPaginationEntity findFruitsWithPagination(int start, int noOfRecords) {
		
		 boolean b=TransactionSynchronizationManager.isActualTransactionActive();
		 if(b){
			 System.out.println("||||||||||||||||||||||Spring TX is enable and working here ....................");
		 }else{
				 System.out.println("||||||||||||||||||||||Spring TX is not enable and not working here ....................");
		 }
        /*
         * A SELECT statement may include a LIMIT clause to restrict the number
         * of rows the server returns to the client. In some cases, it is
         * desirable to know how many rows the statement would have returned
         * without the LIMIT, but without running the statement again. To obtain
         * this row count, include a SQL_CALC_FOUND_ROWS option in the SELECT
         * statement, and then invoke FOUND_ROWS() afterward:
         */
		// 3
		//0,1,2    = 3,4,5 
        String query = "select  * from fruit_tbl limit " + start + ", " + noOfRecords;
        List<FruitEntity> fruitEntityList = (List<FruitEntity>) jdbcTemplate  .query(query,
                        new BeanPropertyRowMapper(FruitEntity.class));
        // To obtain this row count, include a SQL_CALC_FOUND_ROWS option in the
        // SELECT statement, and then invoke FOUND_ROWS() afterward
        FruitPaginationEntity fruitPaginationEntity = new FruitPaginationEntity();
        int tnoOfRecords = jdbcTemplate.queryForInt("select count(*)  from fruit_tbl");
        fruitPaginationEntity.setNoOfRecords(tnoOfRecords);
        fruitPaginationEntity.setFruitEntityList(fruitEntityList);
        /* query a total number of rows from database. */
        return fruitPaginationEntity;
	} 

	@Override
	public byte[] findImageByFid(String fid) {
		String query="select * from fruit_tbl where sno="+fid;
		FruitEntity fruitEntity=(FruitEntity)jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper(FruitEntity.class));
		return fruitEntity.getImage();
	}
	
	@Override
	public FruitEntity findFruitByFid(String fid) {
		String query="select * from fruit_tbl where sno="+fid;
		FruitEntity fruitEntity=(FruitEntity)jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper(FruitEntity.class));
		return fruitEntity;
	}

	@Override
	public List<String> findAllCity() {
		String query="select cname from cities_tbl";
		List<String> fruitList=jdbcTemplate.queryForList(query, String.class);
		return fruitList;
	}

}
