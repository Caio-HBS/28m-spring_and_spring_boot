package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUsername(getLoggedInUserName());
        model.addAttribute("todos", todos);

        return "listTodos";
    }

    @RequestMapping(value="new-todo", method=RequestMethod.GET)
    public String showNewTodo(ModelMap model) {
        Todo todo = new Todo(
                0, getLoggedInUserName(), "",
                LocalDate.now().plusYears(1), false
        );
        model.put("todo", todo);
        return "todos";
    }

    @RequestMapping(value="new-todo", method=RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todos";
        }

        String username = getLoggedInUserName();
        todoService.addNewTodo(
                username, todo.getDescription(),
                todo.getTargetDate(), false
        );
        return "redirect:list-todos";
    }

    @RequestMapping(value="delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value="update-todo", method=RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id, ModelMap model) {
        Todo todo = todoService.getById(id);
        model.addAttribute("todo", todo);
        return "todos";
    }

    @RequestMapping(value="update-todo", method=RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todos";
        }

        String username = (String) model.get("name");
        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }

    private String getLoggedInUserName() {
        Authentication authentication
                = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
