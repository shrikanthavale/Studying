/**
 * 
 */
package com.shrikane.observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shrikant Havale.
 *
 */
public class StockNotifier implements Subject {
	
	private final List<Observer> listOfObservers = new ArrayList<>();
	private String dataToBechanged;

	/* (non-Javadoc)
	 * @see com.shrikane.observerpattern.Subject#register(com.shrikane.observerpattern.Observer)
	 */
	@Override
	public void register(Observer observer) {
		listOfObservers.add(observer);
	}

	/* (non-Javadoc)
	 * @see com.shrikane.observerpattern.Subject#unregister(com.shrikane.observerpattern.Observer)
	 */
	@Override
	public void unregister(Observer observer) {
		listOfObservers.remove(observer);
	}

	/* (non-Javadoc)
	 * @see com.shrikane.observerpattern.Subject#notifyObservers()
	 */
	@Override
	public void notifyObservers(final UpdateDTO updateDTO) {
		listOfObservers.forEach(observer -> observer.update(updateDTO));
	}

	public String getDataToBechanged() {
		return dataToBechanged;
	}

	public void setDataToBechanged(String dataToBechanged) {
		this.dataToBechanged = dataToBechanged;
		notifyObservers(new UpdateDTO(dataToBechanged));
	}
	
}
