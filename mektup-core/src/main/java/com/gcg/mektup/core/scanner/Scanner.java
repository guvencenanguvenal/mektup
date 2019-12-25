package com.gcg.mektup.core.scanner;

import com.gcg.mektup.core.exception.ScannerException;

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
