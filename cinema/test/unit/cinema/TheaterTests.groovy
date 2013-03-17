package cinema


import cinema.Movie
import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Theater)
class TheaterTests {

	def k = new Movie()

    void testTheaterDomain() {

       def a = new Theater(theaterId:"1",movies:k)
       assert a.theaterId == "1"
       assert a.movies == k

       assert a.validate() == true
    }
    //=====================================================================================
    // Blank Test
    //=====================================================================================
    void testNullTheaterId() {

       def a = new Theater(theaterId:"",movies:k)

       assert a.validate() == false
    }

    void testNullMovies() {

       def a = new Theater(theaterId:"1")

       assert a.validate() == false
    }
}
