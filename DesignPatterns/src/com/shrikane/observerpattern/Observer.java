package com.shrikane.observerpattern;

public interface Observer {

	public void update(UpdateDTO updateDTO);
	
	public String getName();
	
	default boolean equals(Observer observer) {
		return this.getName().equals(observer.getName());
	}
	
}
 