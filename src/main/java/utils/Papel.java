package utils;

public enum Papel {
	 
		PAPEL_ADMIN("ROLE_ADMIN"),
	    PAPEL_COMMON("ROLE_COMMON");
	  
	    private String value;
	      
	    private Papel(String value){
	        this.value = value;
	    }
	  
	    public String getValue() {
	        return value;
	    }    
}
