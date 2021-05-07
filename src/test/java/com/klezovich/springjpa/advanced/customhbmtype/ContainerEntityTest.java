package com.klezovich.springjpa.advanced.customhbmtype;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ContainerEntityTest {

    @Autowired
    private ContainerEntityRepisotory repisotory;

    @Test
    void testCanSaveAndReadBracketPair() {
        var bp = new BracketPair(-1,1);
        var entity = new ContainerEntity();
        entity.setPair(bp);

        var savedEntity = repisotory.save(entity);
        var readEntity = repisotory.findById(savedEntity.getId());

        var readBracketPair = readEntity.get().getPair();
        assertEquals(bp.getOpen(),readBracketPair.getOpen());
        assertEquals(bp.getClosed(), readBracketPair.getClosed());
    }
}