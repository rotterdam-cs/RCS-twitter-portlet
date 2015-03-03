create table twitter_Tweet (
	groupId LONG not null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate BOOLEAN,
	removed BOOLEAN,
	tweetId LONG not null,
	tweetIdStr VARCHAR(75) null,
	tweetCreatedAt DATE null,
	tweetRetweeted BOOLEAN,
	tweetRetweetCount INTEGER,
	tweetText VARCHAR(200) null,
	primary key (groupId, tweetId)
);

create table twitter_TwitterSettings (
	groupId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	applicationName VARCHAR(75) null,
	consumerKey VARCHAR(75) null,
	consumerKeySecret VARCHAR(75) null,
	accessToken VARCHAR(75) null,
	accessTokenSecret VARCHAR(75) null
);