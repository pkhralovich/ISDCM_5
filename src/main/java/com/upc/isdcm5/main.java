package com.upc.isdcm5;

import com.upc.isdcm5.xacml.SunXACML;
import com.upc.isdcm5.xacml.BaseXACML;
import com.upc.isdcm5.xacml.BalanaXACML;
import com.upc.isdcm5.xmldsig.XmlDsig;

public class main {
    private static final String ACTION_BALANA = "balana";
    private static final String ACTION_SUN = "sun";
    private static final String ACTION_XMLDSIG = "xmldsig";
    
    private static final String PARAM_TEST = "-t";
    private static final String PARAM_MOTOR = "-m";
    private static final String PARAM_POLICY = "-p";
    private static final String PARAM_REQUEST = "-r";
    
    private static String policyPath = "";
    private static String requestPath = "";
    private static Boolean testMode = false;
    private static String action = "";
    
    public static void main(String[] args) {
        /*
        Parametros:
           -p: Path de la politica
           -r: Path del request (solo aplicable en balana o sun)
           -m: Motor a usar (balana, sun o xmldsig)
           -t: Indica si se debe ejecutar en modo test
        */
                
        try {
            processArguments(args);
        
            switch (action) {
                case ACTION_BALANA: {
                    if (testMode) processTest(true);
                    else processBalana();
                    break;
                }
                case ACTION_SUN: {
                    if (testMode) processTest(false);
                    else processSun();
                    break;
                }
                case ACTION_XMLDSIG: {
                    signXML();
                    break;
                }
                default: {
                    throw new Exception("Unexpected action");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
        
    private static void processArguments(String[] args) throws Exception {
        String previousArgument = "";
        for (String argument : args) {
            if (isParam(argument)) {
                if (previousArgument.equals("")) {
                    if (argument.equals(PARAM_TEST)) testMode = true;
                    else previousArgument = argument;
                } 
                else throw new Exception("Invalid arguments");
            } else {
                switch (previousArgument) {
                    case PARAM_MOTOR: {
                        switch (argument) {
                            case ACTION_BALANA: {
                                action = ACTION_BALANA;
                                break;
                            }
                            case ACTION_SUN: {
                                action = ACTION_SUN;
                                break;
                            }
                            case ACTION_XMLDSIG: {
                                action = ACTION_XMLDSIG;
                                break;
                            }
                            default: {
                                throw new Exception("Unexpected action");
                            }
                        }
                        break;
                    }
                    case PARAM_POLICY: {
                        policyPath = argument;
                        break;
                    }
                    case PARAM_REQUEST: {
                        requestPath = argument;
                        break;
                    }
                }
                previousArgument = "";
            }
        }
    }
    
    private static Boolean isParam(String argument) {
        return argument.equals(PARAM_TEST) || argument.equals(PARAM_MOTOR) ||
                argument.equals(PARAM_POLICY) || argument.equals(PARAM_REQUEST);
    }
    
    private static void signXML() throws Exception {
        validatePaths(false);
        
        XmlDsig signer = new XmlDsig();
        System.out.println(signer.sign(policyPath)); 
    }
    
    private static void processTest(Boolean isBalana) throws Exception {
        validatePaths(true);
        
        BaseXACML processor;
        if (isBalana) processor = new BalanaXACML(policyPath);
        else processor = new SunXACML(policyPath);
        
        long start = System.nanoTime();
        for (int i = 0; i<1000; i++) processor.processRequest(requestPath);
        long end = System.nanoTime();
        
        System.out.println("Elapsed time in nanoseconds: " + (end-start) + " - " + action);
    }
    
    private static void processBalana() throws Exception {
        validatePaths(true);
        
        BalanaXACML balana = new BalanaXACML(policyPath);
        System.out.println(balana.processRequest(requestPath));
    }
    
    private static void processSun() throws Exception {
        validatePaths(true);
        
        SunXACML sun = new SunXACML(policyPath);
        System.out.println(sun.processRequest(requestPath));
    }
    
    private static void validatePaths(Boolean validateRequest) throws Exception {
        if (isEmptyPath(policyPath)) 
            throw new Exception("Policy path is compulsory");
        
        if (validateRequest && isEmptyPath(requestPath))
            throw new Exception("Request path is compulsory");
    }
    
    private static boolean isEmptyPath(String path) {
        return path == null || path.equals("");
    }
}
