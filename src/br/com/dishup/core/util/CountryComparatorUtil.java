package br.com.dishup.core.util;

import java.util.Comparator;
import br.com.dishup.core.entity.CountryEntity;

public class CountryComparatorUtil implements Comparator<CountryEntity> {

	@Override
	public int compare(CountryEntity p1, CountryEntity p2) {
		if(p1.getId() > p2.getId()) 
			return 1;
		else if(p1.getId() < p2.getId()) 
			return -1;
		else
			return 0;
	}
}
