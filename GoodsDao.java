package com.ygj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ygj.bean.Goods;

public class GoodsDao {

    private final String DRIVER = "com.mysql.jdbc.Driver";

    private final String URL = "jdbc:mysql://localhost:3306/user";

    private final String ROOT = "root";

    private final String PASSWORD = "root";

    private Connection conn = null;

    private String sql = null;

    private PreparedStatement ps = null;

    private ResultSet rs = null;

    public void addGoods(Goods goods) {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, ROOT, PASSWORD);
            sql = "insert into commodity (item_name,item_price,item_type,item_photo) values (?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, goods.getName());
            ps.setDouble(2, goods.getPrice());
            ps.setInt(3, goods.getType());
            ps.setString(4, goods.getPhoto());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Goods> selectAll() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, ROOT, PASSWORD);
            sql = "select item_id id, item_name name , item_price price , item_type type , item_photo photo from commodity";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Goods> list = new ArrayList<Goods>();
            while (rs.next()) {
                list.add(new Goods(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs
                        .getInt("type"), rs.getString("photo")));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Goods toUpdatePage(Goods goods) {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, ROOT, PASSWORD);
            sql = "select item_id id, item_name name , item_price price , item_type type , item_photo photo from commodity where item_id ="+goods.getId();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Goods(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs
                        .getInt("type"), rs.getString("photo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void delete(Goods goods) {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, ROOT, PASSWORD);
            sql = "delete from commodity where item_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, goods.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
