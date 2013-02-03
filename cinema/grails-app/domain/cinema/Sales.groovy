package cinema

class Sales {

	String	firstName
	String	salesDetail
	String	salesPrice
	String	salesAmount
	Date	date



	Stock	stock

	static 	belongsTo  = [individual:Individual]

    static constraints = {
    }
}
