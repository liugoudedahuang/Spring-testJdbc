import com.day5.entity.Bank;
import com.day5.tool.JdbcUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JdbcUtilsTest {
/*
测试添加的方法
 */
    @Test
    public void addBank(){
        //准备sql语句
        String sql="insert into t_bank(account,password,realname,money) values(?,?,?,?)";
        //调用jdbc工具类中方法执行SQL语句并得到结果
        int result= JdbcUtils.update(sql,"3","123456","王五",1000);
        //处理结果
        System.out.println(result);
        //关闭对象
        JdbcUtils.closeObjectsAll(JdbcUtils.conn,JdbcUtils.state,JdbcUtils.rs);
    }

    @Test
    public void updateBank(){
        //准备sql语句
        String sql="update t_bank set realname=? where account=?";
        //调用jdbc工具类中方法执行SQL语句并得到结果
        int result= JdbcUtils.update(sql,"赵六","3");
        //处理结果
        System.out.println(result);
        //关闭对象
        JdbcUtils.closeObjectsAll(JdbcUtils.conn,JdbcUtils.state,JdbcUtils.rs);
    }

    @Test
    public void deleteBank(){
        //准备sql语句
        String sql="delete from t_bank  where account=?";
        //调用jdbc工具类中方法执行SQL语句并得到结果
        int result= JdbcUtils.update(sql,3);
        //处理结果
        System.out.println(result);
        //关闭对象
        JdbcUtils.closeObjectsAll(JdbcUtils.conn,JdbcUtils.state,JdbcUtils.rs);
    }

    @Test
    public void selectBank(){
        //准备sql语句  account,password,realname,money
        String sql="select * from t_bank";
        //调用jdbc工具类中方法执行SQL语句并得到结果
        JdbcUtils.rs= JdbcUtils.query(sql);
        System.out.println("账号\t密码\t名称\t余额");

       // System.out.println(JdbcUtils.p.getProperty("url"));

        //声明一个对象集合存结果
        List<Bank> bankList=new ArrayList<>();
        //处理结果
        try{
            while (JdbcUtils.rs.next()){
                //创建对象存每行数据
                Bank b=new Bank();
                /*String  account=JdbcUtils.rs.getString("account");
                String  password=JdbcUtils.rs.getString("password");
                String  realname=JdbcUtils.rs.getString("realname");
                Double  money=JdbcUtils.rs.getDouble("money");*/
                b.setAccount(JdbcUtils.rs.getString("account"));
                b.setPassword(JdbcUtils.rs.getString("password"));
                b.setRealname(JdbcUtils.rs.getString("realname"));
                b.setMoney(JdbcUtils.rs.getDouble("money"));
              //  System.out.println(account+"\t"+password+"\t"+realname+"\t"+money);
                bankList.add(b);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭对象
            JdbcUtils.closeObjectsAll(JdbcUtils.rs,JdbcUtils.state,JdbcUtils.conn);
        }
        //输出集合数据
        bankList.forEach((e)-> System.out.println(e));

    }




}
