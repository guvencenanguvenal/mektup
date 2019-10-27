package com.gcg.mektup.core.scanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DependencyScanner {

    private static HashMap<Long, List<String>> dependencies = new HashMap<>();

    public static void addDependency(Long eventId, String publisherMethod, String fileName, String declaringClass){
        if (dependencies.containsKey(eventId)){
                if (!dependencies.get(eventId).contains(publisherMethod + "-" + fileName + "-" + declaringClass))
                    dependencies.get(eventId).add(publisherMethod + "-" + fileName + "-" + declaringClass);
        }
        else{
            dependencies.put(eventId, new ArrayList<>());
            dependencies.get(eventId).add(publisherMethod + "-" + fileName + "-" + declaringClass);
        }

    }

    public static HashMap<Long, List<String>> getDependencies(){
        return dependencies;
    }

    private DependencyScanner(){ }

}
