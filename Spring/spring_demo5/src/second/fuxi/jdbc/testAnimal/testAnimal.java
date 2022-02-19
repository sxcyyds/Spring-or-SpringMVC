package second.fuxi.jdbc.testAnimal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import second.fuxi.jdbc.bean.Animal;
import second.fuxi.jdbc.service.AnimalService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testAnimal {




    @Test
    public void add(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        AnimalService animalService = context.getBean("animalService", AnimalService.class);

        Animal animal = context.getBean("animal", Animal.class);
        animal.setId(12);
        animal.setUsername("123");
        animal.setUstatus("2");
        System.out.println(animal);
        int i = animalService.addAnimal(animal);
        System.out.println(i);


    }
//    查询一条数据
    @Test
    public void queryOne(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        AnimalService animalService = context.getBean("animalService", AnimalService.class);
        Animal animal = animalService.queryOneById(1);
        System.out.println(animal);

    }
//    查询多条数据
    @Test
    public void getAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        AnimalService animalService = context.getBean("animalService", AnimalService.class);
        List<Animal> animals = animalService.queryAllAnimal();
        for (Animal a:animals) {
            System.out.println(a);

        }

    }
//    批量添加数据
    @Test
    public void addPiLiang(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        AnimalService animalService = context.getBean("animalService", AnimalService.class);
        List<Object[]> sj = new ArrayList<>();
        Object[] o1={111,"tom","1"};
        Object[] o2={222,"jack","1"};
        Object[] o3={333,"salary","1"};
        sj.add(o1);
        sj.add(o2);
        sj.add(o3);
        animalService.addpiliang(sj);

    }


}
