package org.wit.dao;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class TwitterDao {
	
	MongoClient mongoClient;
	DB dB;
	DBCollection collection;
	
	public TwitterDao() {
		 mongoClient = new MongoClient("localhost",27017);
	dB=mongoClient.getDB("twitterdb");
		 collection =dB.getCollection("twitterdata");
		 
		 System.out.println("Connection successful");
		 
		 
	}
	
	public void addTwitterData(String json){
		
		DBObject dbObject = (DBObject)JSON.parse(json);
		collection.insert(dbObject);
		
	}
	
	
	public void getTwitterData(){
		
		
	}

}
