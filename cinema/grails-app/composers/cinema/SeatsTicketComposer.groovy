package cinema

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class SeatsTicketComposer extends GrailsComposer {

    def afterCompose = { window ->
        // initialize components here

       // def patient = session.room
        //$("#labRound").val(new Date())
       	int j=0;
       	int i=65;
    //Fill  background Empty
       	for (i=65;i<=75;i++){
        	for(j=0;j<=18;j++) {
	        	String Z="#"+(char)i+j
	        	$(Z).setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;");
            }
        }

    //Fill  Seats selected  from dataBase
        def allSeats=Seats.findAll()
            if (allSeats) {
                int l=65;
                int k=0;
                allSeats.each { seats ->                
                //find Seat == seatsFromDatabase for Fill
                for (l=65;l<=75;l++){
                    for(k=0;k<=18;k++) {
                        String X=(char)l+k
                        if(${seats.seatNumber}==${X}){
                            String B="#"+seats.seatNumber
                            $(B).setStyle("background-image:url(./ext/seatsTicket/seatsSeleted.png); position: relative;");
                            
                        }                        
                    }
                } 
               }
                //alert("AAAA")
            }else {
                   
                alert("BBB")
            }
// Seats Selected

    String seatNameSelect="";
        int k00=0;
        $("#K0").on("click", {
            String sn="K0";
            def seats= new Seats(seatNumber:sn,tel:"123456")
        	if(k00==0) {
        		$("#K0").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k00=1;
                seatNameSelect=sn;             
                seats.save();
           	} else {
               k00=0; 
               seatNameSelect="";       		
        	   $("#K0").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = Seats.findBySeatNumber(sn)
               seats.delete()
        	}
            //$("#K0").setStyle("background-color: black; position: relative;");  //ok
            //def seats = Seats.findAllBySeatNumberLike("K0")
            // def seats = Seats.get(1)    	
            //$("#K0").setLabel(".");  //ok
       	})

        int k01=0;
        $("#K1").on("click", {
            String sn="K1";
            def seats= new Seats(seatNumber:sn,tel:"123456")
            if(k01==0) {
                $("#K1").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k01=1; 
                seatNameSelect=sn;             
                seats.save()
            } else {
                k01=0;
                seatNameSelect="";
                $("#K1").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = Seats.findBySeatNumber(sn)
                seats.delete()
            }       
        })


        $("#btnBuyTicket").on("click", {
            alert(seatNameSelect)
            session.namepp = seatNameSelect
            redirect(uri:'price.zul')
                
        })
        

    }
}
