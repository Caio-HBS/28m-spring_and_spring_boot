package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
        List<Todo> todos = todoService.findByUsername("CaioHBS");
        model.addAttribute("todos", todos);

        return "listTodos";
    }
    @RequestMapping(value="new-todo", method = RequestMethod.GET)
    public String showNewTodo(ModelMap model) {
        Todo todo = new Todo(0, (String)model.get("name"), "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todos";
    }
    @RequestMapping(value="new-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, Todo todo) {
        String username = (String)model.get("name");
        todoService.addNewTodo(
                username, todo.getDescription(),
                LocalDate.now().plusYears(1), false
        );

        return "redirect:list-todos";
    }
}
