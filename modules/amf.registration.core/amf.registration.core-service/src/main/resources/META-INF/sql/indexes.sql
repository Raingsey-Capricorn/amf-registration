create index IX_321541FF on amfuser (groupId);
create index IX_6DC3E43F on amfuser (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D7266E81 on amfuser (uuid_[$COLUMN_LENGTH:75$], groupId);