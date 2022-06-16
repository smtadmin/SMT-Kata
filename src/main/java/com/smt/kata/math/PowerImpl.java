package com.smt.kata.math;

public class PowerImpl {

	public double calcPower(double num, int pow) {
		if(num == 0) {
			return 0;
		} else if(pow < 0){
            return 1/ my_(num, -pow);
        }else{
            return my_(num, pow);
        }
    }

    private double my_(double x, int n){
        if(n == 0) return 1;
        double v = my_(x, n/2);
        if(n%2 == 0){
            return v*v;
        }else{
            return v*v*x;
        }
    }
}
