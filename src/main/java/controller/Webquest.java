package controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
 
@ManagedBean
@ViewScoped
public class Webquest implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> images;
     
	    @PostConstruct
	    public void init() {
	        images = new ArrayList<String>();
	        for (int i = 1; i <= 5; i++) {
	            images.add("crimes" + i + ".jpg");
	        }
	    }
	 
	    public List<String> getImages() {
	        return images;
	    }

}
