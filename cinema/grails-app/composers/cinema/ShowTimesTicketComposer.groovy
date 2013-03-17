package cinema

import org.zkoss.zk.grails.composer.*
import org.zkoss.zk.ui.Executions
import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class ShowTimesTicketComposer extends GrailsComposer {

    def afterCompose = { window ->
    if (!session['user'])
	redirect(uri:'/login.zul')
	else {
	window.visible = true

    	$("#logout").on("click", {
                session.user = null
                redirect(uri:'/login.zul')

            })
        //initialize components here
        //def rooms 	= Rooms.findByRoomId("Room1")
       // def rooms 	= Theatre.findByRoomId("Room1")
       String	status = "ปกติ"
       $("#btnChangeSeat").on("click", {
       //	alert("AA")
       		String cId	=   $('#txtIdChange').val()
       		if(cId!=""){
       			def seastChang = Seats.findById(cId)
       			if(seastChang){
       			def theaterShow
 				def theaterShowTime
 				def showDayFromShowTimes
 				def seatIs

 				def movieSeat = Movie.findWhere(movName:seastChang.movName) 				
 				def theater = Theater.findWhere(movies:movieSeat)
 				def showDay = Show.findWhere(movies:movieSeat)
 			 	session.theaterShow = seastChang.theaters
		 		session.theaterShowTime = seastChang.time
		 		session.showDayFromShowTimes = showDay.showDay
		 		//alert("${showDay.showDay}")
		 		session.seatIs = seastChang.seatNumber
		 		status="เปลี่ยนที่นั่ง"
		 		session.status = status
		 		def seastRemove = Seats.get(seastChang.id)
		 			seastRemove.delete()
		 		//alert("${seastRemove}")
		 		redirect(uri:'/seatsTicket.zul')
             // alert("${seastChang.theaters}")
              //alert("Time === ${seastChang.time}")
             // alert("Name === ${seastChang.movName}")
             // alert("Number === ${seastChang.seatNumber}")
                
                $('#txtIdChange').val("")
            	}else{
	        	alert("ไม่พบข้อมูล")
	        	$('#txtIdChange').val("")
	        	}
	        }else{
	        	alert("กรุณากรอกรหัส")
	        	$('#txtIdChange').val("")
	        }
        })

       $("#btnChangeMovie").on("click", {
       		String cId	=$('#txtIdChange').getText()
       		if(cId!=""){       			
       		def seastChang = Seats.findById(cId)
       			if(seastChang){       			
       				seastChang.delete()
       				if(seastChang.validate()){
       				alert("ทำรายการสำเร็จ\nโปรดเลือกหนัง")
       				status="เปลี่ยนหนัง"
       				$('#txtIdChange').val("")
       				}else{
       				alert("ทำรายการผิดพลาด")
       				}
       			}else{
	        	alert("ไม่พบข้อมูล")
	        	$('#txtIdChange').val("")
	        	}
       		}else{
	        	alert("กรุณากรอกรหัส")
	        	$('#txtIdChange').val("")
	        }
              
              
                

        })

        def theaters	= Theater.findAll([sort:'theaterId', order:'asc'])
        def showTimes
        if (theaters) {     
        theaters.each{theater -> 
        	//def movieTheater=Rooms.findByMovie('1')
        	//def symptom	= Symptom.findByPatient(patient, [sort:'id', order:'desc'])
        //def nameMovie = "${room.movie.movName}"	
        	//$('#labNameMovie').val(rooms.movie.movName)
        	 showTimes=Show.findAllWhere(theaters:theater,[sort:'showTime', order: "asc"])
        	 if(showTimes){
        	// def results = showTimes.listOrderByCycTime(max: 10, offset: 100, order: "desc")
	        	//alert(showTimes)        	
	        	addToListbox(theater,showTimes,status)
	        }else{
	        	
	        }


			}
		}else{
			//alert("AAA")
		}
		$("#movie").on('click',{
    
     	 Executions.sendRedirect("/movieUI.zul");
     	 })
		
		$("#ticket").on('click',{
    
     	 Executions.sendRedirect("/showTimesTicket.zul");
     	 })

		$("#deposite").on('click',{
    
     	 Executions.sendRedirect("/indexDeposit.zul");
     	 })

		$("#maket").on('click',{
    
     	 Executions.sendRedirect("/indexmarket.zul");
     	 })

		

		$("#person").on('click',{
    
     	 Executions.sendRedirect("/indexShowIndividual.zul");
     	 })
		}
	}

def addToListbox(dataTheater,dataShowTime,dataStatus){
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
                		if(dataTheater.movies.movPicture140!=null){
                		image(src:"${dataTheater.movies.movPicture140}",height:"210px",width:"140px");
                		}
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
 //alert("${dataTheater.movies.movName+showTime.showTime}")
 	def theaterShow
 	def theaterShowTime
 	def showDayFromShowTimes
 	String  status 
 	def img 
 		session.img = dataTheater.movies.movPicture140
 		session.status = dataStatus
 		session.theaterShow = dataTheater
 		session.theaterShowTime = showTime.showTime
 		session.showDayFromShowTimes = showTime.showDay
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
