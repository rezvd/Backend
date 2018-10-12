import com.mongodb.*;
import com.mongodb.util.JSON;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import java.util.ArrayList;

public class Realty {

    MongoClient mongo = new MongoClient("localhost", 27017);
    DB db = mongo.getDB("buildingType");
    DBCollection collection = db.getCollection("buildingType");

    @Context
    private HttpHeaders requestHeaders;

    private String getHeaderVersion() {
        return requestHeaders.getRequestHeader("version").get(0);
    }

    @GET
    @Path("/{id}")
    public ArrayList<JSON> get(@PathParam("id") String id) {
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("id", id);

        DBCursor cursor = collection.find(searchQuery);
        ArrayList<JSON> result = new ArrayList<JSON>();

        while (cursor.hasNext()) {
            result.add((JSON) cursor.next());
        }
        return result;
    }

    @PUT
    public String put(JSON json) {
        Object o = com.mongodb.util.JSON.parse(json.toString());
        BasicDBObject object = (BasicDBObject) o;

        collection.insert(object);

        DBCursor cur = collection.find();
        return cur.next().get("id").toString();
    }

    @POST
    @Path("/{id}")
    public void post(@PathParam("id") String id) {

    }

    @DELETE
    public void delete(String id) {
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("id", id);
        collection.remove(searchQuery);
    }

}
