package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.entity.Student;
import uz.pdp.repositorhy.StudentReporistiary;

@Controller //vazifasi bean qilish + htp  zaproslar bialan ishlashni  bildirip turish


public class CreateController {
    @Autowired
    StudentReporistiary studentReporistiary;
    @RequestMapping(value = "add",method = RequestMethod.POST)

    public ModelAndView sevStudent(@RequestParam("name") String name,
                                   @RequestParam("email")String email,
                                   @RequestParam("course")String course,
                                    ModelAndView mv)
    {


        Student student=Student.builder()
                .name(name)
                .email(email)
                .course(course)
                .build();
        studentReporistiary.create(student);
        int num=studentReporistiary.create(student);
        if(num==0){
            mv.addObject("ketmon","Student records updated against student id: " + student.getId());
        }else {
           mv.addObject("ketmon","student added!");
        }

        mv.setViewName("update");

        return mv;
    }


}
