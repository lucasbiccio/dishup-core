package br.com.dishup.core.util;

import java.util.Comparator;
import br.com.dishup.core.entity.UserStatusEntity;

public class UserStatusComparatorUtil implements Comparator<UserStatusEntity>{

	@Override
	public int compare(UserStatusEntity s1, UserStatusEntity s2) {
		if(s1.getId() > s2.getId()) 
			return 1;
		else if(s1.getId() < s2.getId()) 
			return -1;
		else
			return 0;
	}
}
