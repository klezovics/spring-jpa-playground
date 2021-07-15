package com.klezovich.springjpa.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
@Slf4j
public class EntityManagerContainer {

    @Autowired
    private EntityManager em;

}
