package com.klezovich.springjpa.relationships.onetomany.biderectional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Post1Repository extends CrudRepository<Post1,Long> {
}
