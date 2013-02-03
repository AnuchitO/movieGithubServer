package cinema

class Individual {

	String firstName
    String lastName
    String number
    String date
    String status
    String address
    String moo
    String district
    String canton
    String county
    String post
    String phone
    String email
    String degree
    String major
    String university
    String position
    String userId
    String password
    String rePassword



	static 	hasMany = [amount:Amount,deposit:Deposit,sales:Sales]
    static constraints = {
    }
}
