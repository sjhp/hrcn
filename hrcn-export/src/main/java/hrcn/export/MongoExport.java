package hrcn.export;

import hrcn.util.Constants;
import hrcn.util.MongoDBManager;

import java.util.Map;

/**
 * [com.gooday.hrcn.export]
 *
 * @ProjectName: [hrcn]
 * @Author: [Jon.K]
 * @CreateDate: [2015/2/25 15:56]
 * @Update: [说明本次修改内容] BY[Jon][2015/2/25 15:56]
 * @Version: [v1.0]
 */
public class MongoExport implements  IExport {

    @Override
    public void exportToDB(Map<String, Object> log) throws Exception{
        MongoDBManager.getInstance().insert(Constants.LOG_TABLE_NAME,log);
    }
}
