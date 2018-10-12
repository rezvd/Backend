import com.mongodb.*;
import com.mongodb.util.JSON;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    public Response get(@PathParam("id") String id) {
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("id", id);

        DBCursor cursor = collection.find(searchQuery);
        ArrayList<JSON> result = new ArrayList<JSON>();

        while (cursor.hasNext()) {
            result.add((JSON) cursor.next());
        }

        if (!result.equals(null)) {
            return ResponseCreator.success(getHeaderVersion(), result);
        }
        else {
            return ResponseCreator.error(404, Error.NOT_FOUND.getCode(), getHeaderVersion());
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(JSON json) {
        //удаление предыдущего варианта
        Object o = com.mongodb.util.JSON.parse(json.toString());
        BasicDBObject searchQuery = (BasicDBObject) o;
        collection.remove(searchQuery);

        //добавление
        Object obj = com.mongodb.util.JSON.parse(json.toString());
        BasicDBObject object = (BasicDBObject) o;

        collection.insert(object);

        DBCursor cur = collection.find();
        if (cur.hasNext()) {
            return ResponseCreator.success(getHeaderVersion(), cur.next().get("id").toString());
        }
        else {
            return ResponseCreator.error(500, Error.SERVER_ERROR.getCode(), getHeaderVersion());
        }
    }

    @POST
    @Path("/{id}")
    public Response post(JSON json) {
        Object o = com.mongodb.util.JSON.parse(json.toString());
        BasicDBObject object = (BasicDBObject) o;

        collection.insert(object);

        DBCursor cur = collection.find();
        if (cur.hasNext()) {
            return ResponseCreator.success(getHeaderVersion(), cur.next().get("id").toString());
        }
        else {
            return ResponseCreator.error(500, Error.SERVER_ERROR.getCode(), getHeaderVersion());
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("id", id);
        DBCursor cur = collection.find();
        if (cur.hasNext()) {
            collection.remove(searchQuery);
            return ResponseCreator.success(getHeaderVersion(), "removed");
        }
        else {
            return ResponseCreator.error(404, Error.NOT_FOUND.getCode(), getHeaderVersion());
        }
    }

}
