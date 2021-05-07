create index IX_61FDB1F7 on articles (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_169F912D on issues (issuedDate);
create index IX_E1431F4 on issues (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_6F28A576 on issues (uuid_[$COLUMN_LENGTH:75$], groupId);