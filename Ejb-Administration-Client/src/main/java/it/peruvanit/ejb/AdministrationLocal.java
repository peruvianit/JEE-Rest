package it.peruvanit.ejb;

import javax.ejb.Local;

import it.peruvianit.commons.dto.dataAccess.DataTableResponseDto;
import it.peruvanit.exception.EjbAdministrationException;
import it.peruvianit.commons.dto.dataAccess.DataTableRequestDto;

@Local
public interface AdministrationLocal {
	DataTableResponseDto getListUsers(DataTableRequestDto dataTableRequestDto) throws EjbAdministrationException,Exception;
}
