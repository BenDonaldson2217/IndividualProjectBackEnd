package BenDonaldson.controller;

import BenDonaldson.model.User;
import BenDonaldson.model.Id;
import BenDonaldson.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="user", method= RequestMethod.POST)
    public User create(@RequestBody User user){
        return userRepository.saveAndFlush(user);
    }

    @RequestMapping(value="user/{id}", method=RequestMethod.GET)
    public User get(@PathVariable Long id){
        return userRepository.findOne(id);

    }

    @RequestMapping(value="user/{userName}/{password}", method=RequestMethod.GET)
    public Id getUserId(@PathVariable("userName") String userName, @PathVariable("password") String password){
        User checkUser = userRepository.findByUserName(userName);
        if (checkUser == null){
            return new Id(-1L);
        }

        if (checkUser.getPassword().equals(password)){
            Id ans = new Id(checkUser.getId());
            return ans;

        }
        else {
            return new Id(-1L);
        }



    }

    @RequestMapping(value="users/{userName}", method=RequestMethod.GET)
    public Id checkUser(@PathVariable("userName") String userName){
        User checkUser = userRepository.findByUserName(userName);
        if (checkUser == null){
            return new Id(1L);
        }

        else {
            return new Id(-1L);
        }



    }












}
