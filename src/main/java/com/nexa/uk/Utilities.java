package com.nexa.uk;

public class Utilities {
	
		// Static method so you can call it as Utilities.hardWait(1)
		public static void hardWait(int seconds) {
			try {
				Thread.sleep(seconds * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}



