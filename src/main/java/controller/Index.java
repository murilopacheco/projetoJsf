package controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Index {

	   @PostConstruct
	   public void init(){
	      System.out.println("Bean executado!");
	   }
	 
	   public String getMessage(){
	      return "Hello World JSF!";
	   }

}
