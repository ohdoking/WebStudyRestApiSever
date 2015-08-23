package com.yapp.ohdoking.dao;
import java.util.List;

import com.yapp.ohdoking.model.People;
 
public interface PeopleDAO {
 
    public void savePeople(People p);
     
    public List<People> listPeoples();
    
    public People getPeople(Long id);
    
    public void deletePeople(Long id);
     
}