package org.wit.twitter;

import org.wit.dao.TwitterDao;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterObjectFactory;
import twitter4j.json.DataObjectFactory;

public class CustomStatusListener implements StatusListener {

	TwitterDao twitterDao;
	
	public CustomStatusListener(TwitterDao dao) {
		
		this.twitterDao = dao;
	}
	
	@Override
	public void onException(Exception arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDeletionNotice(StatusDeletionNotice arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onScrubGeo(long arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStallWarning(StallWarning arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatus(Status status) {
		
		System.out.println("Status received"+ status.toString());
//String json = DataObjectFactory.getRawJSON(status);
		
	//	System.out.println(json);
		
		twitterDao.addTwitterData(TwitterObjectFactory.getRawJSON(status));
		
		System.out.println("Successfully inserted");
		
	}

	@Override
	public void onTrackLimitationNotice(int arg0) {
		// TODO Auto-generated method stub
		
	}

}
