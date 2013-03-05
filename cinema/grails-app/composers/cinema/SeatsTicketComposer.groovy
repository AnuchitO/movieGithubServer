package cinema

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class SeatsTicketComposer extends GrailsComposer {

    def afterCompose = { window ->
        // initialize components here

       // def patient = session.room
        //$("#labRound").val(new Date())
        def rooms=session.roomFromShowTimes
        def cycleTimed=session.cycleTimedFromShowTimes
        //def cycleDay=session.cycleRoundFromShowTimes
//test CycleDay
        Date cycleDay =new Date()

        //alert(cycleTimed.[0])
        $('#labNameMovieEng').val(rooms.movie.movName)
        $('#labRoom').val(rooms.roomId)             
        $('#labRound').val(cycleDay.format("dd MMMM yyyy"))
        $('#labTime').val(cycleTimed)
        $('#labType').val(rooms.movie.movType)
        
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
                            $(B).setDisabled(true)
                        }                        
                    }
                } 
               }
                //alert("AAAA")
            }else {
                   
                //alert("BBB")
            }
// Seats Selected

def seats
        int k00=0;
        $("#K0").on("click", {
            String sn="K0";
            seats= new Seats(seatNumber:sn,tel:"",rooms:rooms)
            if(k00==0) {
                $("#K0").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k00=1;                          
                seats.save();
            } else {
               k00=0;                           
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
            seats= new Seats(seatNumber:sn,tel:"",rooms:rooms)
            if(k01==0) {
                $("#K1").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k01=1;                          
                seats.save();
            } else {
               k01=0;                           
               $("#K1").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = Seats.findBySeatNumber(sn)
               seats.delete()
            }            
        })

        int k02=0;
        $("#K2").on("click", {
            String sn="K2";
            seats= new Seats(seatNumber:sn,tel:"",rooms:rooms)
            if(k02==0) {
                $("#K2").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k02=1;                          
                seats.save();
            } else {
               k02=0;                           
               $("#K2").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = Seats.findBySeatNumber(sn)
               seats.delete()
            }            
        })
        int k03=0;
        $("#K3").on("click", {
            String sn="K3";
            seats= new Seats(seatNumber:sn,tel:"",rooms:rooms)
            if(k03==0) {
                $("#K3").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k03=1;                          
                seats.save();
            } else {
               k03=0;                           
               $("#K3").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = Seats.findBySeatNumber(sn)
               seats.delete()
            }            
        })
        int k04=0;
        $("#K4").on("click", {
            String sn="K4";
            seats= new Seats(seatNumber:sn,tel:"",rooms:rooms)
            if(k04==0) {
                $("#K4").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k04=1;                          
                seats.save();
            } else {
               k04=0;                           
               $("#K4").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = Seats.findBySeatNumber(sn)
               seats.delete()
            }            
        })
        int k05=0;
        $("#K5").on("click", {
            String sn="K5";
            seats= new Seats(seatNumber:sn,tel:"",rooms:rooms)
            if(k05==0) {
                $("#K5").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k05=1;                          
                seats.save();
            } else {
               k05=0;                           
               $("#K5").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = Seats.findBySeatNumber(sn)
               seats.delete()
            }            
        })
        int k06=0;
        $("#K6").on("click", {
            String sn="K6";
            seats= new Seats(seatNumber:sn,tel:"",rooms:rooms)
            if(k06==0) {
                $("#K6").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k06=1;                          
                seats.save();
            } else {
               k06=0;                           
               $("#K6").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = Seats.findBySeatNumber(sn)
               seats.delete()
            }            
        })
        int k07=0;
        $("#K7").on("click", {
            String sn="K7";
            seats= new Seats(seatNumber:sn,tel:"",rooms:rooms)
            if(k07==0) {
                $("#K7").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k07=1;                          
                seats.save();
            } else {
               k07=0;                           
               $("#K7").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = Seats.findBySeatNumber(sn)
               seats.delete()
            }            
        })
        int k08=0;
        $("#K8").on("click", {
            String sn="K8";
            seats= new Seats(seatNumber:sn,tel:"",rooms:rooms)
            if(k08==0) {
                $("#K8").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k08=1;                          
                seats.save();
            } else {
               k08=0;                           
               $("#K8").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = Seats.findBySeatNumber(sn)
               seats.delete()
            }            
        })
        int k09=0;
        $("#K9").on("click", {
            String sn="K9";
            seats= new Seats(seatNumber:sn,tel:"",rooms:rooms)
            if(k09==0) {
                $("#K9").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k09=1;                          
                seats.save();
            } else {
               k09=0;                           
               $("#K9").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = Seats.findBySeatNumber(sn)
               seats.delete()
            }            
        })

        
        int k010=0;
        $("#K10").on("click", {
            String sn="K10";
            seats= new Seats(seatNumber:sn,tel:"",rooms:rooms)
            if(k010==0) {
                $("#K10").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k010=1;                          
                seats.save();
            } else {
               k010=0;                           
               $("#K10").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = Seats.findBySeatNumber(sn)
               seats.delete()
            }            
        })

        int k011=0;
        $("#K11").on("click", {
            String sn="K11";
            seats= new Seats(seatNumber:sn,tel:"",rooms:rooms)
            if(k011==0) {
                $("#K11").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k011=1;                          
                seats.save();
            } else {
               k011=0;                           
               $("#K11").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = Seats.findBySeatNumber(sn)
               seats.delete()
            }            
        })
        int k012=0;
        $("#K12").on("click", {
            String sn="K12";
            seats= new Seats(seatNumber:sn,tel:"",rooms:rooms)
            if(k012==0) {
                $("#K12").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k012=1;                          
                seats.save();
            } else {
               k012=0;                           
               $("#K12").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = Seats.findBySeatNumber(sn)
               seats.delete()
            }            
        })
        int k013=0;
        $("#K13").on("click", {
            String sn="K13";
            seats= new Seats(seatNumber:sn,tel:"",rooms:rooms)
            if(k013==0) {
                $("#K13").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k013=1;                          
                seats.save();
            } else {
               k013=0;                           
               $("#K13").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = Seats.findBySeatNumber(sn)
               seats.delete()
            }            
        })
        int k014=0;
        $("#K14").on("click", {
            String sn="K14";
            seats= new Seats(seatNumber:sn,tel:"",rooms:rooms)
            if(k014==0) {
                $("#K14").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k014=1;                          
                seats.save();
            } else {
               k014=0;                           
               $("#K14").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = Seats.findBySeatNumber(sn)
               seats.delete()
            }            
        })
        int k015=0;
        $("#K15").on("click", {
            String sn="K15";
            seats= new Seats(seatNumber:sn,tel:"",rooms:rooms)
            if(k015==0) {
                $("#K15").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k015=1;                          
                seats.save();
            } else {
               k015=0;                           
               $("#K15").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = Seats.findBySeatNumber(sn)
               seats.delete()
            }            
        })
        int k016=0;
        $("#K16").on("click", {
            String sn="K16";
            seats= new Seats(seatNumber:sn,tel:"",rooms:rooms)
            if(k016==0) {
                $("#K16").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k016=1;                          
                seats.save();
            } else {
               k016=0;                           
               $("#K16").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = Seats.findBySeatNumber(sn)
               seats.delete()
            }            
        })
        int k017=0;
        $("#K17").on("click", {
            String sn="K17";
            seats= new Seats(seatNumber:sn,tel:"",rooms:rooms)
            if(k017==0) {
                $("#K17").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k017=1;                          
                seats.save();
            } else {
               k017=0;                           
               $("#K17").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = Seats.findBySeatNumber(sn)
               seats.delete()
            }            
        })
        int k018=0;
        $("#K18").on("click", {
            String sn="K18";
            seats= new Seats(seatNumber:sn,tel:"",rooms:rooms)
            if(k018==0) {
                $("#K18").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k018=1;                          
                seats.save();
            } else {
               k018=0;                           
               $("#K18").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = Seats.findBySeatNumber(sn)
               seats.delete()
            }            
        })


        $("#btnBuyTicket").on("click", {
          
            def namepp
            session.namepp = seats
            redirect(uri:'price.zul')
                
        })

        

    }
}
