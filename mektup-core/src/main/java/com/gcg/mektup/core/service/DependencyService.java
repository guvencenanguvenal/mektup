package com.gcg.mektup.core.service;

import com.gcg.mektup.core.scanner.DependencyScanner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DependencyService {

    public DependencyService(){}

    public String eventDependencies(){
        StringBuilder response = new StringBuilder();
        HashMap<Long, List<String>> dependencies = DependencyScanner.getDependencies();

        response.append("{ \"Event Dependencies\" : [");

        int i = 0;

        for(Map.Entry<Long, List<String>> entry : dependencies.entrySet()){
            i++;
            response.append("{");
            response.append("\"eventId\": " + entry.getKey() + ",");
            response.append("\"publisherInfo\": [");

            for(int j = 0; j < entry.getValue().size(); j++){
                response.append("{\"info\" : \"" + entry.getValue().get(j) + "\"}");

                if (j < entry.getValue().size() - 1){
                    response.append(",");
                }
            }

            response.append("]");
            response.append("}");

            if(i < dependencies.entrySet().size() - 1)
                response.append(",");

        }

        response.append("]}");
        return response.toString();

    }

}
