package com.sophossolutions.coarchitech.utils;

public class Utils {

	public static void explicityWait(int time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
