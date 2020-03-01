package com.example;

public class Series {

    public static int nSum(int n){
        int sum=0;
        for(int i=0; i<n; i++){
            System.out.println(sum+=i);
        }
        return sum;
    }

    public static int factorial(int n){
        if(n==0){
            return 0;
        }
        int factor=1;
        for(int i=1; i<n; i++){
            System.out.println(factor*=i);
        }
        return factor;
    }

    public static int fibonacci(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
}
