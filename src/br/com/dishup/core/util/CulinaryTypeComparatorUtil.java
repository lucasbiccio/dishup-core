package br.com.dishup.core.util;

import java.util.Comparator;
import br.com.dishup.core.entity.CulinaryTypeEntity;

public class CulinaryTypeComparatorUtil implements Comparator<CulinaryTypeEntity>{

	@Override
	public int compare(CulinaryTypeEntity s1, CulinaryTypeEntity s2) {
		if(s1.getId() > s2.getId()) 
			return 1;
		else if(s1.getId() < s2.getId()) 
			return -1;
		else
			return 0;
	}
}
