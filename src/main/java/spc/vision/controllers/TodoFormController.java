package spc.vision.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import spc.vision.models.TodoItem;
import spc.vision.services.TodoItemService;

@Controller
public class TodoFormController {

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/create-todo")
    public String showCreateForm(TodoItem todoItem) {

        return "new-todo-item";
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model) {

        TodoItem item = new TodoItem();
        item.setTypeOfPart(todoItem.getTypeOfPart());
        item.setTypeOfMeasure(todoItem.getTypeOfMeasure());
        item.setOperationNumber(todoItem.getOperationNumber());
        item.setMachineNumber(todoItem.getMachineNumber());
        item.setUnitOfMachine(todoItem.getUnitOfMachine());
        item.setStatusOfMeasurements(todoItem.getStatusOfMeasurements());
        item.setIsComplete(todoItem.getIsComplete());

        todoItemService.save(todoItem);
        return "redirect:/index";
    }

//    @PostMapping("/todo")
//    public String createTodoItem( Model model) {
//
//        model.addAttribute();
//        item.setDescription(todoItem.getDescription());
//        item.setTypeOfMeasure(todoItem.getTypeOfMeasure());
//        item.setOperation(todoItem.getOperation());
////        item.setMachine(
////                if(todoItem.getOperation().equals(Operation.OP8100)){
////            todoItem.getMachine(Machine.M1);
////        }else todoItem.setMachine(Machine.M2);
////        );
//        item.setMachine(todoItem.getMachine());
//        item.setUnit(todoItem.getUnit());
//        item.setStatus(todoItem.getStatus());
//        item.setIsComplete(todoItem.getIsComplete());
//
//        todoItemService.save(todoItem);
//        return "redirect:/index";
//    }


    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id, Model model) {
        TodoItem todoItem = todoItemService
                .getById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        todoItemService.delete(todoItem);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        TodoItem todoItem = todoItemService
                .getById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        model.addAttribute("todo", todoItem);
        return "edit-todo-item";
    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") Long id, @Valid TodoItem todoItem, BindingResult result, Model model) {

        TodoItem item = todoItemService
                .getById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        item.setIsComplete(todoItem.getIsComplete());
        item.setTypeOfPart(todoItem.getTypeOfPart());
        item.setStatusOfMeasurements(todoItem.getStatusOfMeasurements());

        todoItemService.save(item);

        return "redirect:/index";
    }

}
