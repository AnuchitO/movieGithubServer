package cinema



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(BufferSeats)
class BufferSeatsTests {

    void testSomething() {
       //fail "Implement me"
    }
//=====test modify ok====
    void testTrue(){
    	def theater	= new Theater(theaterId:"9")
    	def seats= new BufferSeats(bSeatNumber:"K00",bTime:"09.00",bMovName:"test",theaters:theater)
    	assert seats.validate() == true
    	assert seats.bSeatNumber == "K00" //Assert Check value
		assert seats.bTime == "09.00"
		assert seats.bMovName=="test"
		seats.save()
    	
    }
    void testSave1(){
    	def theater	= new Theater(theaterId:"9")
    	def seats= new BufferSeats(bSeatNumber:"Z10",bTime:"09.00",bMovName:"test",theaters:theater)
    	assert seats.validate() == false
    }
    void testSave2(){
    	def theater	= new Theater(theaterId:"9")
    	def seats= new BufferSeats(bSeatNumber:"Z00",bTime:"",bMovName:"test",theaters:theater)
    	assert seats.validate() == false
    }
    void testSave3(){
    	def theater	= new Theater(theaterId:"9")
    	def seats= new BufferSeats(bSeatNumber:"Z12",bTime:"09.00",bMovName:"test",theaters:null)
    	assert seats.validate() == false
    }

    
    
}
