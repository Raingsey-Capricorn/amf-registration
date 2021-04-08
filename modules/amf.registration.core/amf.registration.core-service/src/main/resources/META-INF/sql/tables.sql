create table AMFRegistration_eventlog (
	companyId LONG not null,
	amfEventLogId LONG not null,
	amfUserId LONG not null,
	primary key (amfEventLogId, amfUserId)
);

create table amfeventlog (
	uuid_ VARCHAR(75) null,
	amfEventLogId LONG not null primary key,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	groupId LONG,
	userId LONG,
	lastLoginDate DATE null,
	lastLoginIP VARCHAR(75) null,
	status VARCHAR(75) null
);

create table amfuser (
	uuid_ VARCHAR(75) null,
	amfUserId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	userName VARCHAR(75) null,
	userId LONG,
	contractId LONG,
	addressId LONG,
	homePhone VARCHAR(75) null,
	mobilePhone VARCHAR(75) null,
	eventLog LONG
);