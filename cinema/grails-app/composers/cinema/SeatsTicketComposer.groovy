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

       	for (i=65;i<=75;i++){
        	for(j=0;j<=18;j++) {
	        	String A="#"+(char)i+j
	        	$(A).setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;");
        	}
        }

        int k00=0;
        //def seats= new Seats(seatNumber:"AA",tel:"123456",amount:null,rooms:null)
        $("#K0").on("click", {
        	//$("#K0").setStyle("background-color: black; position: relative;");  //ok
        	if(k00==0) {
        		$("#K0").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k00=1;             
                    //seats.save()
           	} else {
                k00=0;
        		//$("#K0").setLabel(".");  //ok
        	   $("#K0").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               //def seats=Seats.findByAll(seatNumber)
               //def seats = Seats.findAllBySeatNumberLike("K0")
              // def seats = Seats.get(1)
                //seats.delete()
        	}
        	

        	
		})
       

    }
}
