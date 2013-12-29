#////////////////////////////////////////////////////////
#
#	Author: 	 Tomecode.com
#	Description: Is Session active in WebLogic? 
#
#////////////////////////////////////////////////////////

#connect to the Weblogic
connect('<user>','<host>','<adminServer>')

#config manager
cmgr = getConfigManager()
user = cmgr.getCurrentEditor()
#active session in weblogic for user
if user != None:
	edit()
	print '-----------Active Session in WebLogic-------------'
	print 'User:   ' + str(user)
	showChanges()#print all changes in active session
	print '--------------------------------------------------------------'
	
	while true:
		action = raw_input('Do you want to activate the change? (y/n): ').strip()
		if action in ('y','YES', 'Y'):
			try:
				activate()
			except Exception:
				hideDumpStack("true")
			break;
		elif action in ('n','NO', 'N'):
			cmgr.undo()
			cmgr.cancelEdit()
			print 'Changes was chanceled'
			break;

#...
