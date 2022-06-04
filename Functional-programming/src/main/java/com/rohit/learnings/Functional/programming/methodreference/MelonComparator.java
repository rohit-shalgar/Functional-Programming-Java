package com.rohit.learnings.Functional.programming.methodreference;

import com.rohit.learnings.Functional.programming.summaxmin.Melon;

import java.util.Comparator;

public class MelonComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return Integer.compare(((Melon)o2).getWeight(),((Melon)o1).getWeight());
    }


}
