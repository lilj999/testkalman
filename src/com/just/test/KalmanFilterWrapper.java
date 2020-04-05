package com.just.test;


import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.video.KalmanFilter;

public class KalmanFilterWrapper {
	
	KalmanFilter kalmanfilter = new KalmanFilter(1,1,0, CvType.CV_32F);
	Mat data=new Mat(1,1,CvType.CV_32F,new Scalar(0));
	
	public KalmanFilterWrapper() {
		this(1e-1,1e-5);
	}
	public KalmanFilterWrapper(double measureNoise, double processNoise) {
		Mat transitionMatrix=kalmanfilter.get_transitionMatrix();
		Core.setIdentity(transitionMatrix);
	    kalmanfilter.set_transitionMatrix(transitionMatrix);
	    
        Mat measurement = kalmanfilter.get_measurementMatrix();
        Core.setIdentity(measurement);
        kalmanfilter.set_measurementMatrix(measurement);
        
//        Mat statePre = kalmanfilter.get_statePre();
//        statePre.put(0,0,-275);
//         kalmanfilter.set_statePre(statePre);
//         Mat statePost = kalmanfilter.get_statePost();
//		 statePost.put(0,0,0);
//		kalmanfilter.set_statePost(statePost);
	     
	    Mat nc=kalmanfilter.get_processNoiseCov();
	    Core.setIdentity(nc);
	    nc=nc.mul(nc,  processNoise);
		kalmanfilter.set_processNoiseCov(nc);
		Mat mn=kalmanfilter.get_measurementNoiseCov();
		 Core.setIdentity(mn);
		mn=mn.mul(mn,  measureNoise);
		kalmanfilter.set_measurementNoiseCov(mn);
		Mat ec=kalmanfilter.get_errorCovPost();
		Core.setIdentity(ec);
		//ec=ec.mul(ec,  1e-1);
		kalmanfilter.set_errorCovPost(ec);
	}
	
	double predict() {
		Mat ov = kalmanfilter.predict();
		return ov.get(0, 0)[0];
	}
	
	void measure(double value) {
		data.put(0, 0, value);
		kalmanfilter.correct(data);
	}
	

}
