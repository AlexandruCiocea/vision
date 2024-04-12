package spc.vision.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spc.vision.services.TodoItemService;

@Controller
public class HomeController {

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/view-technician")
    public String index(Model model) {

        model.addAttribute("todoItems",todoItemService.findAllByOrderByIdDesc());
        return "view-technician";
    }

    @GetMapping("/view-operators")
    public String viewOperators(Model model) {

        model.addAttribute("todoItems",todoItemService.findAllByOrderByIdDesc());
        return "view-operators";
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
