#
#	Author: TomeCode.com
#

uri = 't3://localhost:16001'
userName='admin'
password='admin1234'

#
# connect to the WebLogic server
#
connect(userName,password,uri)

print ''
print ''
#
# change to the custom tree
#
custom();
print ''
print ''
#
# go to custom mbean package/folder
#
cd('com.tomecode.custom.jmx')

#
# go to custom mbean package i.e. object name
#
cd('com.tomecode.custom.jmx:type=HelloWorldMBean,name=helloWorldMBean')
#
# create object name
#
auditJmx=ObjectName('com.tomecode.custom.jmx:type=HelloWorldMBean,name=helloWorldMBean')

print ''
print ''
#
# invoke operation/method form the custom mbean
#
mbs.invoke(auditJmx, 'printMessage',None,None)
print ''
print '--------------------------'

disconnect()