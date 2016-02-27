package it.peruvianit.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import it.peruvanit.dto.UserDto;
import it.peruvanit.ejb.AdministrationLocal;
import it.peruvanit.exception.EjbAdministrationException;
import it.peruvanit.exception.RecordNotFoundException;
import it.peruvian.mapper.AdministrationOutputMapper;
import it.peruvianit.commons.dto.dataAccess.DataTableRequestDto;
import it.peruvianit.commons.dto.dataAccess.DataTableResponseDto;
import it.peruvianit.data.dao.Tbl1001UsersDao;
import it.peruvianit.data.dto.PaginationContainerDto;
import it.peruvianit.data.exception.DataAccesException;
import it.peruvianit.data.repository.RepositoryPersistenceLocal;
import it.peruvianit.model.entity.Tbl1001User;

@Component
@Stateless
@LocalBean
public class AdministrationBean implements AdministrationLocal{
	Logger logger = Logger.getLogger(AdministrationBean.class);
	
	@EJB
	RepositoryPersistenceLocal repositoryPersistenceLocal;
	
	@SuppressWarnings("unchecked")
	@Override
	public DataTableResponseDto getListUsers(DataTableRequestDto dataTableRequestDto) throws EjbAdministrationException,Exception {
		
		DataTableResponseDto dataTableResponseDto = new DataTableResponseDto();
		try {
			PaginationContainerDto paginationContainerDto = Tbl1001UsersDao.getInstance(repositoryPersistenceLocal.getEntityManager()).getListUsers(dataTableRequestDto);
			
			dataTableResponseDto.setsEcho(dataTableRequestDto.getsEcho());
			dataTableResponseDto.setAaData(AdministrationOutputMapper.Tbl1001UsersToUserDto((List<Tbl1001User>)paginationContainerDto.getAaData()));			
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
	
	public UserDto authentication(String userName) throws EjbAdministrationException,Exception {
		UserDto userDto = null;
		try{
			Tbl1001User tbl1001User = Tbl1001UsersDao.getInstance(repositoryPersistenceLocal.getEntityManager()).authenticationLogin(userName);
			if (tbl1001User!=null)
			{
				userDto = new UserDto();
				userDto.setName(tbl1001User.getNomUsr());
				userDto.setLastName(tbl1001User.getCogUsr());
				userDto.setUsername(tbl1001User.getUsrNam());
				userDto.setPassword(tbl1001User.getPassUsr());
			}
		}catch(NoResultException nRex){
			throw new RecordNotFoundException("Utente non trovato : {username : '" + userName + "'}");
		}
		
		return userDto;
	}
	
}
