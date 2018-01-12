package com.zhuzb.web;

import com.zhuzb.mq.MQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TestController {

    public static void main(String[] args) {
/*    ApplicationContext app = new FileSystemXmlApplicationContext("classpath:xml/spring-mq.xml");
    MQProducer mQProducer = (MQProducer)app.getBean("mQProducer");
    final String queue_key = "test_queue_key";
    Map<String,Object> msg = new HashMap<String,Object>();
    msg.put("data","Hello,rabbmitmq!");
    mQProducer.sendDataToQueue(queue_key,msg);*/
/*        String path = "F:\\ModelParoductMavens\\src\\main\\java\\com\\zhuzb\\service\\impl";
        File f = new File(path);
        File fa[] = f.listFiles();
        for (int i=0;i<fa.length;i++){
            File fs = fa[i];
            if(fs.isDirectory()){
                System.out.println(fs.getName()+"[目录]");
            }else{
                System.out.println(fs.getName());
            }
        }*/
    }

    //创建temp文件夹
/*    String paths = "F:\\temp";
    File file = new File(paths);*/

/*    if(f.exisits()){

    }*/
    //复制要执行的Java文件并编译（如果要有相同的就替换）

    //获取要执行的文件

    //删除Java、class文件

}
