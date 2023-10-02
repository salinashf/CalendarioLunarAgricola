package com.gm.moon.calendar;

public class MoonphaseCalculator {
	public double[] phases;
	public int[] lunations;

	// Used to load the 'calendar' library on application startup.
	static {
		System.loadLibrary("calendar");
	}

	private native void calcNative(int year, int month, double[] phi, int[] lun);
	public static native int getSizeOfTimet();
	protected MoonphaseCalculator() {
		final int daysMax=42;
		phases=new double[daysMax];
		lunations=new int[daysMax];
	}
	public void calc(int year, int month) {
		calcNative(year, month, phases, lunations);
	}
}
