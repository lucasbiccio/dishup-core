package br.com.dishup.core.util;

import java.util.Comparator;
import br.com.dishup.core.entity.StateEntity;

public class StateComparatorUtil implements Comparator<StateEntity>{

	@Override
	public int compare(StateEntity e1, StateEntity e2) {
		if(e1.getId() > e2.getId()) 
			return 1;
		else if(e1.getId() < e2.getId()) 
			return -1;
		else
			return 0;
	}
}
