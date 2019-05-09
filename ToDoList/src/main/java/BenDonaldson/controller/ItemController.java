package BenDonaldson.controller;


import BenDonaldson.model.Item;
import BenDonaldson.repository.ItemsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/")
public class ItemController {

    @Autowired
    private ItemsRepository itemsRepository;

    @RequestMapping(value="items", method = RequestMethod.GET)
    public List<Item> list(){
        return itemsRepository.findAll();
    }


    @RequestMapping(value="items/{id}", method=RequestMethod.GET)
    public Item get(@PathVariable Long id){
        return itemsRepository.findOne(id);
    }

    @RequestMapping(value="items/{id}", method = RequestMethod.DELETE)
    public Item delete(@PathVariable Long id){
        Item existingItem = itemsRepository.findOne(id);
        itemsRepository.delete(existingItem);
        return existingItem;
    }

    @RequestMapping(value="items", method=RequestMethod.POST)
    public Item create(@RequestBody Item item){
        return itemsRepository.saveAndFlush(item);
    }

    @RequestMapping(value="items/{id}", method=RequestMethod.PUT)
    public Item update(@PathVariable Long id, @RequestBody Item item){
        Item existingItem = itemsRepository.findOne(id);
        BeanUtils.copyProperties(item, existingItem);
        return itemsRepository.saveAndFlush(item);
    }



}
