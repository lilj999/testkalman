# testkalman
A demostration for using the Kalman filter in openCV in java.

To compile.
1) Copy opencv_java341.dll to wndows/system32 or under the project.
2) Add reference to opencv lib (I used opencv java version 3.4.1, though I believe that other versions should work too).
3) Compile and run.


Wrapped API is simple as follows:

KalmanFilterWrapper kalman=new KalmanFilterWrapper(0.1,1e-5); // measure noise and process noise. 

while(...){
  double result=kalman.predict();  //predict
  kalman.measure(list.get(i));     //update measuring data
}


Input:[-75, -76, -81, -55, -77, -76, -86, -99, -99, -121, -123]
Output after kalman filtering: [0.0, -68.18187713623047, -71.9050064086914, -74.83940887451172, -69.99873352050781, -71.37239074707031, -72.1317367553711, -74.08763122558594, -77.16876220703125, -79.5733642578125, -83.68694305419922]
