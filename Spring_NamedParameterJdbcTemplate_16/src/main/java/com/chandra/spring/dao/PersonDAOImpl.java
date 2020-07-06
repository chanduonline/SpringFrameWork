package com.chandra.spring.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chandra.spring.bean.Person;
@Repository
@Qualifier("personDAO")
public class PersonDAOImpl implements PersonDAO {
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	public void addPerson(Person person) {
		String SQL = "INSERT INTO person(first_name,last_name,age)VALUES(:firstName,:lastName,:age)";
		Map<String,Object> map=new HashMap<String,Object>();  
		map.put("firstName",person.getFirstName());
		map.put("lastName", person.getLastName());
		map.put("age", person.getAge());
		
		jdbcTemplate.execute(SQL,map,new PreparedStatementCallback(){

			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				return ps.executeUpdate();
			}});
		System.out.println("Person Details Added Successfully....");
		
	}

	public void editPerson(Person person, int personId) {
		
		String SQL = "UPDATE person SET first_name=:firstName,last_name=:lastName,age=:age WHERE person_id=:personId";
		Map<String,Object> map=new HashMap<String,Object>();  
		map.put("firstName",person.getFirstName());
		map.put("lastName", person.getLastName());
		map.put("age", person.getAge());
		map.put("personId",person.getPersonId());
		jdbcTemplate.execute(SQL,map,new PreparedStatementCallback() {

			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				return ps.executeUpdate();
			}
		});
		System.out.println("Person Details Updated Successfully....");
		
	}

	public void deletePerson(int personId) {
		String SQL = "DELETE FROM person WHERE person_id=:personId";
		Map<String,Object> map=new HashMap<String,Object>();  
		map.put("personId", new Integer(personId));
		jdbcTemplate.execute(SQL,map,new PreparedStatementCallback() {

			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				return ps.executeUpdate();
			}
		});
		System.out.println("Person Details Deleted Successfully....");
		
	}


    public List<Person> findAll() {
    	String SQL= "select * from person";
        return this.jdbcTemplate.query(SQL, new PersonMapper());
    }

    public Person find(int personId) {
    	String SQL = "select * from person where person_id=:personId";
        return this.jdbcTemplate.queryForObject(SQL, new MapSqlParameterSource(
           "personId",personId), new PersonMapper());
    }
	 private static final class PersonMapper implements RowMapper<Person> {
	        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Person person = new Person();
	            person.setPersonId(rs.getInt("person_id"));
	            person.setFirstName(rs.getString("first_name"));
	            person.setLastName(rs.getString("last_name"));
	            person.setAge(rs.getInt("age"));
	            return person;
	        }
	    }

}
