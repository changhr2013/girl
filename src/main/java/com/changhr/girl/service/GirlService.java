package com.changhr.girl.service;

import com.changhr.girl.repository.GirlRepository;
import com.changhr.girl.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Tony on 2018/3/2.
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwoGirls(){
        Girl girlA=new Girl();
        girlA.setAge(28);
        girlA.setCupSize("A");
        girlRepository.save(girlA);

        Girl girlB=new Girl();
        girlB.setAge(29);
        girlB.setCupSize("B");
        girlRepository.save(girlB);
    }

    public void getAge(Integer id){
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age<10){
            //上小学
        }else if(age<15&&age>=10){
            //上初中
        }
    }
}
