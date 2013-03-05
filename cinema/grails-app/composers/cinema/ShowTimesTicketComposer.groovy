package cinema

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class ShowTimesTicketComposer extends GrailsComposer {

    def afterCompose = { window ->
        // initialize components here
        def rooms 	= Rooms.findByRoomId("Room1")	
        def cycles
        if (rooms) {     
        rooms.each{room -> 
        def nameMovie = "${room.movie.movName}"	
        	$('#labNameMovie').val(rooms.movie.movName)
        	 cycles=Cycle.findAllWhere(rooms:room,[sort:"${room.cycle.cycTime}", order: "asc"])
        	//alert(cycles)
        	addToGrid(cycles,rooms)
//$('#btnT1').on("click", {
	//alert(nameMovie)
//})
//$('#btnT1').on("click", {
//	$('#btnT2').setLabel("${rooms.movie.movId}")			
//})
			}
		}else{
			//alert("AAA")
		}
		
		//def cycles = Cycle.findAllByRooms("1")
		//alert(cycles)

		def rooms2 	= Rooms.findByRoomId("Room2")
        def cycles2
        if (rooms2) {   
         
        rooms2.each{room -> 
        def nameMovie = "${room.movie.movName}"	
        	$('#labNameMovie2').val(rooms2.movie.movName)
        	 cycles2=Cycle.findAllWhere(rooms:room)
        	//alert(cycles)

        	addToGrid2(cycles2,rooms2)
		}
		}else{
			//alert("AAA")
		}

		def rooms3	= Rooms.findByRoomId("Room3")
        def cycles3
        if (rooms3) {   
         
        rooms3.each{room -> 
        def nameMovie = "${room.movie.movName}"	
        	$('#labNameMovie3').val(rooms3.movie.movName)
        	 cycles3=Cycle.findAllWhere(rooms:room)
        	//alert(cycles)

        	addToGrid3(cycles3,rooms3)
		}
		}else{
			//alert("AAA")
		}
	}


 def addToGrid(dataCycle,dataRooms) {
    	def selectCycleInfoBtn
    	$("#gridTheat1 columns").detach()
		$("#gridTheat1").append { columns()}
		dataCycle.each { cycle ->
			String cycleShow 
			$("#gridTheat1 columns").append {
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
				session.cycleTimedFromShowTimes = cycle.cycTime
				session.cycleRoundFromShowTimes = cycle.cycDay
				
				redirect(uri:'/seatsTicket.zul')
			})
		
		}
	
    }
    def addToGrid2(dataCycle,dataRooms) {
      	def selectCycleInfoBtn
    	$("#gridTheat2 columns").detach()
		$("#gridTheat2").append { columns()}
		dataCycle.each { cycle ->
			String cycleShow 
			$("#gridTheat2 columns").append {
				//alert(cycle.cycTime)
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
				session.cycleTimedFromShowTimes = cycle.cycTime
				session.cycleRoundFromShowTimes = cycle.cycDay
				
				redirect(uri:'/seatsTicket.zul')
			})
		}
	
    }
    def addToGrid3(dataCycle,dataRooms) {
    	//def count = 1

    	def selectCycleInfoBtn
    	//def saveSymptomBtn

		$("#gridTheat3 columns").detach()
		$("#gridTheat3").append { columns()}
		dataCycle.each { cycle ->
			String cycleShow 
			$("#gridTheat3 columns").append {
				//alert(cycle.cycTime)
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
				session.cycleTimedFromShowTimes = cycle.cycTime
				session.cycleRoundFromShowTimes = cycle.cycDay
				
				redirect(uri:'/seatsTicket.zul')
			})



		//count++
		}
	
    }


}
