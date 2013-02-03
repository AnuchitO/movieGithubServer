package cinema

class Deposit {

	String	firstName
	String	lastName
	String	gender
	String	address
	String	phoneNumber
	String	email

	DataDeposit		dataDeposit
	


	static 	belongsTo  = [individual:Individual]
    static constraints = {
    }
}
