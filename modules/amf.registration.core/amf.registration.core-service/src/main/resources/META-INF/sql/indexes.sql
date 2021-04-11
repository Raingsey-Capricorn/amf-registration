create index IX_8837EB24 on amfeventlog (userId);
create index IX_9571F85E on amfeventlog (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_3938FE60 on amfeventlog (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_321541FF on amfuser (groupId);
create index IX_6DC3E43F on amfuser (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D7266E81 on amfuser (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5E01AEA0 on eventlog (amfUserId);
create index IX_CA8AD278 on eventlog (companyId);