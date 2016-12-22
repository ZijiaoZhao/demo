package com.inspiry.rw;

import org.aspectj.lang.JoinPoint;

/**
 * Created by zijiao on 12/21/16.
 */
public class DataSourceAspect {
    public static final ThreadLocal<String> holder = new ThreadLocal<>();

    public static String currentDataSource(){
        return holder.get();
    }

    void selectDataSource(JoinPoint point) {
        String methodName = point.getSignature().getName();
        String source;

        if(methodName.startsWith("select") || methodName.startsWith("count")) {
            source = "slave";
        } else {
            source = "master";
        }

        System.out.println(methodName + ": use " + source + " dataSource");
        holder.set(source);
    }
}
