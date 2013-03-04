package cinema

class Cycle {

	Date	cycDay = new Date() 
	String 	cycTime
	
	static  belongsTo = [rooms:Rooms]
	
    static constraints = {
    	cycTime 	nullable:true
    	cycDay 		nullable:true
    	rooms 		nullable:true
    }
}
