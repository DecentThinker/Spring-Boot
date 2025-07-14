package com.example.SpringBoot_JDBC;

import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper
{
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student map  = new Student();
        map.setUsername(rs.getString(1));
        map.setEmail(rs.getString(2));
        map.setPassword(rs.getString(3));

        return map;
    }
}
