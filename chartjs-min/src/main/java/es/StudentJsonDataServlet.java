package es;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.google.gson.Gson;
 
@WebServlet("/StudentJsonDataServlet")
public class StudentJsonDataServlet extends HttpServlet {
 
 private static final long serialVersionUID = 1L;
 
 public StudentJsonDataServlet() {
  super();
 }
 
 protected void doGet(HttpServletRequest request,
   HttpServletResponse response) throws ServletException, IOException {
 
  List<Student> listOfStudent = getStudentData();
 
  Gson gson = new Gson();
 
  String jsonString = gson.toJson(listOfStudent);
 
  response.setContentType("application/json");
 
  response.getWriter().write(jsonString);
 
 }
 
 private List<Student> getStudentData() {
 
  List<Student> listOfStudent = new ArrayList<Student>();
  Student s1 = new Student();
  s1.setName("Sandeep");
  s1.setComputerMark(75);
  s1.setMathematicsMark(26);
  s1.setGeographyMark(91);
  s1.setHistoryMark(55);
  s1.setLitratureMark(36);
  listOfStudent.add(s1);
 
  return listOfStudent;
 }
}