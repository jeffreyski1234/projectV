package com.hcc.advweb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class StudentDao {    
JdbcTemplate template;    
    
public void setTemplate(JdbcTemplate template) {    
    this.template = template;    
}    
public int save(Student s){    
    String sql="insert into student(id,fname, lname, city) values('"+s.getId()+"','"+s.getFirstname()+"','"+s.getLastname()+"','"+s.getCity()+"')";    
    return template.update(sql);    
}    
public int update(Student s){    
    String sql="update student set fname='"+s.getFirstname()+"', lname='"+s.getLastname()+"',city='"+s.getCity()+"' where id='"+s.getId()+"'";    
    return template.update(sql);    
}    
public int delete(int id){    
    String sql="delete from student where id="+id+"";    
    return template.update(sql);    
}    
public Student getStudentById(int id){    
    String sql="select * from student where id=?";    
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Student>(Student.class));    
}    
public List<Student> getStudents(){    
    return template.query("select * from student",new RowMapper<Student>(){    
        public Student mapRow(ResultSet rs, int row) throws SQLException {    
            Student s=new Student();    
            s.setId(rs.getInt(1));    
            s.setFirstname(rs.getString(2));    
            s.setLastname(rs.getString(3));    
            s.setCity(rs.getString(4));    
            return s;    
        }    
    });    
}    
}   
