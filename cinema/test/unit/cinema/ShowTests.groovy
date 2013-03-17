package cinema


import cinema.Movie
import cinema.Theater
import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Show)
class ShowTests {

	def m = new Movie()
	def t = new Theater()

    void testShowDoamin() {
       def a = new Show(showTime:"09.00",theaters:t,movies:m)
       assert a.showTime=="09.00"
       assert a.theaters==t 
       assert a.movies==m 

       assert a.validate() == true
    }
    //=====================================================================================
    // Blank Test
    //=====================================================================================
    void testNullShowTime() {
       def a = new Show(showTime:"",theaters:t,movies:m)

       assert a.validate() == false
    }

    void testNullTheaters() {
       def a = new Show(showTime:"09.00",movies:m)

       assert a.validate() == false
    }

    void testNullMovies() {
       def a = new Show(showTime:"09.00",theaters:t)

       assert a.validate() == false
    }
}
