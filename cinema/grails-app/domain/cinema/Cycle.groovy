package cinema

class Cycle {

	String	cycDay
	String 	cycTime
	
	static  belongsTo = [rooms:Rooms]
	

    static constraints = {
    	cycTime 	nullable:true
    	cycDay 		nullable:true
    	rooms 		nullable:true
    }
}
