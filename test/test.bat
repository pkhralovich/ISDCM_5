java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m balana -p XACMLPolicy1.xml -r XACMLRequest1.xml

echo We were expecting Permitted

pause

java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m balana -p XACMLPolicy1.xml -r XACMLRequest2.xml

echo We were expecting Not Applicable

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m balana -p XACMLPolicy1.xml -r XACMLRequest3.xml

echo We were expecting Not Applicable

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m balana -p XACMLPolicy1.xml -r XACMLRequest4.xml

echo We were expecting Not Applicable

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m balana -p XACMLPolicy1.xml -r XACMLRequest5.xml

echo We were expecting Not Applicable

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m balana -p XACMLPolicy2.xml -r XACMLRequest1.xml

echo We were expecting Deny

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m balana -p XACMLPolicy2.xml -r XACMLRequest2.xml

echo We were expecting Deny

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m balana -p XACMLPolicy2.xml -r XACMLRequest3.xml

echo We were expecting Deny

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m balana -p XACMLPolicy2.xml -r XACMLRequest4.xml

echo We were expecting Deny

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m balana -p XACMLPolicy2.xml -r XACMLRequest5.xml

echo We were expecting Permitted

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m balana -p XACMLPolicy3.xml -r XACMLRequest1.xml

echo We were expecting Deny

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m balana -p XACMLPolicy3.xml -r XACMLRequest2.xml

echo We were expecting Deny

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m balana -p XACMLPolicy3.xml -r XACMLRequest3.xml

echo We were expecting Permitted

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m balana -p XACMLPolicy3.xml -r XACMLRequest4.xml

echo We were expecting Deny

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m balana -p XACMLPolicy3.xml -r XACMLRequest5.xml

echo We were expecting Deny

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m sun -p XACMLPolicy1.xml -r XACMLRequest1.xml

echo We were expecting Permitted

pause

java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m sun -p XACMLPolicy1.xml -r XACMLRequest2.xml

echo We were expecting Not Applicable

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m sun -p XACMLPolicy1.xml -r XACMLRequest3.xml

echo We were expecting Not Applicable

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m sun -p XACMLPolicy1.xml -r XACMLRequest4.xml

echo We were expecting Not Applicable

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m sun -p XACMLPolicy1.xml -r XACMLRequest5.xml

echo We were expecting Not Applicable

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m sun -p XACMLPolicy2.xml -r XACMLRequest1.xml

echo We were expecting Deny

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m sun -p XACMLPolicy2.xml -r XACMLRequest2.xml

echo We were expecting Deny

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m sun -p XACMLPolicy2.xml -r XACMLRequest3.xml

echo We were expecting Deny

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m sun -p XACMLPolicy2.xml -r XACMLRequest4.xml

echo We were expecting Deny

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m sun -p XACMLPolicy2.xml -r XACMLRequest5.xml

echo We were expecting Permitted

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m sun -p XACMLPolicy3.xml -r XACMLRequest1.xml

echo We were expecting Deny

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m sun -p XACMLPolicy3.xml -r XACMLRequest2.xml

echo We were expecting Deny

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m sun -p XACMLPolicy3.xml -r XACMLRequest3.xml

echo We were expecting Permitted

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m sun -p XACMLPolicy3.xml -r XACMLRequest4.xml

echo We were expecting Deny

pause


java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m sun -p XACMLPolicy3.xml -r XACMLRequest5.xml

echo We were expecting Deny

pause

java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m xmldsig -p XACMLPolicy1.xml -r XACMLRequest1.xml

echo We are showing the signature implementation

pause

java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m balana -p XACMLPolicy1.xml -r XACMLRequest1.xml -t

java -jar ISDCM_XACML-1.0-jar-with-dependencies.jar -m sun -p XACMLPolicy1.xml -r XACMLRequest1.xml -t

echo We were expecting Sun to be faster

pause
