package com.chandra.spring.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.chandra.spring.bean.Student;
import com.chandra.spring.dao.StudentDao;

@Controller
public class StudentController {
	@Autowired
	private StudentDao stuDao;

	@RequestMapping(value = "/fetch")
	public ModelAndView listStudent(ModelAndView model) throws IOException {
System.out.println("fetch called");
		List<Student> listStu = stuDao.stuList();

		model.addObject("listStu", listStu);
		model.setViewName("view.jsp");

		return model;
	}

	@RequestMapping(value = "/getStudentPhoto/{id}")
	public void getStudentPhoto(HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		System.out.println("view methods called...");
		response.setContentType("image/jpeg");

		Blob ph = stuDao.getPhotoById(id);

		byte[] bytes = ph.getBytes(1, (int) ph.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}

	@RequestMapping(value = "/InsertImage", method = RequestMethod.POST)
	public ModelAndView save(@RequestParam("name") String name, @RequestParam("age") Integer age,
			@RequestParam(required=false, name="photo") MultipartFile photo) {
       System.out.println("save method called");
		try {
			stuDao.inserRecords(name, age, photo);
			System.out.println("Insert Record Executed");

			return new ModelAndView("index.jsp", "msg", "Records succesfully inserted into database.");

		} catch (Exception e) {
			return new ModelAndView("index.jsp", "msg", "Error: " + e.getMessage());
		}
	}
}
