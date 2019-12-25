package com.gcg.mektup.service;

import com.gcg.mektup.core.service.DependencyService;

public class MektupDependencyService {

    private static DependencyService dependencyService = null;

    public static String eventDependenciesService(){
        if (null == dependencyService)
            dependencyService = new DependencyService();

        return dependencyService.eventDependencies();
    }

}
