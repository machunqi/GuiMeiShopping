package cn.guimei.dao;

import java.sql.*;

/**
 * @Program: GuiMeiShopping
 * @ClassName: BaseDao
 * @Auther: machunqi
 * @Date: 2018-12-29 13:37
 * @Description: BaseDao
 * @Version 1.0
 */

public class BaseDao {

    private static final String URL = "jdbc:mysql://localhost:3306/guimei?useUnicode=true&characterEncoding=utf-8";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection conn = null;
    private static PreparedStatement psmt = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;


    /**
     * 加载数据库的驱动程序
     */

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 创建MySQL数据库的连接
     */
    public static Connection getConn() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 执行 查询 方法
     */
    public static ResultSet getQuery(String sql, Object paramete[]) {
        try {
            psmt = getConn().prepareStatement(sql);
            if (paramete != null && paramete.length > 0) {
                //带条件的查询 将paramete中的参数遍历到sql语句的占位符中
                for (int i = 0; i < paramete.length; i++) {
                    psmt.setObject(i + 1, paramete[i]);
                }
            }
            rs = psmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 执行增 删 改 方法
     */
    public static int getUpdate(String sql, Object paramete[]) {
        int j = 0;
        try {
            psmt = getConn().prepareStatement(sql);
            if (paramete != null && paramete.length > 0) {
                //带条件的查询 将paramete中的参数遍历到sql语句的占位符中
                for (int i = 1; i <= paramete.length; i++) {
                    psmt.setObject(i, paramete[i - 1]);
                }
            }
            j = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return j;
    }


    //关闭资源
    public static void dbClose() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (psmt != null) {
            try {
                psmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            psmt = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}