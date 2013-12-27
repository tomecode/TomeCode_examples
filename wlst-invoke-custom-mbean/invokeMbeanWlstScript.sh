#!/bin/bash


WL_HOME="/opt/app/oracle/products/Middleware11gPS6_01/wlserver_10.3"
export JAVA_HOME="/opt/app/oracle/products/jrockit-jdk1.6.0_29-R28.2.2-4.1.0"
export PATH=${JAVA_HOME}/bin:$PATH
export CLASSPATH=${WL_HOME}/server/lib/weblogic.jar:$CLASSPATH
echo $CLASSPATH

java weblogic.WLST -i osbCustomizer.py $1
