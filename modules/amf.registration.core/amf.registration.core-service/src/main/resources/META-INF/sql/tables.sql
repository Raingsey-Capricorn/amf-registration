create table amfuser (
	uuid_ VARCHAR(75) null,
	amfUserId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	userCreatorID LONG,
	gender VARCHAR(75) null,
	homePhone VARCHAR(75) null,
	mobilePhone VARCHAR(75) null,
	addressID LONG,
	securityQuestion STRING null,
	securityAnswer STRING null,
	acceptedTOU STRING null
);

create table amfuserdetails (
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
	mobilePhone VARCHAR(75) null
);