package com.hnzy.socket.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hnzy.socket.server.ServerHandler;


 

/**
 * 数据库的链接类
 * @author Administrator
 *
 */
public class DatabaseUtil {
		private static DatabaseUtil dbUtil;   
	    private String drivers;   
	    private String url;   
	    private String username;   
	    private String password;   
	    //加反斜线就表示在默认包目录，不加则表示在与当前类同路径去查找该属性文件   
	    private static String FILE_PATH_NAME = "/jdbc.properties";   
		// 日志文件
		private static Log logs = LogFactory.getLog(ServerHandler.class);
	    private void init() {   
	        try {   
	            InputStream in = getClass().getResourceAsStream(FILE_PATH_NAME);   
	            Properties props = new Properties();   
	           
	            props.load(in);   
	            in.close();   
	            drivers = props.getProperty("jdbc.driver");   
	            url = props.getProperty("jdbc.url");   
	            username = props.getProperty("jdbc.user");   
	            password = props.getProperty("jdbc.password");   
	        } catch (IOException e) {   
	            e.printStackTrace(); 
	            //错误日志打印信息
				logs.error(e,e.fillInStackTrace());
	        }   
	           
	    }   
	       
	    private DatabaseUtil() {   
	        init();   
	    }   
	    public static DatabaseUtil getInstance() {   
	        if(dbUtil == null) {   
	            dbUtil = new DatabaseUtil();   
	        }   
	        return dbUtil;    
	    }   
	    public Connection getConnection() {   
	           
	        Connection conn = null;   
	        try {   
	            Class.forName(drivers);   
	            conn = DriverManager.getConnection(url, username, password);   
	        } catch (SQLException e) {   
	            e.printStackTrace();
	          //错误日志打印信息
				logs.error(e,e.fillInStackTrace());
	        } catch (ClassNotFoundException e) {   
	            e.printStackTrace(); 
	          //错误日志打印信息
				logs.error(e,e.fillInStackTrace());
	        }   
	        return conn;   
	    }   
	    
  
	    public static void  close(ResultSet rs,PreparedStatement pstmt, Connection conn) throws Exception{
			if(rs!=null){
				rs.close();
				if(pstmt!=null){
					pstmt.close();
					if(conn!=null){
						conn.close();
					}					
				}
			}			
		}   
		/**
		 * 关闭连接
		 * @param pstmt
		 * @param conn
		 * @throws SQLException
		 */
		public static void close(PreparedStatement pstmt, Connection conn) throws SQLException{
			if(pstmt!=null){
				pstmt.close();
				if(conn!=null){
					conn.close();
				}
			}
		}  
	    
}
