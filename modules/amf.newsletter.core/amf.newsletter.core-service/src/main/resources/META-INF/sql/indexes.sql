create index IX_517DD12B on amf_article (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_FBE1604E on amf_issue (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_FF41A250 on amf_issue (uuid_[$COLUMN_LENGTH:75$], groupId);