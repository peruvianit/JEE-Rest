package it.peruvianit.data.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import it.peruvianit.data.dto.PaginationContainerDto;
import it.peruvianit.data.exception.DataAccesException;
import it.peruvianit.commons.dto.dataAccess.DataTableRequestDto;

public class Tbl1001UsersDao extends GenericDao {
	private static String Tbl1001UsersDao_FIND_ALL = "SELECT u from Tbl1001Users as u";
	
	Logger logger = Logger.getLogger(Tbl1001UsersDao.class);
	
	private Tbl1001UsersDao(EntityManager em) {
		super(em);		
	}
	
	public static Tbl1001UsersDao getInstance(final EntityManager em) throws Exception {
		if (em == null) {
			throw new Exception("Repository configuration not found!");
		}
		return new Tbl1001UsersDao(em);
	}
	
	public PaginationContainerDto getListUsers(DataTableRequestDto dataTableRequestDto) throws DataAccesException{
		PaginationContainerDto paginationContainerDto = new PaginationContainerDto();
		
		try{
			String sSql = Tbl1001UsersDao_FIND_ALL;
			String condition = "";
			
			String paramUser = (String)dataTableRequestDto.getFilterParams().get("username");
			
			if (paramUser != null){
				condition+=" " + "usrNam LIKE '%" + paramUser + "%'";
			}
			
			if (condition != ""){
				sSql+=" where " + condition;
			}
			Query queryData = em.createQuery(sSql);		
			
			if (dataTableRequestDto.getiDisplayLength()!=null && dataTableRequestDto.getiDisplayStart() != null){					
				queryData.setMaxResults(dataTableRequestDto.getiDisplayLength());
				queryData.setFirstResult(dataTableRequestDto.getiDisplayStart());
				
				Query queryTotal = em.createQuery(sSql);
				paginationContainerDto.setiTotalRecords(queryTotal.getResultList().size());
			}else{
				paginationContainerDto.setiTotalRecords(queryData.getResultList().size());
			}
			paginationContainerDto.setAaData(queryData.getResultList());
		}catch(Exception ex){
			logger.error(ex.getMessage());
			throw new DataAccesException(ex.getMessage());
		}
		
		return paginationContainerDto;
	}
}
