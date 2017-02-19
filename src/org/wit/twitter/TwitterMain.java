package org.wit.twitter;

import org.wit.dao.TwitterDao;

import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterMain {

	public static ConfigurationBuilder buildConfig() {

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("L4VWhqZPi0rpOy1iSiw7kUHvr")
				.setOAuthConsumerSecret("OQIFzDE9Nab20gy1oF5TmuQFvMWe1cL6hchyI1iX9IfivGNpPg")
				.setOAuthAccessToken("821697874203385856-kNaDUqtgo8XrzhA1E0RhKKyu1wuWei4")
				.setOAuthAccessTokenSecret("5H29ZWeKHfzHpjasgUfQbb1M7G2uj41bl2zq1jdqVIc92");

		cb.setJSONStoreEnabled(true);
		return cb;

	}

	public static void main(String[] args) {

		
		
		TwitterStream twitterStream = new TwitterStreamFactory(buildConfig().build()).getInstance();

		
		TwitterDao dao = new TwitterDao();
		
		CustomStatusListener customStatusListener = new CustomStatusListener(dao);
		
		
		
		twitterStream.addListener(customStatusListener);

		
		

        FilterQuery filtre = new FilterQuery();
        String[] keywordsArray = { "@RailMinIndia"};
        filtre.track(keywordsArray);
        twitterStream.filter(filtre);
		
	}

}
