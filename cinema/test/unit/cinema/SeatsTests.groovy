package cinema



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Seats)
class SeatsTests {

    void testSomething() {
      
    }
    void testTrue(){
    	def theater	= new Theater(theaterId:"9")
    	def seats= new Seats(seatNumber:"K00",time:"09.00",movName:"test",theaters:theater)
    	assert seats.validate() == true
    	assert seats.seatNumber == "K00" //Assert Check value
		assert seats.time == "09.00"
		assert seats.movName=="test"
		seats.save()
    	
    }
    void testSave1(){
    	def theater	= new Theater(theaterId:"9")
    	def seats= new Seats(seatNumber:"Z00",time:"09.00",movName:"test",theaters:theater)
    	assert seats.validate() == false
    }
    void testSave2(){
    	def theater	= new Theater(theaterId:"9")
    	def seats= new Seats(seatNumber:"Z00",time:"",movName:"test",theaters:theater)
    	assert seats.validate() == false
    }
    void testSave3(){
    	def theater	= new Theater(theaterId:"9")
    	def seats= new Seats(seatNumber:"Z00",time:"09.00",movName:"test",theaters:null)
    	assert seats.validate() == false
    }
}
