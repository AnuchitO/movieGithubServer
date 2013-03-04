package cinema

class Sales {

	int	buyCount
	String  salesProduct	
	int	salesAmount
	int salesprice	
	Date	date
	static 	belongsTo  = [individual:Individual]

    static constraints = {

    	individual nullable:true
    	date nullable:true
    	salesprice  nullable:true
    	buyCount nullable:true
    	salesProduct nullable:true
    	salesAmount nullable:true
    	
    }
}