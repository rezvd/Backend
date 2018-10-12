import com.mongodb.*;

import javax.swing.*;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("buildingType");
        DBCollection table = db.getCollection("buildingType");

        Set<String> tables = db.getCollectionNames();

        for(String coll : tables) {
            System.out.println(coll);
        }

        // создание документа-шаблона
        BasicDBObject query = new BasicDBObject();
/*
        // условие, что поле profession должно иметь значение engineer
        query.put("profession", "engineer");
    // условие, что значение поля age должно быть < 25
        query.put("age", new BasicDBObject("$lt", 25));
*/
    // получение объекта DBCursor на основе запроса

        DBCursor cur = table.find(query);

        while(cur.hasNext())
        {
            System.out.println(cur.next());
        }

    }
}
