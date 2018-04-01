package com.impetus.blkch.util;

public class Tuple3<T1, T2, T3> {
    
    private T1 first;
    
    private T2 second;
    
    private T3 third;
    
    public Tuple3(T1 first, T2 second, T3 third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public T3 getThird() {
        return third;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Tuple3<?,?,?>)) {
            return false;
        }
        Tuple3<?, ?, ?> other = (Tuple3<?,?,?>)obj;
        return this.first.equals(other.first) && this.second.equals(other.second) && this.third.equals(other.third);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 31;
        hashCode = 53 * (hashCode + first.hashCode());
        hashCode = 53 * (hashCode + second.hashCode());
        hashCode = 53 * (hashCode + third.hashCode());
        return hashCode;
    }

}
