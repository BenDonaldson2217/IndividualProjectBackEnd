package BenDonaldson.controller;

import BenDonaldson.model.ToDo;
import BenDonaldson.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v3/")
public class ToDoController {

    @Autowired
    private ToDoRepository toDoRepository;

    @RequestMapping(value="lists", method = RequestMethod.GET)
    public List<ToDo> list(){
        return toDoRepository.findAll();
    }


    @RequestMapping(value="lists/{id}", method = RequestMethod.DELETE)
    public ToDo delete(@PathVariable Long id){
        ToDo existingToDo = toDoRepository.findOne(id);
        toDoRepository.delete(existingToDo);
        return existingToDo;
    }

    @RequestMapping(value="lists", method=RequestMethod.POST)
    public ToDo create(@RequestBody ToDo toDo){
        return toDoRepository.saveAndFlush(toDo);
    }


}