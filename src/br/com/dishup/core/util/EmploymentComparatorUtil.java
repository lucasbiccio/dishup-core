package br.com.dishup.core.util;

import java.util.Comparator;
import br.com.dishup.core.entity.EmploymentEntity;

public class EmploymentComparatorUtil implements Comparator<EmploymentEntity>{

	@Override
	public int compare(EmploymentEntity o1, EmploymentEntity o2) {
		if(o1.getId() > o2.getId())
			return 1;
		else if(o1.getId() < o2.getId())
			return -1;
		else
			return 0;
	}
}
