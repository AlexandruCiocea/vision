package spc.vision.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import spc.vision.services.TodoItemService;

@Controller
public class HomeController {

    @Autowired
    private TodoItemService todoItemService;


//    @GetMapping("/index")
//    public ModelAndView index() {
//        ModelAndView modelAndView = new ModelAndView("index");
//        modelAndView.addObject("todoItems", todoItemService.findAllByOrderByIdDesc());
//        return modelAndView;
//    }

    @GetMapping("/index")
    public String index(Model model) {

        model.addAttribute("todoItems",todoItemService.findAllByOrderByIdDesc());
        return "index";
    }

    @GetMapping("/view")
    public String view(Model model){

        model.addAttribute("pack1",todoItemService.countPartPack1());
        model.addAttribute("pack2",todoItemService.countPartPack2());
        model.addAttribute("my26",todoItemService.countPartMY26());
        model.addAttribute("notStarted",todoItemService.countMeasureNotStarted());
        model.addAttribute("inPending",todoItemService.countMeasureInPending());
        model.addAttribute("finished",todoItemService.countMeasureFinished());
        model.addAttribute("todoItems",todoItemService.findAllByOrderByIdDesc());
        return "view";
    }

}
