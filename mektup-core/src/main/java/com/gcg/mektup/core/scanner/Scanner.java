package com.gcg.mektup.core.scanner;

import com.gcg.mektup.core.exception.ConfigurationException;
import com.gcg.mektup.scanner.exception.ScannerException;

public class Scanner {

    /**
     *
     * Scanning packages to find annotations
     *
     * @param scanPackages
     */
    public void scan(String[] scanPackages) throws ScannerException, ConfigurationException {

        new AnnotationScanner().scan(scanPackages);

    }

}
