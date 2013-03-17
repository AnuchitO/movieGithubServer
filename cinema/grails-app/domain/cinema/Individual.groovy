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
    
    firstName   blank:false
    lastName    blank:false
    number      matches:/\d{13}/
    date        blank:false
    status      blank:false
    address     blank:false
    moo         blank:false
    district    blank:false
    canton      blank:false
    county      blank:false
    post        matches:/\d{5}/
    phone       matches:/\d{10}/
    email       nullable:true
    degree      nullable:true
    major       nullable:true
    university  nullable:true 
    position    nullable:true
    userId      blank:false
    password    nullable:true
    rePassword  nullable:true
    amount      nullable:true
    datadeposit    nullable:true
    sales       nullable:true
    }


	
}
