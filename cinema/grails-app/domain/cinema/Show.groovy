package cinema

class Show {

    Date	showDay = new Date() 
	String 	showTime
	
	static  belongsTo = [theaters:Theater]
	
    static constraints = {
    	showTime 	nullable:true
    	showDay		nullable:true
    	theaters	nullable:true
    }
}
