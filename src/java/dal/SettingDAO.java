/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Setting;

/**
 *
 * @author QuyenNV
 */
public class SettingDAO {
    
    public Setting getWebSetting() throws Exception{
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Setting setting = new Setting();
        try {
            String sql = "SELECT * FROM setting";
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                setting.setSrc(rs.getString("src"));
                setting.setDesc(rs.getString("desc"));
                setting.setTitle(rs.getString("title"));
                setting.setSubTitle(rs.getString("sub_title"));
                setting.setTitleImage(rs.getString("title_image"));
                setting.setTitleText(rs.getString("title_text"));
            }
        }catch(Exception ex){
            throw ex;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return setting;
    }
}
