package cinema



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Amount)
class AmountTests {

    void testSomething() {
       
       def a = new Amount(price:123 ,name:"apichat eakwongsa",movieName:"spiderman",showtime:"9.00",theaTer:"room",seat:"k1,k2")

       assert a.price==123
       assert a.name=="apichat eakwongsa"
       assert a.movieName=="spiderman"
       assert a.showtime=="9.00"
       assert a.theaTer=="room"
       assert a.seat=="k1,k2"

       assert a.validate() == true
    }
    void testPriceNull() {
   		def a = new Amount(price:null ,name:"apichat eakwongsa",movieName:"spiderman",showtime:"9.00",theaTer:"room",seat:"k1,k2")

  		assert a.validate() == false
   	}
   	void testNameNull() {
   		def a = new Amount(price:1234 ,name:"",movieName:"spiderman",showtime:"9.00",theaTer:"room",seat:"k1,k2")
   		
  		assert a.validate() == false
   	}
   	void testMovieNameNull() {
   		def a = new Amount(price:1234 ,name:"apichat eakwongsa",movieName:"",showtime:"9.00",theaTer:"room",seat:"k1,k2")
   		
  		assert a.validate() == false
   	}
   	void testShowtimeNull() {
   		def a = new Amount(price:1234 ,name:"apichat eakwongsa",movieName:"spiderman",showtime:"",theaTer:"room",seat:"k1,k2")
   		
  		assert a.validate() == false
   	}
   	void testTheaTerNull() {
   		def a = new Amount(price:1234 ,name:"apichat eakwongsa",movieName:"spiderman",showtime:"9.00",theaTer:"",seat:"k1,k2")
   		
  		assert a.validate() == false
   	}
   	void testSeatNull() {
   		def a = new Amount(price:null ,name:"apichat eakwongsa",movieName:"spiderman",showtime:"9.00",theaTer:"room",seat:"")

  		assert a.validate() == false
   	}

}
