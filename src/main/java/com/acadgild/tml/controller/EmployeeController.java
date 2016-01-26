package com.acadgild.tml.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.acadgild.tml.dao.EmployeeDao;
import com.acadgild.tml.model.Employee;

/***
 * 
 * @author TML
 *
 */
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDao dao;

	/**
	 * redirect to employee management system(ems) home page
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/")
	public ModelAndView home(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		System.out.println("------------ redirecting to home page -------------");
		List<Employee> employees = dao.getEmployees();
		request.setAttribute("employees", employees);
		return new ModelAndView("home");
	}

	
	/**
	 * redirect to a new employee registration page
	 * @param employee
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute Employee employee) {
		System.out.println("------------- redirecting to emp registration page --------------" + employee);
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("add", model);
	}
	
	/**
	 * redirect to the edit employee page
	 * @param id
	 * @param employee
	 * @return
	 */
	@RequestMapping("/edit/{id}")
	public ModelAndView editUser(@PathVariable int id,
			@ModelAttribute Employee employee) {
		System.out.println("------------- redirecting to emp edit page --------------" + employee);
		Employee employeeObject = dao.getEmployee(id);
		return new ModelAndView("edit", "employee", employeeObject);
	}

	/**
	 * saving or update employee in DB
	 * @param request
	 * @param employee
	 * @param result
	 * @param action
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployee(HttpServletRequest request,
			@ModelAttribute("command") Employee employee, BindingResult result,
			@RequestParam String action) {
		System.out.println("------------- saving or updating emp --------------");
		System.out.println(employee);
		if(action.equalsIgnoreCase("Submit")){
			dao.addOrUpdateEmployee(employee);
		}
		return "redirect:/";
	}

	
	/**
	 * Delete selected employee
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/delete/{id}")
	public String deleteEmployee(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("id") int id)
			throws IOException {
		System.out.println("------------- deleting emp --------------" + id);
		dao.deleteEmployee(id);
		return "redirect:/";
	}


}
