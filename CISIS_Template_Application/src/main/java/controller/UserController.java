package controller;

import beans.CodeValue;
import database.CodeValueDAO;
import static database.CodeValueDAO.getCodeValues;
import forms.Menu;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for the Welcome
 *
 * @author bjmaclean
 */
@Controller
@RequestMapping("userDirectory")
public class UserController {

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(HttpServletRequest request,@ModelAttribute("codeValue") @Valid CodeValue codeValue, BindingResult result) {
        //pass validation if they enter "TEST" and "TEST"
        ModelAndView mv;

            mv = new ModelAndView("userDirectory");
            CodeValueDAO.loadCodes(request);
            System.out.println("code type entered=" + codeValue.getCodeTypeId());
            ArrayList<CodeValue> test = getCodeValues(String.valueOf(codeValue.getCodeTypeId()));
            mv.addObject("menu", new Menu());
            mv.addObject("theCollection", test);
            return mv;
    }
}
