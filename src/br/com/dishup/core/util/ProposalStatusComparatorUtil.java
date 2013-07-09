package br.com.dishup.core.util;

import java.util.Comparator;
import br.com.dishup.core.entity.ProposalStatusEntity;

public class ProposalStatusComparatorUtil implements Comparator<ProposalStatusEntity>{

	@Override
	public int compare(ProposalStatusEntity o1, ProposalStatusEntity o2) {
		if(o1.getId() > o2.getId())
			return 1;
		else if(o1.getId() < o2.getId())
			return -1;
		else
			return 0;
	}
}
