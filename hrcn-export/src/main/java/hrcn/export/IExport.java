package hrcn.export;

import java.util.Map;

/**
 * [com.gooday.hrcn.export]
 *
 * @ProjectName: [hrcn]
 * @Author: [Jon.K]
 * @CreateDate: [2015/2/25]
 * @Update: [说明本次修改内容] BY[Jon][2015/2/25]
 * @Version: [v1.0]
 */
public interface IExport {
    void exportToDB(Map<String, Object> log) throws Exception;
}
