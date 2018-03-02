package com.changhr.girl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Tony on 2018/3/2.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    List<Girl> findByAge(Integer age);
}
