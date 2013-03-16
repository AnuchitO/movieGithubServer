package cinema

class Show {

    Date	showDay = new Date() 
	String 	showTime
	
	static  belongsTo = [theaters:Theater,movies:Movie]
	
    static constraints = {
    	showTime 	nullable:true
    	showDay		nullable:true
    	theaters	nullable:true
    }
}
