package com.example.sem3HomeTask.repository;


import com.example.sem3HomeTask.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserRepository {

    private final JdbcTemplate jdbs;

    public UserRepository(JdbcTemplate jdbs) {
        this.jdbs = jdbs;
    }

    public List<User> getUsers(){

        String sql = "select * from userTable";
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setName(r.getString("name"));
            rowObject.setAge(r.getInt("age"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };
        return jdbs.query(sql, userRowMapper);
    }

    public User saveUser(User user){
        String sql = "insert into userTable values (?, ?, ?)";
        jdbs.update(sql, user.getName(), user.getAge(), user.getEmail());
        return user;
    }
}
