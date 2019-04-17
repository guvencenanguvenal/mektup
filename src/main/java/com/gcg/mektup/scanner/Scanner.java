package com.gcg.mektup.scanner;

import com.gcg.mektup.lang.exception.ScannerException;

public class Scanner {

    /**
     *
     * Scanning packages to find annotations
     *
     * @param scanPackages
     */
    public void scan(String[] scanPackages) throws ScannerException {

        new AnnotationScanner().scan(scanPackages);

    }

}
