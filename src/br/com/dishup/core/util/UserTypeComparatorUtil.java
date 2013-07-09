package br.com.dishup.core.util;

import java.util.Comparator;
import br.com.dishup.core.entity.UserTypeEntity;

public class UserTypeComparatorUtil implements Comparator<UserTypeEntity> {

	@Override
	public int compare(UserTypeEntity o1, UserTypeEntity o2) {
		if(o1.getId() > o2.getId()) 
			return 1;
		else if(o1.getId() < o2.getId()) 
			return -1;
		else
			return 0;
	}
}
