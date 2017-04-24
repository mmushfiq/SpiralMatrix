package az.mm.spiralmatrix.controllers;

import az.mm.spiralmatrix.models.Element;
import az.mm.spiralmatrix.models.Matrix;
import az.mm.spiralmatrix.process.SpiralOrder;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MM <mushfiqazeri@gmail.com>
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView goHomePage() {
        ModelAndView model = new ModelAndView("index");
        return model;
    }
    
    @RequestMapping(value = "/create_matrix.htm", method = RequestMethod.POST)
    public ModelAndView createMatrix(@Valid @ModelAttribute("matrix") Matrix matrix, BindingResult result) {
        ModelAndView model = new ModelAndView("index");
        if (result.hasErrors()) return model;
        model.addObject("matrix", matrix);
        
        return model;
    }
    
    @ResponseBody
    @RequestMapping(value = "/spiral/elements", method = RequestMethod.GET)
    public List<Element> getElementList(@RequestParam Map<String, String> params) {
        int row = Integer.parseInt(params.get("row"));
        int column = Integer.parseInt(params.get("column"));
        String clockwise = params.get("clockwise");
        
        System.out.println(row + " " + column + " " + clockwise);
        
        SpiralOrder spiralOrder = new SpiralOrder(row, column);
        List<Element> elementList;
        if("1".equals(clockwise)) 
            elementList = spiralOrder.getSpiralMatrixElementsClockwise();
        else 
            elementList = spiralOrder.getSpiralMatrixElementsCounterClockwise();
        
        return elementList;
    }
    
    @ExceptionHandler(value = Exception.class)
    public String handlerException(Exception e) {
        System.out.println("Exception occurs: " + e);
        return "exception";
    }

    @ModelAttribute
    public void addingCommonObjects(Model model) {
        model.addAttribute("matrix", new Matrix());  
    }

}
