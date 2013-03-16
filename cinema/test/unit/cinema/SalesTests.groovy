package cinema



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Sales)
class SalesTests {

   
    void testsalesProductOK() {
    	def s = new Sales(buyCount:1,salesProduct:"HANAMI",salesAmount:1 ,salesprice:20,date:"1/1/2013")
    	assert s.validate() == true
	}

	void testbuyCountNotspce() {
    	def s = new Sales(buyCount:" ",salesProduct:"HANAMI",salesAmount:1 ,salesprice:20,date:"1/1/2013")
    	assert s.validate() == false 
	}

	void testsalesProductNotspce() {
    	def s = new Sales(buyCount:1,salesProduct:"",salesAmount:1 ,salesprice:20,date:"1/1/2013")
    	assert s.validate() == false 
	}

	void testsalespriceNotspce() {
    	def s = new Sales(buyCount:1,salesProduct:"HANAMI",salesAmount:"" ,salesprice:20,date:"1/1/2013")
    	
    	assert s.validate() == false 
	}

}
