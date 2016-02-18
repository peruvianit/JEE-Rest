package it.peruvianit.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import it.peruvanit.dto.UserDto;
import it.peruvanit.ejb.AdministrationLocal;
import it.peruvanit.exception.EjbAdministrationException;
import it.peruvian.mapper.AdministrationOutputMapper;
import it.peruvianit.commons.dto.dataAccess.DataTableRequestDto;
import it.peruvianit.commons.dto.dataAccess.DataTableResponseDto;
import it.peruvianit.data.dao.Tbl1001UsersDao;
import it.peruvianit.data.dto.PaginationContainerDto;
import it.peruvianit.data.exception.DataAccesException;
import it.peruvianit.data.repository.RepositoryPersistenceLocal;
import it.peruvianit.model.entity.Tbl1001Users;

@Component
@Stateless
@LocalBean
public class Administration implements AdministrationLocal{
	Logger logger = Logger.getLogger(Tbl1001UsersDao.class);
	
	@EJB
	RepositoryPersistenceLocal repositoryPersistenceLocal;
	
	@SuppressWarnings("unchecked")
	@Override
	public DataTableResponseDto getListUsers(DataTableRequestDto dataTableRequestDto) throws EjbAdministrationException,Exception {
		
		DataTableResponseDto dataTableResponseDto = new DataTableResponseDto();
		try {
			PaginationContainerDto paginationContainerDto = Tbl1001UsersDao.getInstance(repositoryPersistenceLocal.getEntityManager()).getListUsers(dataTableRequestDto);
			
			dataTableResponseDto.setsEcho(dataTableRequestDto.getsEcho());
			dataTableResponseDto.setAaData(AdministrationOutputMapper.Tbl1001UsersToUserDto((List<Tbl1001Users>)paginationContainerDto.getAaData()));			
			dataTableResponseDto.setiTotalRecords(paginationContainerDto.getiTotalRecords());
			dataTableResponseDto.setiTotalDisplayRecords(dataTableResponseDto.getiTotalRecords());
		} catch (DataAccesException daEx) {
			logger.error(dataTableRequestDto.toString());
			throw new EjbAdministrationException(daEx.getMessage());
		} catch (Exception e) {
			logger.error("Errore non gestito");			
		}
		
		return dataTableResponseDto;
	}	
	
	public boolean authentication(UserDto userDto) throws EjbAdministrationException {
		// DA IMPLEMENTARE
		return true;
		
	}
	
}
