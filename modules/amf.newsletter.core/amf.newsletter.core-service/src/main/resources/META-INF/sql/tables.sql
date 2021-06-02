create table AMFNewsletter_amfissue_article (
	companyId LONG not null,
	amfArticleId LONG not null,
	amfIssueId LONG not null,
	primary key (amfArticleId, amfIssueId)
);

create table amf_article (
	uuid_ VARCHAR(75) null,
	amfArticleId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	issueNumber INTEGER,
	title VARCHAR(75) null,
	author VARCHAR(75) null,
	order_ INTEGER,
	content VARCHAR(75) null,
	journalId LONG
);

create table amf_issue (
	uuid_ VARCHAR(75) null,
	amfIssueId LONG not null primary key,
	groupId LONG,
	userGroupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	issueDate DATE null,
	issueNumber INTEGER,
	title VARCHAR(75) null,
	journalId LONG,
	description VARCHAR(75) null
);