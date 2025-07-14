package com.example.DigitalLibrary.repository;

import com.example.DigitalLibrary.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AuthorDao
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int createAuthor(Author author)
    {
        String query = "INSERT INTO author (AUTHOR_NAME, AUTHOR_EMAIL, AUTHOR_PHONE) VALUES (?,?,?)";
        int row = jdbcTemplate.update(query,author.getName(),author.getEmail(),author.getPhoneNo());
        return row;
    }

    public Author findAuthorById(String id)
    {
        String query = "SELECT * from author WHERE AUTHOR_EMAIL="+id;
        Author res = jdbcTemplate.queryForObject(query,new RowMapper<Author>(){
            @Override
            public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
                Author author = new Author();
                author.setName(rs.getString());
            }
        });

        return res;
    }
}
