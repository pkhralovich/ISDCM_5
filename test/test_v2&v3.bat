java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m balana -p xacml2/policy/XACMLPolicy1.xml -r xacml2/requests/XACMLRequest1.xml

echo We were expecting Permitted

pause

java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m sun -p xacml2/policy/XACMLPolicy1.xml -r xacml2/requests/XACMLRequest2.xml

echo We were expecting Not Applicable

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m balana -p xacml3/policy/XACMLPolicy1.xml -r xacml3/requests/XACMLRequest3.xml

echo We were expecting Not Applicable

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m sun -p xacml3/policy/XACMLPolicy1.xml -r xacml3/requests/XACMLRequest4.xml

echo We were expecting Exception

pause