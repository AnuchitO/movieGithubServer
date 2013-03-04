package cinema

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class ShowTimesTicketComposer extends GrailsComposer {

    def afterCompose = { window ->
        // initialize components here


        //ItemList

        //def patient = session.editPatient
        /*def rooms = Rooms.findAll()
        rooms.each{room -> 
        def nameMovie = "${room.movie.movName}"	

			$('#btnT1').on("click", {

				aleat(nameMovie)
			})



		}*/

		def movie = Movie.findByMovName("Demo")

		$('#btnT1').on("click", {

				$('#labNameMovie').val(movie.movName)

				//$('#btnT2').setText(move.movId)

				alert(movie.movName)
			})



    }
}
