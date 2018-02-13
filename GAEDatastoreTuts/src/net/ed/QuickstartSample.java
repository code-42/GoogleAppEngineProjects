package net.ed;

//Imports the Google Cloud client library
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;

public class QuickstartSample {
public static void main(String... args) throws Exception {
	 // Instantiates a client
	 Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
	
	 // The kind for the new entity
	 String kind = "Task";
	 // The name/ID for the new entity
	 String name = "sampletask3";
	 // The Cloud Datastore key for the new entity
	 Key taskKey = datastore.newKeyFactory().setKind(kind).newKey(name);
	
	 String descr = "got mac?";
	 
	 // Prepares the new entity
	 Entity task = Entity.newBuilder(taskKey)
	     .set("description", descr)
	     .build();
	
	 // Saves the entity
	 datastore.put(task);
	
	 System.out.printf("Saved %s: %s%n", task.getKey().getName(), task.getString("description"));
	
	 //Retrieve entity
	 Entity retrieved = datastore.get(taskKey);
	
	 System.out.printf("Retrieved %s: %s%n", taskKey.getName(), retrieved.getString("description"));
	
	}
}


