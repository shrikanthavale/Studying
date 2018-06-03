/**
 * 
 */
package com.shrikane.observerpattern;

/**
 * @author shrikant havale.
 *
 */
public class MainClass {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StockNotifier stockNotifier = new StockNotifier();
		new StockListener(stockNotifier);
		stockNotifier.setDataToBechanged("Hello World");
	}
}
