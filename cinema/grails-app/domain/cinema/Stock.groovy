package cinema

class Stock {

	String 	product
	String 	productTotal
	Date	date

		
	static hasOne = [sales: Sales]
	
    static constraints = {
    	product 		nullable:true
		productTotal 	nullable:true
		date 			nullable:true
		sales 			nullable:true
		
	
    }
}
