package com.tonyvx.generics.array_sorter;

public abstract class Sorter {
	public <T> T[] sort(T[] list) {

		for (int i = 0; i < list.length; i++) {
			for (int j = i+1; j < list.length; j++) {
				if (compare(list[i], list[j])) {
					T temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
        return list;
	}

	// true if a>b
	protected abstract <T> boolean compare(T a, T b);
}