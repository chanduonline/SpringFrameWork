package com.chandra.spring.dao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.multipart.MultipartFile;

import com.chandra.spring.bean.Student;

public class StudentDao {

	private JdbcTemplate jdbcTemplate;

	public StudentDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int inserRecords(String name, Integer age, MultipartFile photo) throws IOException {
		System.out.println("inserRecord called");
		byte[] photoBytes = photo.getBytes();

		String sql = "insert into student(name,age,photo) values (?,?,?)";

		return jdbcTemplate.update(sql, new Object[] { name, age, photoBytes });
	}

	public List<Student> stuList() {
System.out.println("stuList called");
		List<Student> list = jdbcTemplate.query("SELECT * FROM student", new RowMapper<Student>() {

			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student stu = new Student();

				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setAge(rs.getInt("age"));

				return stu;
			}
		});

		return list;
	}

	public Blob getPhotoById(int id) {

		String query = "select photo from student where id=?";

		Blob photo = jdbcTemplate.queryForObject(query, new Object[] { id }, Blob.class);

		return photo;
	}
}
