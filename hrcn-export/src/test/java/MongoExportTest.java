import com.mongodb.DBObject;
import hrcn.export.IExport;
import hrcn.export.MongoExport;
import hrcn.proxy.DynamicProxy;
import hrcn.util.Constants;
import hrcn.util.MongoDBManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [PACKAGE_NAME]
 *
 * @ProjectName: [hrcn]
 * @Author: [Jon.K]
 * @CreateDate: [2015/2/26 16:27]
 * @Update: [说明本次修改内容] BY[Jon][2015/2/26 16:27]
 * @Version: [v1.0]
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class MongoExportTest {
    @Test
    public void exportToDB() throws Exception {
        DynamicProxy proxy=new DynamicProxy(new MongoExport());
        IExport export=proxy.getProxy();
        Map map=new HashMap<>();
        map.put("1212","2015-02-26 16:38:42  [ main:1459 ] - [ DEBUG ]  -Dio.netty.tmpdir: v:\\AppData\\Local\\Temp (java.io.tmpdir)");
        export.exportToDB(map);
    }
    @Test
    public void test()throws Exception {
        List<DBObject> list= MongoDBManager.getInstance().findAll(Constants.LOG_TABLE_NAME);
        for(DBObject object:list){
            System.out.println(object);
        }
    }
    @Test
    public  void uploadTest() throws Exception {
        File f = new File("D:\\开发软件\\vpngate.zip");
        MongoDBManager.getInstance().uploadFiles(f);
    }
    @Test
    public  void getFilesTest()  throws Exception {
        List<DBObject> list =MongoDBManager.getInstance().getFiles();
        list.forEach(System.out::println);
        Float f = new Float("20.75f");
        // returns the float value represented by the string argument
        String str = "20150227";
        float retval = f.parseFloat(str);
        Double d = Double.valueOf(retval);
        System.err.println(d);
        System.out.println("Value = " + retval + "  Float.MAX_VALUE=" + Float.MAX_VALUE);
    }
}
