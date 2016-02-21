package it.peruvian.mapper;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import it.peruvanit.dto.*;
import it.peruvianit.model.entity.Tbl1001User;

public class AdministrationOutputMapper {
	protected static final Logger logger = Logger.getLogger(AdministrationOutputMapper.class);
	
	public static List<UserDto> Tbl1001UsersToUserDto(List<Tbl1001User> listTbl1001Users){
		List<UserDto> listUserDto = new LinkedList<UserDto>();
		
		for (Tbl1001User tbl1001Users : listTbl1001Users) {
			UserDto userDto = new UserDto();
			userDto.setUsername(tbl1001Users.getUsrNam());
			userDto.setName(tbl1001Users.getNomUsr());
			userDto.setLastName(tbl1001Users.getCogUsr());
			userDto.setEmail(tbl1001Users.getEmlUsr());
			listUserDto.add(userDto);
		}
		
		return listUserDto;
	}
}
