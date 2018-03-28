package com.spring;

import java.util.concurrent.atomic.AtomicLong;

public class Pizza {
    private static AtomicLong count = new AtomicLong(0); 
    private boolean isVeg;
    
    public Pizza() {
        count.incrementAndGet();
    }
    public String toString() {
        return "A new " + (isVeg ? "veggie" : "") + "Pizza, count(" + count.get() + ")";
    }
    public void setIsVeg(boolean veg) {
        isVeg = veg;
    }
}
