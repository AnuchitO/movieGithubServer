package cinema

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class SeatsTicketComposer extends GrailsComposer {

    def afterCompose = { window ->



      $("#logout").on("click", {
                session.user = null
                redirect(uri:'/login.zul')

      })

      
     $("#btnBack").on("click", {
      def buffer=BufferSeats.findAll()
        if(buffer){
        buffer.each{buff ->
            def buf = BufferSeats.get(buff.id)
                buf.delete()
        }           
        redirect(uri:'/showTimesTicket.zul')
        }else{
        redirect(uri:'/showTimesTicket.zul')
        }

      })
        // initialize components here      
   /*     //$("#labRound").val(new Date())
        def rooms=session.roomFromShowTimes
        def cycleTimed=session.cycleTimedFromShowTimes
      
//test CycleDay*/

        def showDay=session.showDayFromShowTimes
        Date cycleDay =new Date()
        def theater = session.theaterShow
        def showTime = session.theaterShowTime
        
// alert("${showTime}")
        $('#labNameMovieEng').val("${theater.movies.movName}")
        $('#labTheater').val("${theater.theaterId}")             
        $('#labShow').val(showDay.format("dd MMMM yyyy"))
//  $('#labRound').val(cycleDay.format("dd MMMM yyyy"))
//alert("${showDay}")
      // label( value: f.date.format("dd MMMM yyyy"))
        $('#labTime').val("${showTime}")

        $('#labType').val("${theater.movies.movType}")
        $('#labPromotion').val("${theater.movies.promotion}")

      $('#labType').val("${theater.movies.movType}")
        def image = Movie.findWhere(movName:"${theater.movies.movName}")
      //  alert("${image.movPicture140}")
      if(image.movPicture140!=null){
      $('#imgMovieSeats')[0].src="${image.movPicture140}"
      }      
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
        def allSeats=Seats.findAllWhere(theaters:theater,time:"${showTime}")

            if (allSeats) {
                int l=65;
                int k=0;
                allSeats.each { seats ->                
                //find Seat == seatsFromDatabase for Fill
                for (l=65;l<=75;l++){
                    for(k=0;k<=18;k++) {
                        String X=(char)l+k 
                        String  seatsEmpty="#"+(char)l+k                     
                        if((${seats.seatNumber}==${X})){
                            String B="#"+seats.seatNumber
                            $(B).setStyle("background-image:url(./ext/seatsTicket/seatsSeleted.png); position: relative;");
                            $(B).setDisabled(true)
                        }

                    }
                } 
               }
                //alert("AAAA")
            }else {
                   
               //OK redirect(uri:'/showTimesTicket.zul')
                // alert("AAAA")
            }


// Seats Selected
def  seats

        int k00=0;
        $("#K0").on("click", {
            String sn="K0";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(k00==0) {
                $("#K0").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k00=1;                          
                seats.save();
            } else {
               k00=0;                           
               $("#K0").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
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
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(k01==0) {
                $("#K1").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k01=1;                          
                seats.save();
            } else {
               k01=0;                           
               $("#K1").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        int k02=0;
        $("#K2").on("click", {
            String sn="K2";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(k02==0) {
                $("#K2").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k02=1;                          
                seats.save();
            } else {
               k02=0;                           
               $("#K2").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int k03=0;
        $("#K3").on("click", {
            String sn="K3";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(k03==0) {
                $("#K3").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k03=1;                          
                seats.save();
            } else {
               k03=0;                           
               $("#K3").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int k04=0;
        $("#K4").on("click", {
            String sn="K4";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(k04==0) {
                $("#K4").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k04=1;                          
                seats.save();
            } else {
               k04=0;                           
               $("#K4").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int k05=0;
        $("#K5").on("click", {
            String sn="K5";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(k05==0) {
                $("#K5").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k05=1;                          
                seats.save();
            } else {
               k05=0;                           
               $("#K5").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int k06=0;
        $("#K6").on("click", {
            String sn="K6";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(k06==0) {
                $("#K6").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k06=1;                          
                seats.save();
            } else {
               k06=0;                           
               $("#K6").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int k07=0;
        $("#K7").on("click", {
            String sn="K7";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(k07==0) {
                $("#K7").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k07=1;                          
                seats.save();
            } else {
               k07=0;                           
               $("#K7").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int k08=0;
        $("#K8").on("click", {
            String sn="K8";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(k08==0) {
                $("#K8").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k08=1;                          
                seats.save();
            } else {
               k08=0;                           
               $("#K8").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int k09=0;
        $("#K9").on("click", {
            String sn="K9";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(k09==0) {
                $("#K9").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k09=1;                          
                seats.save();
            } else {
               k09=0;                           
               $("#K9").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        
        int k010=0;
        $("#K10").on("click", {
            String sn="K10";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(k010==0) {
                $("#K10").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k010=1;                          
                seats.save();
            } else {
               k010=0;                           
               $("#K10").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        int k011=0;
        $("#K11").on("click", {
            String sn="K11";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(k011==0) {
                $("#K11").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k011=1;                          
                seats.save();
            } else {
               k011=0;                           
               $("#K11").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int k012=0;
        $("#K12").on("click", {
            String sn="K12";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(k012==0) {
                $("#K12").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k012=1;                          
                seats.save();
            } else {
               k012=0;                           
               $("#K12").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int k013=0;
        $("#K13").on("click", {
            String sn="K13";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(k013==0) {
                $("#K13").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k013=1;                          
                seats.save();
            } else {
               k013=0;                           
               $("#K13").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int k014=0;
        $("#K14").on("click", {
            String sn="K14";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(k014==0) {
                $("#K14").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k014=1;                          
                seats.save();
            } else {
               k014=0;                           
               $("#K14").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int k015=0;
        $("#K15").on("click", {
            String sn="K15";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(k015==0) {
                $("#K15").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k015=1;                          
                seats.save();
            } else {
               k015=0;                           
               $("#K15").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int k016=0;
        $("#K16").on("click", {
            String sn="K16";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(k016==0) {
                $("#K16").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k016=1;                          
                seats.save();
            } else {
               k016=0;                           
               $("#K16").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int k017=0;
        $("#K17").on("click", {
            String sn="K17";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(k017==0) {
                $("#K17").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k017=1;                          
                seats.save();
            } else {
               k017=0;                           
               $("#K17").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int k018=0;
        $("#K18").on("click", {
            String sn="K18";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(k018==0) {
                $("#K18").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                k018=1;                          
                seats.save();
            } else {
               k018=0;                           
               $("#K18").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

//===============================END K Seate Row===============

//===============Start J Seate Row======================
int j00=0;
        $("#J0").on("click", {
            String sn="J0";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(j00==0) {
                $("#J0").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                j00=1;                          
                seats.save();
            } else {
               j00=0;                           
               $("#J0").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }
            //$("#K0").setStyle("background-color: black; position: relative;");  //ok
            //def seats = Seats.findAllBySeatNumberLike("K0")
            // def seats = Seats.get(1)     
            //$("#K0").setLabel(".");  //ok
        })
        int j01=0;
        $("#J1").on("click", {
            String sn="J1";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(j01==0) {
                $("#J1").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                j01=1;                          
                seats.save();
            } else {
               j01=0;                           
               $("#J1").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        int j02=0;
        $("#J2").on("click", {
            String sn="J2";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(j02==0) {
                $("#J2").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                j02=1;                          
                seats.save();
            } else {
               j02=0;                           
               $("#J2").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int j03=0;
        $("#J3").on("click", {
            String sn="J3";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(j03==0) {
                $("#J3").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                j03=1;                          
                seats.save();
            } else {
               j03=0;                           
               $("#J3").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int j04=0;
        $("#J4").on("click", {
            String sn="J4";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(j04==0) {
                $("#J4").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                j04=1;                          
                seats.save();
            } else {
               j04=0;                           
               $("#J4").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int j05=0;
        $("#J5").on("click", {
            String sn="J5";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(j05==0) {
                $("#J5").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                j05=1;                          
                seats.save();
            } else {
               j05=0;                           
               $("#J5").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int j06=0;
        $("#J6").on("click", {
            String sn="J6";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(j06==0) {
                $("#J6").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                j06=1;                          
                seats.save();
            } else {
               j06=0;                           
               $("#J6").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int j07=0;
        $("#J7").on("click", {
            String sn="J7";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(j07==0) {
                $("#J7").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                j07=1;                          
                seats.save();
            } else {
               j07=0;                           
               $("#J7").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int j08=0;
        $("#J8").on("click", {
            String sn="J8";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(j08==0) {
                $("#J8").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                j08=1;                          
                seats.save();
            } else {
               j08=0;                           
               $("#J8").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int j09=0;
        $("#J9").on("click", {
            String sn="J9";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(j09==0) {
                $("#J9").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                j09=1;                          
                seats.save();
            } else {
               j09=0;                           
               $("#J9").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        
        int j010=0;
        $("#J10").on("click", {
            String sn="J10";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(j010==0) {
                $("#J10").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                j010=1;                          
                seats.save();
            } else {
               j010=0;                           
               $("#J10").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        int j011=0;
        $("#J11").on("click", {
            String sn="J11";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(j011==0) {
                $("#J11").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                j011=1;                          
                seats.save();
            } else {
               j011=0;                           
               $("#J11").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int j012=0;
        $("#J12").on("click", {
            String sn="J12";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(j012==0) {
                $("#J12").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                j012=1;                          
                seats.save();
            } else {
              j012=0;                           
               $("#J12").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int j013=0;
        $("#J13").on("click", {
            String sn="J13";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(j013==0) {
                $("#J13").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
               j013=1;                          
                seats.save();
            } else {
               j013=0;                           
               $("#J13").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int j014=0;
        $("#J14").on("click", {
            String sn="J14";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(j014==0) {
                $("#J14").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                j014=1;                          
                seats.save();
            } else {
               j014=0;                           
               $("#J14").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int j015=0;
        $("#J15").on("click", {
            String sn="J15";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(j015==0) {
                $("#J15").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                j015=1;                          
                seats.save();
            } else {
               j015=0;                           
               $("#J15").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int j016=0;
        $("#J16").on("click", {
            String sn="J16";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(j016==0) {
                $("#J16").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                j016=1;                          
                seats.save();
            } else {
               j016=0;                           
               $("#J16").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int j017=0;
        $("#J17").on("click", {
            String sn="J17";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(j017==0) {
                $("#J17").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                j017=1;                          
                seats.save();
            } else {
               j017=0;                           
               $("#J17").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int j018=0;
        $("#J18").on("click", {
            String sn="J18";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(j018==0) {
                $("#J18").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                j018=1;                          
                seats.save();
            } else {
               j018=0;                           
               $("#J18").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

//=============END  J seats row=========

//========Start I  seats row===============
int i00=0;
        $("#I0").on("click", {
            String sn="I0";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(i00==0) {
                $("#I0").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                i00=1;                          
                seats.save();
            } else {
               i00=0;                           
               $("#I0").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }
            //$("#K0").setStyle("background-color: black; position: relative;");  //ok
            //def seats = Seats.findAllBySeatNumberLike("K0")
            // def seats = Seats.get(1)     
            //$("#K0").setLabel(".");  //ok
        })
        int i01=0;
        $("#I1").on("click", {
            String sn="I1";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(i01==0) {
                $("#I1").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                i01=1;                          
                seats.save();
            } else {
               i01=0;                           
               $("#I1").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        int i02=0;
        $("#I2").on("click", {
            String sn="I2";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(i02==0) {
                $("#I2").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                i02=1;                          
                seats.save();
            } else {
               i02=0;                           
               $("#I2").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int i03=0;
        $("#I3").on("click", {
            String sn="I3";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(i03==0) {
                $("#I3").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
               i03=1;                          
                seats.save();
            } else {
               i03=0;                           
               $("#I3").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int i04=0;
        $("#I4").on("click", {
            String sn="I4";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(i04==0) {
                $("#I4").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                i04=1;                          
                seats.save();
            } else {
               i04=0;                           
               $("#I4").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int i05=0;
        $("#I5").on("click", {
            String sn="I5";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(i05==0) {
                $("#I5").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                i05=1;                          
                seats.save();
            } else {
               i05=0;                           
               $("#I5").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int i06=0;
        $("#I6").on("click", {
            String sn="I6";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(i06==0) {
                $("#I6").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                i06=1;                          
                seats.save();
            } else {
               i06=0;                           
               $("#I6").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int i07=0;
        $("#I7").on("click", {
            String sn="I7";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(i07==0) {
                $("#I7").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                i07=1;                          
                seats.save();
            } else {
               i07=0;                           
               $("#I7").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int i08=0;
        $("#I8").on("click", {
            String sn="I8";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(i08==0) {
                $("#I8").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                i08=1;                          
                seats.save();
            } else {
               i08=0;                           
               $("#I8").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int i09=0;
        $("#I9").on("click", {
            String sn="I9";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(i09==0) {
                $("#I9").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                i09=1;                          
                seats.save();
            } else {
               i09=0;                           
               $("#I9").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        
        int i010=0;
        $("#I10").on("click", {
            String sn="I10";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(i010==0) {
                $("#I10").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                i010=1;                          
                seats.save();
            } else {
               i010=0;                           
               $("#I10").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        int i011=0;
        $("#I11").on("click", {
            String sn="I11";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(i011==0) {
                $("#I11").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                i011=1;                          
                seats.save();
            } else {
               i011=0;                           
               $("#I11").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int i012=0;
        $("#I12").on("click", {
            String sn="I12";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(i012==0) {
                $("#I12").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                i012=1;                          
                seats.save();
            } else {
               i012=0;                           
               $("#I12").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int i013=0;
        $("#I13").on("click", {
            String sn="I13";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(i013==0) {
                $("#I13").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                i013=1;                          
                seats.save();
            } else {
               i013=0;                           
               $("#I13").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int i014=0;
        $("#I14").on("click", {
            String sn="I14";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(i014==0) {
                $("#I14").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                i014=1;                          
                seats.save();
            } else {
               i014=0;                           
               $("#I14").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int i015=0;
        $("#I15").on("click", {
            String sn="I15";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(i015==0) {
                $("#I15").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                i015=1;                          
                seats.save();
            } else {
               i015=0;                           
               $("#I15").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int i016=0;
        $("#I16").on("click", {
            String sn="I16";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(i016==0) {
                $("#I16").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                i016=1;                          
                seats.save();
            } else {
               i016=0;                           
               $("#I16").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int i017=0;
        $("#I17").on("click", {
            String sn="I17";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(i017==0) {
                $("#I17").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                i017=1;                          
                seats.save();
            } else {
               i017=0;                           
               $("#I17").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int i018=0;
        $("#I18").on("click", {
            String sn="I18";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(i018==0) {
                $("#I18").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                i018=1;                          
                seats.save();
            } else {
               i018=0;                           
               $("#I18").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
//========END I Seats Row=================


//========Start H  seats row===============
int h00=0;
        $("#H0").on("click", {
            String sn="H0";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(h00==0) {
                $("#H0").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                h00=1;                          
                seats.save();
            } else {
               h00=0;                           
               $("#H0").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }
            //$("#K0").setStyle("background-color: black; position: relative;");  //ok
            //def seats = Seats.findAllBySeatNumberLike("K0")
            // def seats = Seats.get(1)     
            //$("#K0").setLabel(".");  //ok
        })
        int h01=0;
        $("#H1").on("click", {
            String sn="H1";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(h01==0) {
                $("#H1").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
               h01=1;                          
                seats.save();
            } else {
               h01=0;                           
               $("#H1").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        int h02=0;
        $("#H2").on("click", {
            String sn="H2";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(h02==0) {
                $("#H2").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                h02=1;                          
                seats.save();
            } else {
               h02=0;                           
               $("#H2").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int h03=0;
        $("#H3").on("click", {
            String sn="H3";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(h03==0) {
                $("#H3").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                h03=1;                          
                seats.save();
            } else {
               h03=0;                           
               $("#H3").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int h04=0;
        $("#H4").on("click", {
            String sn="H4";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(h04==0) {
                $("#H4").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                h04=1;                          
                seats.save();
            } else {
               h04=0;                           
               $("#H4").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int h05=0;
        $("#H5").on("click", {
            String sn="H5";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(h05==0) {
                $("#H5").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                h05=1;                          
                seats.save();
            } else {
               h05=0;                           
               $("#H5").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int h06=0;
        $("#H6").on("click", {
            String sn="H6";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(h06==0) {
                $("#H6").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                h06=1;                          
                seats.save();
            } else {
               h06=0;                           
               $("#H6").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int h07=0;
        $("#H7").on("click", {
            String sn="H7";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(h07==0) {
                $("#H7").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                h07=1;                          
                seats.save();
            } else {
               h07=0;                           
               $("#H7").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int h08=0;
        $("#H8").on("click", {
            String sn="H8";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(h08==0) {
                $("#H8").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                h08=1;                          
                seats.save();
            } else {
               h08=0;                           
               $("#H8").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int h09=0;
        $("#H9").on("click", {
            String sn="H9";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(h09==0) {
                $("#H9").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                h09=1;                          
                seats.save();
            } else {
               h09=0;                           
               $("#H9").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        
        int h010=0;
        $("#H10").on("click", {
            String sn="H10";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(h010==0) {
                $("#H10").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                h010=1;                          
                seats.save();
            } else {
               h010=0;                           
               $("#H10").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        int h011=0;
        $("#H11").on("click", {
            String sn="H11";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(h011==0) {
                $("#H11").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                h011=1;                          
                seats.save();
            } else {
               h011=0;                           
               $("#H11").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int h012=0;
        $("#H12").on("click", {
            String sn="H12";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(h012==0) {
                $("#H12").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                h012=1;                          
                seats.save();
            } else {
               h012=0;                           
               $("#H12").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int h013=0;
        $("#H13").on("click", {
            String sn="H13";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(h013==0) {
                $("#H13").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                h013=1;                          
                seats.save();
            } else {
              h013=0;                           
               $("#H13").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int h014=0;
        $("#H14").on("click", {
            String sn="H14";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(h014==0) {
                $("#H14").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                h014=1;                          
                seats.save();
            } else {
               k014=0;                           
               $("#H14").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int h015=0;
        $("#H15").on("click", {
            String sn="H15";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(h015==0) {
                $("#H15").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                h015=1;                          
                seats.save();
            } else {
               h015=0;                           
               $("#H15").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int h016=0;
        $("#H16").on("click", {
            String sn="H16";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(h016==0) {
                $("#H16").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                h016=1;                          
                seats.save();
            } else {
               h016=0;                           
               $("#H16").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int h017=0;
        $("#H17").on("click", {
            String sn="H17";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(h017==0) {
                $("#H17").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                h017=1;                          
                seats.save();
            } else {
               h017=0;                           
               $("#H17").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int h018=0;
        $("#H18").on("click", {
            String sn="H18";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(h018==0) {
                $("#H18").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                h018=1;                          
                seats.save();
            } else {
               h018=0;                           
               $("#H18").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
//========END H Seats Row=================



//========Start G  seats row===============
int g00=0;
        $("#G0").on("click", {
            String sn="G0";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(g00==0) {
                $("#G0").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                g00=1;                          
                seats.save();
            } else {
               g00=0;                           
               $("#G0").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }
            //$("#K0").setStyle("background-color: black; position: relative;");  //ok
            //def seats = Seats.findAllBySeatNumberLike("K0")
            // def seats = Seats.get(1)     
            //$("#K0").setLabel(".");  //ok
        })
        int g01=0;
        $("#G1").on("click", {
            String sn="G1";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(g01==0) {
                $("#G1").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                g01=1;                          
                seats.save();
            } else {
               g01=0;                           
               $("#G1").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        int g02=0;
        $("#G2").on("click", {
            String sn="G2";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(g02==0) {
                $("#G2").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                g02=1;                          
                seats.save();
            } else {
               g02=0;                           
               $("#G2").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int g03=0;
        $("#G3").on("click", {
            String sn="G3";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(g03==0) {
                $("#G3").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                g03=1;                          
                seats.save();
            } else {
               g03=0;                           
               $("#G3").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int g04=0;
        $("#G4").on("click", {
            String sn="G4";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(g04==0) {
                $("#G4").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                g04=1;                          
                seats.save();
            } else {
               g04=0;                           
               $("#G4").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int g05=0;
        $("#G5").on("click", {
            String sn="G5";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(g05==0) {
                $("#G5").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                g05=1;                          
                seats.save();
            } else {
               g05=0;                           
               $("#G5").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int g06=0;
        $("#G6").on("click", {
            String sn="G6";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(g06==0) {
                $("#G6").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                g06=1;                          
                seats.save();
            } else {
               g06=0;                           
               $("#G6").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int g07=0;
        $("#G7").on("click", {
            String sn="G7";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(g07==0) {
                $("#G7").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                g07=1;                          
                seats.save();
            } else {
               g07=0;                           
               $("#G7").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int g08=0;
        $("#G8").on("click", {
            String sn="G8";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(g08==0) {
                $("#G8").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                g08=1;                          
                seats.save();
            } else {
               g08=0;                           
               $("#G8").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int g09=0;
        $("#G9").on("click", {
            String sn="G9";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(g09==0) {
                $("#G9").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                g09=1;                          
                seats.save();
            } else {
               g09=0;                           
               $("#G9").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        
        int g010=0;
        $("#G10").on("click", {
            String sn="G10";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(g010==0) {
                $("#G10").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                g010=1;                          
                seats.save();
            } else {
               g010=0;                           
               $("#G10").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        int g011=0;
        $("#G11").on("click", {
            String sn="G11";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(g011==0) {
                $("#G11").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                g011=1;                          
                seats.save();
            } else {
               g011=0;                           
               $("#G11").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int g012=0;
        $("#G12").on("click", {
            String sn="G12";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(g012==0) {
                $("#G12").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                g012=1;                          
                seats.save();
            } else {
               g012=0;                           
               $("#G12").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int g013=0;
        $("#G13").on("click", {
            String sn="G13";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(g013==0) {
                $("#G13").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                g013=1;                          
                seats.save();
            } else {
               g013=0;                           
               $("#G13").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int g014=0;
        $("#G14").on("click", {
            String sn="G14";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(g014==0) {
                $("#G14").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                g014=1;                          
                seats.save();
            } else {
               g014=0;                           
               $("#G14").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int g015=0;
        $("#G15").on("click", {
            String sn="G15";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(g015==0) {
                $("#G15").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                g015=1;                          
                seats.save();
            } else {
               g015=0;                           
               $("#G15").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int g016=0;
        $("#G16").on("click", {
            String sn="G16";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(g016==0) {
                $("#G16").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                g016=1;                          
                seats.save();
            } else {
               g016=0;                           
               $("#G16").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int g017=0;
        $("#G17").on("click", {
            String sn="G17";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(g017==0) {
                $("#G17").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                g017=1;                          
                seats.save();
            } else {
               g017=0;                           
               $("#G17").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int g018=0;
        $("#G18").on("click", {
            String sn="G18";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(g018==0) {
                $("#G18").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                g018=1;                          
                seats.save();
            } else {
               g018=0;                           
               $("#G18").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
//========END G Seats Row=================



//========Start F  seats row===============
int f00=0;
        $("#F0").on("click", {
            String sn="F0";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(f00==0) {
                $("#F0").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                f00=1;                          
                seats.save();
            } else {
               f00=0;                           
               $("#F0").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }
            //$("#K0").setStyle("background-color: black; position: relative;");  //ok
            //def seats = Seats.findAllBySeatNumberLike("K0")
            // def seats = Seats.get(1)     
            //$("#K0").setLabel(".");  //ok
        })
        int f01=0;
        $("#F1").on("click", {
            String sn="F1";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(f01==0) {
                $("#F1").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                f01=1;                          
                seats.save();
            } else {
               f01=0;                           
               $("#F1").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        int f02=0;
        $("#F2").on("click", {
            String sn="F2";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(f02==0) {
                $("#F2").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                f02=1;                          
                seats.save();
            } else {
               f02=0;                           
               $("#F2").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int f03=0;
        $("#F3").on("click", {
            String sn="F3";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(f03==0) {
                $("#F3").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                f03=1;                          
                seats.save();
            } else {
               f03=0;                           
               $("#F3").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int f04=0;
        $("#F4").on("click", {
            String sn="F4";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(f04==0) {
                $("#F4").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                f04=1;                          
                seats.save();
            } else {
               f04=0;                           
               $("#F4").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int f05=0;
        $("#F5").on("click", {
            String sn="F5";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(f05==0) {
                $("#F5").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                f05=1;                          
                seats.save();
            } else {
               f05=0;                           
               $("#F5").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int f06=0;
        $("#F6").on("click", {
            String sn="F6";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(f06==0) {
                $("#F6").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                f06=1;                          
                seats.save();
            } else {
               f06=0;                           
               $("#F6").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int f07=0;
        $("#F7").on("click", {
            String sn="F7";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(f07==0) {
                $("#F7").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                f07=1;                          
                seats.save();
            } else {
               f07=0;                           
               $("#F7").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int f08=0;
        $("#F8").on("click", {
            String sn="F8";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(f08==0) {
                $("#F8").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                f08=1;                          
                seats.save();
            } else {
               f08=0;                           
               $("#F8").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int f09=0;
        $("#F9").on("click", {
            String sn="F9";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(f09==0) {
                $("#F9").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                f09=1;                          
                seats.save();
            } else {
               f09=0;                           
               $("#F9").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        
        int f010=0;
        $("#F10").on("click", {
            String sn="F10";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(f010==0) {
                $("#F10").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                f010=1;                          
                seats.save();
            } else {
               f010=0;                           
               $("#F10").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        int f011=0;
        $("#F11").on("click", {
            String sn="F11";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(f011==0) {
                $("#F11").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                f011=1;                          
                seats.save();
            } else {
               f011=0;                           
               $("#F11").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int f012=0;
        $("#F12").on("click", {
            String sn="F12";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(f012==0) {
                $("#F12").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                f012=1;                          
                seats.save();
            } else {
               f012=0;                           
               $("#F12").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int f013=0;
        $("#F13").on("click", {
            String sn="F13";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(f013==0) {
                $("#F13").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                f013=1;                          
                seats.save();
            } else {
               f013=0;                           
               $("#F13").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int f014=0;
        $("#F14").on("click", {
            String sn="F14";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(f014==0) {
                $("#F14").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                f014=1;                          
                seats.save();
            } else {
               f014=0;                           
               $("#F14").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int f015=0;
        $("#F15").on("click", {
            String sn="F15";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(f015==0) {
                $("#F15").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                f015=1;                          
                seats.save();
            } else {
               f015=0;                           
               $("#F15").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int f016=0;
        $("#F16").on("click", {
            String sn="F16";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(f016==0) {
                $("#F16").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                f016=1;                          
                seats.save();
            } else {
               f016=0;                           
               $("#F16").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int f017=0;
        $("#F17").on("click", {
            String sn="F17";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(f017==0) {
                $("#F17").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                f017=1;                          
                seats.save();
            } else {
               f017=0;                           
               $("#F17").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int f018=0;
        $("#F18").on("click", {
            String sn="F18";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(f018==0) {
                $("#F18").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                f018=1;                          
                seats.save();
            } else {
               f018=0;                           
               $("#F18").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
//========END F Seats Row=================



//========Start E  seats row===============
int e00=0;
        $("#E0").on("click", {
            String sn="E0";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(e00==0) {
                $("#E0").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                e00=1;                          
                seats.save();
            } else {
               e00=0;                           
               $("#E0").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }
            //$("#K0").setStyle("background-color: black; position: relative;");  //ok
            //def seats = Seats.findAllBySeatNumberLike("K0")
            // def seats = Seats.get(1)     
            //$("#K0").setLabel(".");  //ok
        })
        int e01=0;
        $("#E1").on("click", {
            String sn="E1";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(e01==0) {
                $("#E1").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                e01=1;                          
                seats.save();
            } else {
               e01=0;                           
               $("#E1").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        int e02=0;
        $("#E2").on("click", {
            String sn="E2";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(e02==0) {
                $("#E2").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                e02=1;                          
                seats.save();
            } else {
               e02=0;                           
               $("#E2").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int e03=0;
        $("#E3").on("click", {
            String sn="E3";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(e03==0) {
                $("#E3").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                e03=1;                          
                seats.save();
            } else {
               e03=0;                           
               $("#E3").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int e04=0;
        $("#E4").on("click", {
            String sn="E4";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(e04==0) {
                $("#E4").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                e04=1;                          
                seats.save();
            } else {
               e04=0;                           
               $("#E4").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int e05=0;
        $("#E5").on("click", {
            String sn="E5";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(e05==0) {
                $("#E5").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                e05=1;                          
                seats.save();
            } else {
               e05=0;                           
               $("#E5").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int e06=0;
        $("#E6").on("click", {
            String sn="E6";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(e06==0) {
                $("#E6").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                e06=1;                          
                seats.save();
            } else {
               e06=0;                           
               $("#E6").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int e07=0;
        $("#E7").on("click", {
            String sn="E7";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(e07==0) {
                $("#E7").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                e07=1;                          
                seats.save();
            } else {
               e07=0;                           
               $("#E7").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int e08=0;
        $("#E8").on("click", {
            String sn="E8";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(e08==0) {
                $("#E8").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                e08=1;                          
                seats.save();
            } else {
               e08=0;                           
               $("#E8").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int e09=0;
        $("#E9").on("click", {
            String sn="E9";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(e09==0) {
                $("#E9").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                e09=1;                          
                seats.save();
            } else {
               e09=0;                           
               $("#E9").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        
        int e010=0;
        $("#E10").on("click", {
            String sn="E10";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(e010==0) {
                $("#E10").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                e010=1;                          
                seats.save();
            } else {
               e010=0;                           
               $("#E10").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        int e011=0;
        $("#E11").on("click", {
            String sn="E11";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(e011==0) {
                $("#E11").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                e011=1;                          
                seats.save();
            } else {
               e011=0;                           
               $("#E11").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int e012=0;
        $("#E12").on("click", {
            String sn="E12";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(e012==0) {
                $("#E12").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                e012=1;                          
                seats.save();
            } else {
               e012=0;                           
               $("#E12").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int e013=0;
        $("#E13").on("click", {
            String sn="E13";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(e013==0) {
                $("#E13").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                e013=1;                          
                seats.save();
            } else {
               e013=0;                           
               $("#E13").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int e014=0;
        $("#E14").on("click", {
            String sn="E14";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(e014==0) {
                $("#E14").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                e014=1;                          
                seats.save();
            } else {
               e014=0;                           
               $("#E14").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int e015=0;
        $("#E15").on("click", {
            String sn="E15";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(e015==0) {
                $("#E15").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                e015=1;                          
                seats.save();
            } else {
               e015=0;                           
               $("#E15").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int e016=0;
        $("#E16").on("click", {
            String sn="E16";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(e016==0) {
                $("#E16").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                e016=1;                          
                seats.save();
            } else {
               e016=0;                           
               $("#E16").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int e017=0;
        $("#E17").on("click", {
            String sn="E17";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(e017==0) {
                $("#E17").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                e017=1;                          
                seats.save();
            } else {
               e017=0;                           
               $("#E17").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int e018=0;
        $("#E18").on("click", {
            String sn="E18";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(e018==0) {
                $("#E18").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                e018=1;                          
                seats.save();
            } else {
               e018=0;                           
               $("#E18").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
//========END E Seats Row=================



//========Start D  seats row===============
int d00=0;
        $("#D0").on("click", {
            String sn="D0";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(d00==0) {
                $("#D0").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                d00=1;                          
                seats.save();
            } else {
               kd00=0;                           
               $("#D0").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }
            //$("#K0").setStyle("background-color: black; position: relative;");  //ok
            //def seats = Seats.findAllBySeatNumberLike("K0")
            // def seats = Seats.get(1)     
            //$("#K0").setLabel(".");  //ok
        })
        int d01=0;
        $("#D1").on("click", {
            String sn="D1";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(d01==0) {
                $("#D1").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                d01=1;                          
                seats.save();
            } else {
               d01=0;                           
               $("#D1").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        int d02=0;
        $("#D2").on("click", {
            String sn="D2";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(d02==0) {
                $("#D2").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                d02=1;                          
                seats.save();
            } else {
               d02=0;                           
               $("#D2").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int d03=0;
        $("#D3").on("click", {
            String sn="D3";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(d03==0) {
                $("#D3").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                d03=1;                          
                seats.save();
            } else {
               d03=0;                           
               $("#D3").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int d04=0;
        $("#D4").on("click", {
            String sn="D4";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(d04==0) {
                $("#D4").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                d04=1;                          
                seats.save();
            } else {
               d04=0;                           
               $("#D4").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int d05=0;
        $("#D5").on("click", {
            String sn="D5";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(d05==0) {
                $("#D5").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                d05=1;                          
                seats.save();
            } else {
               d05=0;                           
               $("#D5").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int d06=0;
        $("#D6").on("click", {
            String sn="D6";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(d06==0) {
                $("#D6").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                d06=1;                          
                seats.save();
            } else {
               d06=0;                           
               $("#D6").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int d07=0;
        $("#D7").on("click", {
            String sn="D7";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(d07==0) {
                $("#D7").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                d07=1;                          
                seats.save();
            } else {
               d07=0;                           
               $("#D7").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int d08=0;
        $("#D8").on("click", {
            String sn="D8";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(d08==0) {
                $("#D8").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                d08=1;                          
                seats.save();
            } else {
               d08=0;                           
               $("#D8").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int d09=0;
        $("#D9").on("click", {
            String sn="D9";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(d09==0) {
                $("#D9").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                d09=1;                          
                seats.save();
            } else {
               d09=0;                           
               $("#D9").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        
        int d010=0;
        $("#D10").on("click", {
            String sn="D10";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(d010==0) {
                $("#D10").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                d010=1;                          
                seats.save();
            } else {
               d010=0;                           
               $("#D10").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        int d011=0;
        $("#D11").on("click", {
            String sn="D11";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(d011==0) {
                $("#D11").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                d011=1;                          
                seats.save();
            } else {
               d011=0;                           
               $("#D11").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int d012=0;
        $("#D12").on("click", {
            String sn="D12";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(d012==0) {
                $("#D12").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                d012=1;                          
                seats.save();
            } else {
               d012=0;                           
               $("#D12").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int d013=0;
        $("#D13").on("click", {
            String sn="D13";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(d013==0) {
                $("#D13").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                d013=1;                          
                seats.save();
            } else {
               d013=0;                           
               $("#D13").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int d014=0;
        $("#D14").on("click", {
            String sn="D14";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(d014==0) {
                $("#D14").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                d014=1;                          
                seats.save();
            } else {
               d014=0;                           
               $("#D14").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int d015=0;
        $("#D15").on("click", {
            String sn="D15";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(d015==0) {
                $("#D15").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                d015=1;                          
                seats.save();
            } else {
               d015=0;                           
               $("#D15").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int d016=0;
        $("#D16").on("click", {
            String sn="D16";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(d016==0) {
                $("#D16").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                d016=1;                          
                seats.save();
            } else {
               d016=0;                           
               $("#D16").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int d017=0;
        $("#D17").on("click", {
            String sn="D17";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(d017==0) {
                $("#D17").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                d017=1;                          
                seats.save();
            } else {
               d017=0;                           
               $("#D17").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int d018=0;
        $("#D18").on("click", {
            String sn="D18";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(d018==0) {
                $("#D18").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                d018=1;                          
                seats.save();
            } else {
               d018=0;                           
               $("#D18").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
//========END D Seats Row=================



//========Start C  seats row===============
int c00=0;
        $("#C0").on("click", {
            String sn="C0";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(c00==0) {
                $("#C0").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                c00=1;                          
                seats.save();
            } else {
               c00=0;                           
               $("#C0").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }
            //$("#K0").setStyle("background-color: black; position: relative;");  //ok
            //def seats = Seats.findAllBySeatNumberLike("K0")
            // def seats = Seats.get(1)     
            //$("#K0").setLabel(".");  //ok
        })
        int c01=0;
        $("#C1").on("click", {
            String sn="C1";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(c01==0) {
                $("#C1").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                c01=1;                          
                seats.save();
            } else {
               c01=0;                           
               $("#C1").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        int c02=0;
        $("#C2").on("click", {
            String sn="C2";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(c02==0) {
                $("#C2").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                c02=1;                          
                seats.save();
            } else {
               c02=0;                           
               $("#C2").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int c03=0;
        $("#C3").on("click", {
            String sn="C3";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(c03==0) {
                $("#C3").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                c03=1;                          
                seats.save();
            } else {
               c03=0;                           
               $("#C3").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int c04=0;
        $("#C4").on("click", {
            String sn="C4";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(c04==0) {
                $("#C4").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                c04=1;                          
                seats.save();
            } else {
               c04=0;                           
               $("#C4").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int c05=0;
        $("#C5").on("click", {
            String sn="C5";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(c05==0) {
                $("#C5").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                c05=1;                          
                seats.save();
            } else {
               c05=0;                           
               $("#C5").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int c06=0;
        $("#C6").on("click", {
            String sn="C6";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(c06==0) {
                $("#C6").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                c06=1;                          
                seats.save();
            } else {
               c06=0;                           
               $("#C6").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int c07=0;
        $("#C7").on("click", {
            String sn="C7";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(c07==0) {
                $("#C7").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                c07=1;                          
                seats.save();
            } else {
               c07=0;                           
               $("#C7").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int c08=0;
        $("#C8").on("click", {
            String sn="C8";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(c08==0) {
                $("#C8").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                c08=1;                          
                seats.save();
            } else {
               c08=0;                           
               $("#C8").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int c09=0;
        $("#C9").on("click", {
            String sn="C9";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(c09==0) {
                $("#C9").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                c09=1;                          
                seats.save();
            } else {
               c09=0;                           
               $("#C9").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        
        int c010=0;
        $("#C10").on("click", {
            String sn="C10";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(c010==0) {
                $("#C10").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                c010=1;                          
                seats.save();
            } else {
               c010=0;                           
               $("#C10").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        int c011=0;
        $("#C11").on("click", {
            String sn="C11";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(c011==0) {
                $("#C11").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                c011=1;                          
                seats.save();
            } else {
               c011=0;                           
               $("#C11").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int c012=0;
        $("#C12").on("click", {
            String sn="C12";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(c012==0) {
                $("#C12").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                c012=1;                          
                seats.save();
            } else {
               c012=0;                           
               $("#C12").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int c013=0;
        $("#C13").on("click", {
            String sn="C13";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(c013==0) {
                $("#C13").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                c013=1;                          
                seats.save();
            } else {
               c013=0;                           
               $("#C13").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int c014=0;
        $("#C14").on("click", {
            String sn="C14";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(c014==0) {
                $("#C14").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                c014=1;                          
                seats.save();
            } else {
               c014=0;                           
               $("#C14").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int c015=0;
        $("#C15").on("click", {
            String sn="C15";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(c015==0) {
                $("#C15").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                c015=1;                          
                seats.save();
            } else {
               c015=0;                           
               $("#C15").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int c016=0;
        $("#C16").on("click", {
            String sn="C16";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(c016==0) {
                $("#C16").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                c016=1;                          
                seats.save();
            } else {
               c016=0;                           
               $("#C16").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int c017=0;
        $("#C17").on("click", {
            String sn="C17";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(c017==0) {
                $("#C17").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                c017=1;                          
                seats.save();
            } else {
               c017=0;                           
               $("#C17").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int c018=0;
        $("#C18").on("click", {
            String sn="C18";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(c018==0) {
                $("#C18").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                c018=1;                          
                seats.save();
            } else {
               c018=0;                           
               $("#C18").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
//========END C Seats Row=================


//========Start B  seats row===============
int b00=0;
        $("#B0").on("click", {
            String sn="B0";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(b00==0) {
                $("#B0").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                b00=1;                          
                seats.save();
            } else {
               b00=0;                           
               $("#B0").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }
            //$("#K0").setStyle("background-color: black; position: relative;");  //ok
            //def seats = Seats.findAllBySeatNumberLike("K0")
            // def seats = Seats.get(1)     
            //$("#K0").setLabel(".");  //ok
        })
        int b01=0;
        $("#B1").on("click", {
            String sn="B1";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(b01==0) {
                $("#B1").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                b01=1;                          
                seats.save();
            } else {
               b01=0;                           
               $("#B1").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        int b02=0;
        $("#B2").on("click", {
            String sn="B2";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(b02==0) {
                $("#B2").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                b02=1;                          
                seats.save();
            } else {
               b02=0;                           
               $("#B2").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int b03=0;
        $("#B3").on("click", {
            String sn="B3";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(b03==0) {
                $("#B3").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                b03=1;                          
                seats.save();
            } else {
               b03=0;                           
               $("#B3").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int b04=0;
        $("#B4").on("click", {
            String sn="B4";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(b04==0) {
                $("#B4").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                b04=1;                          
                seats.save();
            } else {
               b04=0;                           
               $("#B4").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int b05=0;
        $("#B5").on("click", {
            String sn="B5";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(b05==0) {
                $("#B5").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                b05=1;                          
                seats.save();
            } else {
               b05=0;                           
               $("#B5").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int b06=0;
        $("#B6").on("click", {
            String sn="B6";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(b06==0) {
                $("#B6").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                b06=1;                          
                seats.save();
            } else {
               b06=0;                           
               $("#B6").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int b07=0;
        $("#B7").on("click", {
            String sn="B7";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(b07==0) {
                $("#B7").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                b07=1;                          
                seats.save();
            } else {
               b07=0;                           
               $("#B7").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int b08=0;
        $("#B8").on("click", {
            String sn="B8";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(b08==0) {
                $("#B8").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                b08=1;                          
                seats.save();
            } else {
               b08=0;                           
               $("#B8").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int b09=0;
        $("#B9").on("click", {
            String sn="B9";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(b09==0) {
                $("#B9").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                b09=1;                          
                seats.save();
            } else {
               b09=0;                           
               $("#B9").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        
        int b010=0;
        $("#B10").on("click", {
            String sn="B10";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(b010==0) {
                $("#B10").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                b010=1;                          
                seats.save();
            } else {
               b010=0;                           
               $("#B10").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        int b011=0;
        $("#B11").on("click", {
            String sn="B11";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(b011==0) {
                $("#B11").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                b011=1;                          
                seats.save();
            } else {
               b011=0;                           
               $("#B11").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int b012=0;
        $("#B12").on("click", {
            String sn="B12";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(b012==0) {
                $("#B12").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                b012=1;                          
                seats.save();
            } else {
               b012=0;                           
               $("#B12").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int b013=0;
        $("#B13").on("click", {
            String sn="B13";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(b013==0) {
                $("#B13").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                b013=1;                          
                seats.save();
            } else {
               b013=0;                           
               $("#B13").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int b014=0;
        $("#B14").on("click", {
            String sn="B14";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(b014==0) {
                $("#B14").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                b014=1;                          
                seats.save();
            } else {
               b014=0;                           
               $("#B14").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int b015=0;
        $("#B15").on("click", {
            String sn="B15";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(b015==0) {
                $("#B15").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                b015=1;                          
                seats.save();
            } else {
               b015=0;                           
               $("#B15").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int b016=0;
        $("#B16").on("click", {
            String sn="B16";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(b016==0) {
                $("#B16").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                b016=1;                          
                seats.save();
            } else {
               b016=0;                           
               $("#B16").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int b017=0;
        $("#B17").on("click", {
            String sn="B17";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(b017==0) {
                $("#B17").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                b017=1;                          
                seats.save();
            } else {
               b017=0;                           
               $("#B17").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int b018=0;
        $("#B18").on("click", {
            String sn="B18";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(b018==0) {
                $("#B18").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                b018=1;                          
                seats.save();
            } else {
               b018=0;                           
               $("#B18").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
//========END B Seats Row=================



//========Start A  seats row===============
int a00=0;
        $("#A0").on("click", {
            String sn="A0";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(a00==0) {
                $("#A0").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                a00=1;                          
                seats.save();
            } else {
               a00=0;                           
               $("#A0").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }
            //$("#K0").setStyle("background-color: black; position: relative;");  //ok
            //def seats = Seats.findAllBySeatNumberLike("K0")
            // def seats = Seats.get(1)     
            //$("#K0").setLabel(".");  //ok
        })
        int a01=0;
        $("#A1").on("click", {
            String sn="A1";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(a01==0) {
                $("#A1").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                a01=1;                          
                seats.save();
            } else {
               a01=0;                           
               $("#A1").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        int a02=0;
        $("#A2").on("click", {
            String sn="A2";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(a02==0) {
                $("#A2").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                a02=1;                          
                seats.save();
            } else {
               a02=0;                           
               $("#A2").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int a03=0;
        $("#A3").on("click", {
            String sn="A3";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(a03==0) {
                $("#A3").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                a03=1;                          
                seats.save();
            } else {
               a03=0;                           
               $("#A3").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int a04=0;
        $("#A4").on("click", {
            String sn="A4";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(a04==0) {
                $("#A4").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                a04=1;                          
                seats.save();
            } else {
               a04=0;                           
               $("#A4").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int a05=0;
        $("#A5").on("click", {
            String sn="A5";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(a05==0) {
                $("#A5").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                a05=1;                          
                seats.save();
            } else {
               a05=0;                           
               $("#A5").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int a06=0;
        $("#A6").on("click", {
            String sn="A6";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(a06==0) {
                $("#A6").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                a06=1;                          
                seats.save();
            } else {
               a06=0;                           
               $("#A6").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int a07=0;
        $("#A7").on("click", {
            String sn="A7";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(a07==0) {
                $("#A7").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                a07=1;                          
                seats.save();
            } else {
               a07=0;                           
               $("#A7").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int a08=0;
        $("#A8").on("click", {
            String sn="A8";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(a08==0) {
                $("#A8").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                a08=1;                          
                seats.save();
            } else {
               a08=0;                           
               $("#A8").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int a09=0;
        $("#A9").on("click", {
            String sn="A9";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(a09==0) {
                $("#A9").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                a09=1;                          
                seats.save();
            } else {
               a09=0;                           
               $("#A9").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        
        int a010=0;
        $("#A10").on("click", {
            String sn="A10";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(a010==0) {
                $("#A10").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                a010=1;                          
                seats.save();
            } else {
               a010=0;                           
               $("#A10").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })

        int a011=0;
        $("#A11").on("click", {
            String sn="A11";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(a011==0) {
                $("#A11").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                a011=1;                          
                seats.save();
            } else {
               a011=0;                           
               $("#A11").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int a012=0;
        $("#A12").on("click", {
            String sn="A12";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(a012==0) {
                $("#A12").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                a012=1;                          
                seats.save();
            } else {
               a012=0;                           
               $("#A12").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int a013=0;
        $("#A13").on("click", {
            String sn="A13";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(a013==0) {
                $("#A13").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                a013=1;                          
                seats.save();
            } else {
               a013=0;                           
               $("#A13").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int a014=0;
        $("#A14").on("click", {
            String sn="A14";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(a014==0) {
                $("#A14").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                a014=1;                          
                seats.save();
            } else {
               a014=0;                           
               $("#A14").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int a015=0;
        $("#A15").on("click", {
            String sn="A15";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(a015==0) {
                $("#A15").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                a015=1;                          
                seats.save();
            } else {
               a015=0;                           
               $("#A15").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int a016=0;
        $("#A16").on("click", {
            String sn="A16";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(a016==0) {
                $("#A16").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                a016=1;                          
                seats.save();
            } else {
               a016=0;                           
               $("#A16").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int a017=0;
        $("#A17").on("click", {
            String sn="A17";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(a017==0) {
                $("#A17").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                a017=1;                          
                seats.save();
            } else {
               a017=0;                           
               $("#A17").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
        int a018=0;
        $("#A18").on("click", {
            String sn="A18";
            seats= new BufferSeats(bSeatNumber:sn,bTime:"${showTime}",bMovName:"${theater.movies.movName}",theaters:theater)
            if(a018==0) {
                $("#A18").setStyle("background-image:url(./ext/seatsTicket/seatsReady.png); position: relative;");
                a018=1;                          
                seats.save();
            } else {
               a018=0;                           
               $("#A18").setStyle("background-image:url(./ext/seatsTicket/seatsEmpty.png); position: relative;color:gold");
               seats = BufferSeats.findByBSeatNumber(sn)
               seats.delete()
            }            
        })
//========END A Seats Row=================

        



        $("#btnBuyTicket").on("click", {
            def bufferSeats=BufferSeats.findAll()
            if(bufferSeats){
                bufferSeats.each{buff ->
                  def seatSave = new Seats(seatNumber:"${buff.bSeatNumber}",time:"${buff.bTime}",movName:"${buff.bMovName}",theaters:theater)
                  seatSave.save()
                }
                String statusSeats
                session.statusSeats = session.status
              redirect(uri:'price.zul')
              }else{

                alert("กรุณาเลือกที่นั่ง")
              }




            //def namepp
            //session.namepp = seats
            //def namepp2 
            ///session.namepp2 = rooms
            
                
        })

        

    }
}
