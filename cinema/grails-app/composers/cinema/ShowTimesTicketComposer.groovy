package cinema

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class ShowTimesTicketComposer extends GrailsComposer {

    def afterCompose = { window ->
    	
        // initialize components here
        //def rooms 	= Rooms.findByRoomId("Room1")
       // def rooms 	= Theatre.findByRoomId("Room1")
        def theaters	= Theater.findAll([sort:'theaterId', order:'asc'])
        def showTimes
        if (theaters) {     
        theaters.each{theater -> 
        	//def movieTheater=Rooms.findByMovie('1')
        	//def symptom	= Symptom.findByPatient(patient, [sort:'id', order:'desc'])
        //def nameMovie = "${room.movie.movName}"	
        	//$('#labNameMovie').val(rooms.movie.movName)
        	 showTimes=Show.findAllWhere(theaters:theater,[sort:'showTime', order: "asc"])

        	// def results = showTimes.listOrderByCycTime(max: 10, offset: 100, order: "desc")
	        	//alert(showTimes)        	
	        	addToListbox(theater,showTimes)
			}
		}else{
			//alert("AAA")
		}
		
		}

def addToListbox(dataTheater,dataShowTime){
	String btnName
	
 	$('#box' ).append {           		
                listitem() {
                listcell(style:"background-color:white;background-image:url(./ext/showTimeTicketPicture/Bgresult.png)"){
                	groupbox(height:"224px"){
                	hbox (height:"100px"){
                		box(height:"210px",width:"110px",style:"background-color:#777",align:"right" ){
                			hbox (){
                			vbox (){
                				label(value:"Theatre",style:"color:black ;font-size:16pt; display:block;line-height: 40px;font-weight: bolder;text-align: right;text-shadow: 0px 1px 0px rgba(255, 255, 255, 0.51);")
                				label(value:"${dataTheater.theaterId}",style:"color:black ;font-size:30pt; display:block;line-height: 40px;font-weight: bolder;text-align: right;text-shadow: 0px 1px 0px rgba(255, 255, 255, 0.51);")
                			}                            
                            separator (width:"5px")
                            }
                		}
                		separator(width:"10px")
                		image(src:"./ext/showTimeTicketPicture/movie_picture_beautiful-creatures-big-140x210.jpg",height:"210px",width:"140px");
	                	separator(width:"10px")
	                	vbox(){
	                		separator(width:"5px")
	                		label(value:"${dataTheater.movies.movName}",style:"color:gray ;font-size:20pt; display:block;line-height: 40px;font-weight: bolder;text-align: left;text-shadow: 0px 1px 0px rgba(255, 255, 255, 0.51);")
	                		separator(width:"25px")

	                		hbox() {
	                		
	                		dataShowTime.each{showTime ->
	                			btnName = dataTheater.movies.movName+showTime.showTime
	                			button(id:btnName,label:"${showTime.showTime}",style:"color:black ;font-size:12pt; display:block;line-height: 40px;font-weight: bolder;text-align:center;text-shadow: 0px 1px 0px rgba(255, 255, 255, 0.51);")
	                			separator(width:"5px")	

	                			//b++;
	                			//selectShowTimeBtn = $("button[label='${showTime.showTime}']")               			
								
								//selectShowTimeBtn.on('click',{
									//alert("AAAAA")
									//def roomFromShowTimes
									//def cycleTimedFromShowTimes
									//alert("AAAAAAA")
									//session.roomFromShowTimes = dataTheater
									//session.cycleTimedFromShowTimes = cycle.cycTime
									//session.cycleRoundFromShowTimes = cycle.cycDay
									//redirect(uri:'/seatsTicket.zul')
								//})
					
								}
	                		}               		               		
	                			
	                		
                		}
                	}

                	}
            	}
                   
             }
        }
 //Add event button Time
dataShowTime.each{showTime ->
String idtest="#"+"${dataTheater.movies.movName+showTime.showTime}"
$("#box listitem listcell button[id='${dataTheater.movies.movName+showTime.showTime}']").on('click',{
 alert("${dataTheater.movies.movName+showTime.showTime}")
 	def theaterShow
 		session.theaterShow = dataTheater
 		redirect(uri:'/seatsTicket.zul')

	})
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
