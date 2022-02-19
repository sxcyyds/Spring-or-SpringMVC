package second.fuxi.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import second.fuxi.jdbc.bean.Animal;
import second.fuxi.jdbc.dao.AnimalDao;

import java.util.List;

@Service
public class AnimalService {
    @Autowired
    private AnimalDao animalDao;



//    添加动物信息
    public int addAnimal(Animal animal){
        int add = animalDao.add(animal);
        return add;

    }
//    删除动物信息
    public int delAnimal(Integer id){
        int i = animalDao.delById(id);
        return i;
    }

//    修改动物信息
    public int updateAnimal(Animal animal){
        int update = animalDao.update(animal);
        return update;

    }
//    查询一个对象
    public Animal queryOneById(Integer id){
        Animal animal = animalDao.selectOneById(id);
        return animal;
    }
//    查询多个对象
    public List<Animal>  queryAllAnimal(){
        List<Animal> animals = animalDao.findAllAnimal();
        return animals;
    }

    //批量添加
    public void addpiliang(List<Object[]> sj){
        animalDao.addPi(sj);
    }
}
