package service;

import java.util.ArrayList;

public class MLR {
	int startNumber;
	int stopNumber;
	int num;
	
	public MLR() {
		
	}
	
	public MLR(int startNumber, int stopNumber, int num) {
		super();
		this.startNumber = startNumber;
		this.stopNumber = stopNumber;
		this.num = num;
	}
	
	public ArrayList<Integer> process() {
		int startNumber = this.startNumber;
		int stopNumber = this.stopNumber;
		int num = this.num;
		ArrayList<Integer> arrli = new ArrayList<Integer>();

		if(startNumber <= stopNumber) {
			for(int i = startNumber; i <= stopNumber; i++) {
				if(i%num == 0) {
					arrli.add(i);
				}
			}
		}
		else {
			for(int i = startNumber; i >= stopNumber; i--) {
				if(i%num == 0) {
					arrli.add(i);
				}
			}
		}
		return arrli;
	}
	
}
