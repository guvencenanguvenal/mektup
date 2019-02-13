package com.gcg.mektup.scanner;

public class Scanner {

    /**
     *
     * Scanning packages to find annotations
     *
     * @param scanPackages
     */
    public void scan(String[] scanPackages) {

        new AnnotationScanner().scan(scanPackages);

    }

}
