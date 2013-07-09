package br.com.dishup.core.util;

import java.util.Comparator;
import br.com.dishup.core.entity.CityEntity;

public class CityComparatorUtil implements Comparator<CityEntity> {

	@Override
	public int compare(CityEntity c1, CityEntity c2) {
		if(c1.getId() > c2.getId()) 
			return 1;
		else if(c1.getId() < c2.getId()) 
			return -1;
		else
			return 0;
	}
}
