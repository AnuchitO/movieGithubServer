package cinema

class Sales {

	int	buyCount
	String  salesProduct	
	int	salesAmount
	int salesprice	
	Date	date
	static 	belongsTo  = [individual:Individual]

    static constraints = {
        buyCount blank:false
        salesProduct blank:false
        salesprice  blank:false ,matches:/\d{2}/
    	individual nullable:true
    	date nullable:true
    	salesAmount nullable:true

    	
    }
}