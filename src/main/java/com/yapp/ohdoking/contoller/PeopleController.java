package com.yapp.ohdoking.contoller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yapp.ohdoking.model.People;
import com.yapp.ohdoking.service.PeopleService;

@Controller
@RequestMapping("/people")
public class PeopleController {
	
	private static final Logger logger = LoggerFactory.getLogger(PeopleController.class);

	Map<Integer, People> empData = new HashMap<Integer, People>();
       @Autowired
       private PeopleService peopleService;

       @RequestMapping(value = { "/", "/listPeoples" })
       public String listPeoples(Map<String, Object> map) {

              map.put("people", new People());

              map.put("peopleList", peopleService.listPeoples());

              return "/people/listPeoples";
       }

       @RequestMapping("/get/{peopleId}")
       public String getPeople(@PathVariable Long peopleId, Map<String, Object> map) {

              People people = peopleService.getPeople(peopleId);

              
              
              map.put("people", people);

              return "/people/peopleForm";
       }

       @RequestMapping(value = "/save", method = RequestMethod.POST)
       public String savePeople(@ModelAttribute("people") People people,
                     BindingResult result) {
    	   
    	   logger.info("Welcome people! {}.", 
    			   people.getName() + "/" +
				   people.getAge() + "/" +
				   people.getSex() + "/" +
				   people.getEtc()
    	   );
    	   	
              peopleService.savePeople(people);

              /*
               * Note that there is no slash "/" right after "redirect:"
               * So, it redirects to the path relative to the current path
               */
              return "redirect:listPeoples";
       }

       @RequestMapping("/delete/{peopleId}")
       public String deletePeople(@PathVariable("peopleId") Long id) {

              peopleService.deletePeople(id);

              /*
               * redirects to the path relative to the current path
               */
              // return "redirect:../listPeoples";

              /*
               * Note that there is the slash "/" right after "redirect:"
               * So, it redirects to the path relative to the project root path
               */
              return "redirect:/people/listPeoples";
       }
       
       @RequestMapping(value = "/saveData", method = RequestMethod.POST)
       public @ResponseBody String savePeopleData(@ModelAttribute("people") People people,
                     BindingResult result) {
    	   
    	   logger.info("Welcome people! {}.", 
    			   people.getName() + "/" +
				   people.getAge() + "/" +
				   people.getSex() + "/" +
				   people.getEtc()
    	   );
    	   	
              peopleService.savePeople(people);

              /*
               * Note that there is no slash "/" right after "redirect:"
               * So, it redirects to the path relative to the current path
               */
              
              
              return "success";
       }
       
       @RequestMapping(value = "/getAll", method = RequestMethod.GET)
       public @ResponseBody List<People> getAllPeoples() {
           logger.info("Start getAllEmployees.");
           List<People> peoples = peopleService.getPeopleAll();
           /*for(People i : peoples){
               peoples.add(empData.get(i));
           }*/
           return peoples;
       }
}