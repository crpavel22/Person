package com.pavel.test.Person.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
class PersonTest {

    @Autowired
    TestEntityManager em;

    @Before
    public void setUp() {
        List<Person> list = em.getEntityManager().createQuery("from Person").getResultList();
        list.forEach(em::remove);
    }


    @Test
    public void testCRUD(){
        Person p1 = new Person();
        p1.setName("Test person 1");
        p1.setEmail("Test@person1.com");

        p1 = em.persist(p1);

        List<Person> list = em.getEntityManager().createQuery("from Person").getResultList();

        Assert.assertEquals(1L, list.size());

        Person p2 = list.get(0);

        Assert.assertEquals("Test person 1",p2.getName());
        Assert.assertEquals("Test@person1.com",p2.getEmail());

        Assert.assertEquals(p2.hashCode(), p1.hashCode());
        Assert.assertTrue(p2.equals(p1));

    }
}