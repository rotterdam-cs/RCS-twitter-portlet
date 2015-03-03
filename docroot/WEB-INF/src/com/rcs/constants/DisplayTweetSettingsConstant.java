package com.rcs.constants;

public class DisplayTweetSettingsConstant {
	
	public static final String NUMBEROFTWEETSTOLOOP = "NumberOfTweetsToLoop";
	public static final String DELAYINTWEETSTOLOOP = "DelayInTweetsToLoop";
	public static final String OPENELEMENT = "OpenElement";
	public static final String CLOSEELEMENT = "CloseElement";
	public static final String TEMPLATEPERTWEET = "TemplatePerTweet";

	public static final String DEFAULT_NUMBEROFTWEETSTOLOOP = "3";
	public static final String DEFAULT_DELAYINTWEETSTOLOOP = "1000";
	public static final String DEFAULT_OPENELEMENT = "<div id='twitterfeed'>";
	public static final String DEFAULT_CLOSEELEMENT = "</div>";
	public static final String DEFAULT_TEMPLATEPERTWEET = "Posted on: {posted_on_year}-{posted_on_month}-{posted_on_day} At: {posted_on_time}<br />{text}";
	
}
