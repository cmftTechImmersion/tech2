package com.fanniemae.tech.mongo;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
 
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;
 
public class InsertDaoServiceImpl 
{
    public static void main(String[] args) throws UnknownHostException 
    {
        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("howtodoinjava");
        DBCollection collection = db.getCollection("users");
         
        ///Delete All documents before running example again
        WriteResult result = collection.remove(new BasicDBObject());
        System.out.println(result.toString());
         
        basicDBObject_Example(collection);
         
        basicDBObjectBuilder_Example(collection);
         
        hashMap_Example(collection);
         
        parseJSON_Example(collection);
         
        DBCursor cursor = collection.find();
        while(cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }
     
    private static void basicDBObject_Example(DBCollection collection){
        BasicDBObject document = new BasicDBObject();
        document.put("name", "lokesh");
        document.put("website", "howtodoinjava.com");
      
        BasicDBObject documentDetail = new BasicDBObject();
        documentDetail.put("addressLine1", "Sweet Home");
        documentDetail.put("addressLine2", "Karol Bagh");
        documentDetail.put("addressLine3", "New Delhi, India");
      
        document.put("address", documentDetail);
      
        collection.insert(document);
    } 
     
    private static void basicDBObjectBuilder_Example(DBCollection collection){
        BasicDBObjectBuilder documentBuilder = BasicDBObjectBuilder.start()
                .add("name", "lokesh")
                .add("website", "howtodoinjava.com");
          
        BasicDBObjectBuilder documentBuilderDetail = BasicDBObjectBuilder.start()
        .add("addressLine1", "Some address")
        .add("addressLine2", "Karol Bagh")
        .add("addressLine3", "New Delhi, India");
      
        documentBuilder.add("address", documentBuilderDetail.get());
      
        collection.insert(documentBuilder.get());
    }
     
    private static void hashMap_Example(DBCollection collection){
        Map<String, Object> documentMap = new HashMap<String, Object>();
        documentMap.put("name", "lokesh");
        documentMap.put("website", "howtodoinjava.com");
      
        Map<String, Object> documentMapDetail = new HashMap<String, Object>();
        documentMapDetail.put("addressLine1", "Some address");
        documentMapDetail.put("addressLine2", "Karol Bagh");
        documentMapDetail.put("addressLine3", "New Delhi, India");
      
        documentMap.put("address", documentMapDetail);
      
        collection.insert(new BasicDBObject(documentMap));
    }
     
    private static void parseJSON_Example(DBCollection collection){
        String json = "{ 'name' : 'lokesh' , " +
                        "'website' : 'howtodoinjava.com' , " +
                        "'address' : { 'addressLine1' : 'Some address' , " +
                                      "'addressLine2' : 'Karol Bagh' , " +
                                      "'addressLine3' : 'New Delhi, India'}" +
                                    "}";
              
        DBObject dbObject = (DBObject)JSON.parse(json);
      
        collection.insert(dbObject);
    }
     
}
