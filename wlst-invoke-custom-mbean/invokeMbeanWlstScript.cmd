@ECHO OFF


SET OSB_HOME=D:\Oracle\Middleware11gPS6\Oracle_OSB1ps6
SET WL_HOME=D:\Oracle\Middleware11gPS6\wlserver_10.3

SET CLASSPATH=%WL_HOME%\server\lib\weblogic.jar

java weblogic.WLST -i invokeMbeanWlstScript.py %*