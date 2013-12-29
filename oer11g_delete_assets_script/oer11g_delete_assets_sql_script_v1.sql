--
-- @author:       Tomecode.com
-- @Description:  Delete all assets which have status 30 i.e. delete

delete from assetxml where assetid in (select a.ID from assets a where a.ACTIVESTATUS=30);
delete from assetrelationships where secondaryid  in (select a.ID from assets a where a.ACTIVESTATUS=30);
delete from assetrelationships where primaryid  in (select a.ID from assets a where a.ACTIVESTATUS=30);
delete from assetfiles where assetid in (select a.ID from assets a where a.ACTIVESTATUS=30);
delete from ASSETXMLINDEX where assetid in (select a.ID from assets a where a.ACTIVESTATUS=30);
delete from ASSETCATEGORIZATIONS where  assetid in (select a.ID from assets a where a.ACTIVESTATUS=30);
delete from ASSETCONTACTS where  assetid in (select a.ID from assets a where a.ACTIVESTATUS=30);
delete from ASSETKEYWORDS where  assetid in (select a.ID from assets a where a.ACTIVESTATUS=30);
delete from REGISTRARQUEUES where  assetid in (select a.ID from assets a where a.ACTIVESTATUS=30);
delete from POLICYASSERTIONRESULTS where assetid in (select a.ID from assets a where a.ACTIVESTATUS=30);
delete from POLICYASSERTIONS where policyassetid in (select a.ID from assets a where a.ACTIVESTATUS=30);
delete from PROJECTSASSETS where assetid in (select a.ID from assets a where a.ACTIVESTATUS=30);
delete from REVIEWS where assetid in (select a.ID from assets a where a.ACTIVESTATUS=30 );
delete from ASSETASSIGNEES where assetid in (select a.ID from assets a where a.ACTIVESTATUS=30);
delete from REGISTRARNOTES where assetid in (select a.ID from assets a where a.ACTIVESTATUS=30);
delete from assets where id in (select a.ID from assets a where a.ACTIVESTATUS=30);