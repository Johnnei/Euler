package org.johnnei;

import java.util.LinkedList;

public class UniqueList<T> extends LinkedList<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean add(T e) {
		for(T i : this) {
			if (i.equals(e)) {
				return false;
			}
		}
		
		return super.add(e);
	}

}
