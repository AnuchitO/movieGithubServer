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
    static  hasMany = [amount:Amount,datadeposit:DataDeposit,sales:Sales]
        
static constraints = {
    
    firstName   nullable:true
    lastName    nullable:true
    number      nullable:true
    date        nullable:true
    status      nullable:true
    address     nullable:true
    moo         nullable:true
    district    nullable:true
    canton      nullable:true
    county      nullable:true
    post        nullable:true
    phone       nullable:true
    email       nullable:true
    degree      nullable:true
    major       nullable:true
    university  nullable:true 
    position    nullable:true
    userId      nullable:true
    password    nullable:true
    rePassword  nullable:true
    amount      nullable:true
    datadeposit    nullable:true
    sales       nullable:true
    }


	
}
