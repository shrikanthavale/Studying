package com.shrikane.observerpattern;

public class StockListener implements Observer {

	public StockListener(StockNotifier stockNotifier) {
		stockNotifier.register(this);
	}

	@Override
	public void update(UpdateDTO updateDTO) {
		System.out.println("Received an update, " + updateDTO.getMessage());
		
	}

	@Override
	public String getName() {
		return StockListener.class.getName();
	}

}
