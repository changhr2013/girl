package com.changhr.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Tony on 2018/3/2.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> GetGirlList(){
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girls")
    public Girl AddGirl(@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        Girl girl=new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    @GetMapping("/girls/{id}")
    public Girl GetGirlById(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    @PutMapping("girls/{id}")
    public Girl UpdateGirl(@PathVariable("id") Integer id,
                             @RequestParam("cupSize") String cupSize,
                             @RequestParam("age") Integer age){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);

    }

    @DeleteMapping("/girls/{id}")
    public void DeleteGirl(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    /**
     * 通过年龄查询列表
     * */
    @GetMapping("/girls/age/{age}")
    public List<Girl> GetGirlsByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @GetMapping("/girls/inserttwo")
    public List<Girl> insertTwoGirls(){
        girlService.insertTwoGirls();
        return girlRepository.findAll();
    }
}
