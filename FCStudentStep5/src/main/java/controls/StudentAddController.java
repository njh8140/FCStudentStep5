package controls;

import java.util.Map;

import DAO.StudentDao;
import bind.DataBinding;
import vo.Student;

public class StudentAddController implements Controller, DataBinding {
	StudentDao studentDao;
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {"student", vo.Student.class};
	}

	public StudentAddController setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Student student = (Student)model.get("student");
		
		if(student.getEmail() == null) {
			
			return "/student/StudentInsert.jsp";
		} else {
			studentDao.insert(student);
			
			return "redirect:list.do";
		}
	}
}