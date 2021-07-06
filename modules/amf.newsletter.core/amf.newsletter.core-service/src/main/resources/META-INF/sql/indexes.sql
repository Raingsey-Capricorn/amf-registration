create index IX_6F8A94D6 on AMFNewsletter_amfissue_article (amfIssueId);
create index IX_1DCFAF00 on AMFNewsletter_amfissue_article (companyId);

create index IX_2B4F1335 on amf_article (createDate);
create index IX_517DD12B on amf_article (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_90F664FD on amf_issue (issueDate);
create index IX_FBE1604E on amf_issue (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_FF41A250 on amf_issue (uuid_[$COLUMN_LENGTH:75$], groupId);