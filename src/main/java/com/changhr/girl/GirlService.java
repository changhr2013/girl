package com.changhr.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
