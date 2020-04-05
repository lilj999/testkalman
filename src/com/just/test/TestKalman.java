package com.just.test;


import java.io.File;
import java.util.ArrayList;

public class TestKalman {
	public static void main(String[] args) {
		
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(-75);
			list.add(-76);
			list.add(-81);
			list.add(-55);
			list.add(-77);
			list.add(-76);
			list.add(-86);
			list.add(-99);
			list.add(-99);
			list.add(-121);
			list.add(-123);
			
			String opencvdllpath = new File("opencv_java341.dll").getAbsolutePath() ;
			System.load(opencvdllpath);
			///System.load(".\\opencv_java341.dll");
			KalmanFilterWrapper kalman=new KalmanFilterWrapper(0.1,1e-5);
			
			ArrayList<Double> filteredResults = new ArrayList<Double>();
			for(int i = 0; i < list.size(); i++){
				double result=kalman.predict();  //predict
				kalman.measure(list.get(i));     //update measuring data
				//
				filteredResults.add(result);
			}
			
			System.out.println(list);
			System.out.println(filteredResults);
		
	}

}
