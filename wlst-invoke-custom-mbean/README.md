wlst-invoke-custom-mbean
========================

Simple "Hello World" (JMX) MBean  and example WLST script to call operation form this JMX MBean


Building example
======================================
Execute: mvn clean install

Deploy to WebLogic
======================================
Deploy custom JMX MBean (EAR file) from: wlst-invoke-custom-mbean/jmx-mbean-ear/target/wlst-invoke-custom-mbean.ear to the WebLogic.

Execute the WLST script
======================================
On windows:
/wlst-invoke-custom-mbean\invokeMbeanWlstScript.cmd

On Linux/...:
./wlst-invoke-custom-mbean/invokeMbeanWlstScript.sh
  
