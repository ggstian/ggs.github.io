package unit.com.ygj.mongoclient;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.ygj.mongoclient.MdbExecutor;
import com.ygj.mongoclient.MongoDBFactory;



public class MongoClientTest {
    @Test
    public void testInsert(){
        String[] keyStrings = {"name", "sex", "age", "group"};
        Object[][] students = {
                {"SKX", "w", 22, "groupTwo"},
                {"zwh", "w", 22, "groupTwo"},
                {"ggs", "m", 17, "groupTwo"}
        };
        
      MdbExecutor exe = MongoDBFactory.newInstance("192.168.113.128:30001");
      List<DBObject> list = new ArrayList<>();
      for (int i = 0; i < students.length; i++) {
          DBObject doc = new BasicDBObject();
          for (int j = 0; j < keyStrings.length; j++) {
              doc.put(keyStrings[j], students[i][j]);
          }
          list.add(doc);
      }
     WriteResult res = exe.insert("ygj1701", "student", list);
     
      System.out.println(res.toString());
    }

}
