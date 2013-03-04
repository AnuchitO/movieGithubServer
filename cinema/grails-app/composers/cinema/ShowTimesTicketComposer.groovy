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
        def cycles
        rooms.each{room -> 
        def nameMovie = "${room.movie.movName}"	
        	$('#labNameMovie').val(rooms.movie.movName)
        	 cycles=Cycle.findAllWhere(rooms:room)
        	//alert(cycles)
        	addToGrid(cycles,rooms)
//$('#btnT1').on("click", {
	//alert(nameMovie)
//})
//$('#btnT1').on("click", {
//	$('#btnT2').setLabel("${rooms.movie.movId}")			
//})
		}
		
		//def cycles = Cycle.findAllByRooms("1")
		//alert(cycles)
		}


 def addToGrid(dataCycle,dataRooms) {
    	//def count = 1
    	def selectCycleInfoBtn
    	//def saveSymptomBtn

		$("grid columns").detach()
		$("grid").append { columns()}
		dataCycle.each { cycle ->
			String cycleShow 
			$("grid columns").append {
				column() {
					hbox () {
						button(label:"${cycle.cycTime}",width:"50px",height:"50px")
					}
				}
			}
			cycleShow = cycle.cycTime
			selectCycleInfoBtn =  $("grid columns column:last-child button[label='${cycleShow}']")
			selectCycleInfoBtn.on("click",{
				//alert("AAAAA")
				def roomFromShowTimes
				def cycleTimedFromShowTimes
				
				session.roomFromShowTimes = dataRooms
				session.cycleTimedFromShowTimes = cycle
				redirect(uri:'/seatsTicket.zul')
			})



		//count++
		}
	
    }


}
