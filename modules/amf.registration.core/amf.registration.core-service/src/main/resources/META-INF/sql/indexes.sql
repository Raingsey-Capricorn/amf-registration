create index IX_14087E71 on AMFRegistration_amfeventlog (amfEventLogId);
create index IX_B0CFE691 on AMFRegistration_amfeventlog (amfEventlogId);
create index IX_4434384A on AMFRegistration_amfeventlog (companyId);

create index IX_258C2AD4 on AMFRegistration_eventlog (amfUserId);
create index IX_92154EAC on AMFRegistration_eventlog (companyId);

create index IX_982356AC on amfeventlog (userId, amfUserId);
create index IX_9571F85E on amfeventlog (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_3938FE60 on amfeventlog (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_321541FF on amfuser (groupId);
create index IX_6DC3E43F on amfuser (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D7266E81 on amfuser (uuid_[$COLUMN_LENGTH:75$], groupId);