package com.upc.isdcm5.xacml;

import com.sun.xacml.Indenter;
import com.sun.xacml.PDP;
import com.sun.xacml.PDPConfig;
import com.sun.xacml.ParsingException;
import com.sun.xacml.ctx.RequestCtx;
import com.sun.xacml.ctx.ResponseCtx;
import com.sun.xacml.finder.AttributeFinder;
import com.sun.xacml.finder.PolicyFinder;
import com.sun.xacml.finder.impl.CurrentEnvModule;
import com.sun.xacml.finder.impl.FilePolicyModule;
import com.sun.xacml.finder.impl.SelectorModule;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SunXACML implements BaseXACML{
    private static PDP pdp = null;
    
    public SunXACML(String policyPath) {
        FilePolicyModule filePolicyModule = new FilePolicyModule();
        filePolicyModule.addPolicy(policyPath);
        
        PolicyFinder policyFinder = new PolicyFinder();
        Set policyModules = new HashSet();
        policyModules.add(filePolicyModule);
        policyFinder.setModules(policyModules);
        
        CurrentEnvModule envAttributeModule = new CurrentEnvModule();
        SelectorModule selectorAttributeModule = new SelectorModule();

        AttributeFinder attributeFinder = new AttributeFinder();
        List attributeModules = new ArrayList();
        attributeModules.add(envAttributeModule);
        attributeModules.add(selectorAttributeModule);
        attributeFinder.setModules(attributeModules);

        pdp = new PDP(new PDPConfig(attributeFinder, policyFinder, null));
    }
    
    @Override
    public String processRequest(String requestPath) {
        try {
            RequestCtx requestObject = RequestCtx.getInstance(new FileInputStream(requestPath));
            ResponseCtx responseObject = pdp.evaluate(requestObject);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            responseObject.encode(stream, new Indenter());

            return stream.toString();
        } catch (ParsingException | FileNotFoundException e) {
            return e.getMessage();
        }
    }
    
}
