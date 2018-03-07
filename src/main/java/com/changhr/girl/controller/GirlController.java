package com.changhr.girl.controller;

import com.changhr.girl.domain.Girl;
import com.changhr.girl.repository.GirlRepository;
import com.changhr.girl.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Tony on 2018/3/2.
 */
@RestController
public class GirlController {

    private final static Logger logger= LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> GetGirlList(){

        logger.info("This is GetGirlList Method.");
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girls")
    public Girl AddGirl(@Valid Girl girl, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            logger.error("Error: "+bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
//        girl.setCupSize(girl.getCupSize());
//        girl.setAge(girl.getAge());
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
