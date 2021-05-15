package com.upc.isdcm5.xacml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import org.wso2.balana.Balana;
import org.wso2.balana.PDP;
import org.wso2.balana.PDPConfig;
import org.wso2.balana.ParsingException;
import org.wso2.balana.ctx.RequestCtxFactory;
import org.wso2.balana.ctx.ResponseCtx;
import org.wso2.balana.finder.AttributeFinder;
import org.wso2.balana.finder.AttributeFinderModule;
import org.wso2.balana.finder.impl.FileBasedPolicyFinderModule;

public class BalanaXACML implements BaseXACML {
    private Balana balana = null;
    private PDP pdp = null;
    
    public BalanaXACML(String policyPath) {
        System.setProperty(FileBasedPolicyFinderModule.POLICY_DIR_PROPERTY, policyPath);
        balana = Balana.getInstance();
        pdp = getPDPInstance();
    }
    
    private PDP getPDPInstance() {
        PDPConfig pdpConfig = balana.getPdpConfig();

        AttributeFinder attributeFinder = pdpConfig.getAttributeFinder();
        List<AttributeFinderModule> finderModules = attributeFinder.getModules();
        attributeFinder.setModules(finderModules);

        return new PDP(new PDPConfig(attributeFinder, pdpConfig.getPolicyFinder(), null, true));
    }
    
    @Override
    public String processRequest(String requestPath) {
        try {
            ResponseCtx responseObject = pdp.evaluate(RequestCtxFactory.getFactory().getRequestCtx(new FileInputStream(requestPath)));
            return responseObject.encode();
        } catch (FileNotFoundException | ParsingException e) {
            return e.getMessage();
        }
    }
}
