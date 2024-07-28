package com.day5.tool;

import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    public static Connection conn=null;
    public static PreparedStatement state=null;
    public static ResultSet rs =null;
/*
声明配置文件对象
 */

    public static Properties p=new Properties();
    /*
    用静态代码块加载配置文件
     */
    static {
        try {
            //针对Java模块
           // p.load(new FileInputStream("jdbc.properties"));
            //针对所有工程，读取编译之后的配置文件
             p.load(JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    获得连接对象
     */
    public static Connection getConnection() throws Exception {
         //1.加载数据库驱动
      //  Class.forName("com.mysql.jdbc.Driver");
        //2.创建连接对象
       // conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool90","root","root");

        Class.forName(p.getProperty("driverClass"));
        conn=DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));

        return conn;
    }

/*
执行增加、修改、删除
sql 执行的SQL语句
obs sql语句的参数，要求参数传递顺序与占位符一致
int 结果
 */
    public static int update(String sql,Object...obs){
//声明变量存结果
        int result=0;
        try {
            //1 调用方法连接对象
            conn=getConnection();
            //2 创建执行对象
            state = conn.prepareStatement(sql);
            //用预编译的执行对象调用方法给占位符传参
            if(obs!=null){
                for(int i=0;i<obs.length;i++){
                    state.setObject(i+1,obs[i]);
                }
            }
            //3 用执行对象调用相应方法将SQL传到数据库中执行
            result=state.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /*
    执行查询方法
    sql 执行的SQL语句
    obs sql语句的参数，要求参数传递顺序与占位符一致
    int 结果
     */
    public static ResultSet query(String sql,Object...obs){
        try {
            //1 调用方法连接对象
            conn=getConnection();
            //2 创建执行对象
            state = conn.prepareStatement(sql);
            //用预编译的执行对象调用方法给占位符传参
            if(obs!=null){
                for(int i=0;i<obs.length;i++){
                    state.setObject(i+1,obs[i]);
                }
            }
            //3 用执行对象调用相应方法将SQL传到数据库中执行,结果集没取数据前不可以关闭
            rs=state.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }



//关闭方法
    public static void closeObjectsAll(AutoCloseable...obs){
        for(AutoCloseable ob:obs){
            if(ob!=null){
                try {
                    ob.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
