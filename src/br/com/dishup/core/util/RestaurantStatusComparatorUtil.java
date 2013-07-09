package br.com.dishup.core.util;

import java.util.Comparator;
import br.com.dishup.core.entity.RestaurantStatusEntity;

public class RestaurantStatusComparatorUtil implements Comparator<RestaurantStatusEntity>{

	@Override
	public int compare(RestaurantStatusEntity o1, RestaurantStatusEntity o2) {
		if(o1.getId() > o2.getId())
			return 1;
		else if(o1.getId() < o2.getId())
			return -1;
		else
			return 0;
	}
}
