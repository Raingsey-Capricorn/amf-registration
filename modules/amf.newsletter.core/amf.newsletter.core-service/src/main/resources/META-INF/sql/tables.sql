create table amf_article (
	uuid_ VARCHAR(75) null,
	amfarticleId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	issueNumber INTEGER,
	title VARCHAR(75) null,
	author VARCHAR(75) null,
	order_ INTEGER,
	content VARCHAR(75) null
);

create table amf_issue (
	uuid_ VARCHAR(75) null,
	amfissueId LONG not null primary key,
	groupId LONG,
	userGroupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	issuedDate DATE null,
	issueNumber INTEGER,
	title VARCHAR(75) null,
	description VARCHAR(75) null
);