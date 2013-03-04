package cinema

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class ShowTimesTicketComposer extends GrailsComposer {

    def afterCompose = { window ->
        // initialize components here


        //ItemList

        //def patient = session.editPatient
        //def rooms = Rooms.findAll()
        def rooms 	= Rooms.findByRoomId("Room1")
        rooms.each{room -> 
        def nameMovie = "${room.movie.movName}"	
        	$('#labNameMovie').val(rooms.movie.movName)
//$('#btnT1').on("click", {
	//alert(nameMovie)
//})
//$('#btnT1').on("click", {
//	$('#btnT2').setLabel("${rooms.movie.movId}")			
//})


		}

    }
}
