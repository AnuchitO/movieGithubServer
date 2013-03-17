package cinema

class Show {

    Date	showDay = new Date() 
	String 	showTime
	
	static  belongsTo = [theaters:Theater,movies:Movie]
	
    static constraints = {
    	showTime 	blank:false
    	showDay		nullable:false
    	theaters	nullable:false
        
    }
}
