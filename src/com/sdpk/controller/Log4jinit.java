package com.sdpk.controller;

import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.sdpk.controller.Log4jinit;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2018-2-7 下午1:45:04
 * 类说明
 */

public class Log4jinit extends HttpServlet {
  static Logger logger = Logger.getLogger(Log4jinit.class);

  public Log4jinit() {

  }
  
      public void init() {
//        String file = getInitParameter("log4j");
        String prefix = getServletContext().getRealPath("/");   
        String file = getInitParameter("log4jxpp"); 
        if (file != null) {
            logger.error("----开始找log4j文件sdpk");
            System.out.println("----开始找log4j文件sdpk");
//            PropertyConfigurator.configure(file);
            PropertyConfigurator.configure(prefix+file); 
            logger.error("----加载自定义的log4j.properties成功了sdpk");
            System.out.println("----加载自定义的log4j.properties成功了sdpk");
    
        }
     }//end method  init()

}//end class
