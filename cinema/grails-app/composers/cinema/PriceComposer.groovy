package cinema

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class PriceComposer extends GrailsComposer {

    def afterCompose = { window ->
        // initialize components here
        if (!session['user'])
            redirect(uri:'/login.zul')
        else {
            window.visible = true

            $("#nameBuncee").val(session.user.firstName + " " + session.user.lastName)
            $("#nameBuncee2").val(session.user.firstName + " " + session.user.lastName)
            $("#nameBuncee3").val(session.user.firstName + " " + session.user.lastName)
           

            $("#logOut").on("click", {
                session.user = null
                def buffer=BufferSeats.findAll()
                if(buffer){
                    buffer.each{buff ->
                    def buf = BufferSeats.get(buff.id)
                    buf.delete()
                }
                redirect(uri:'/login.zul')
            }

            })

            $("#logOut2").on("click", {
                session.user = null
                def buffer=BufferSeats.findAll()
                if(buffer){
                    buffer.each{buff ->
                    def buf = BufferSeats.get(buff.id)
                    buf.delete()
                }
                redirect(uri:'/login.zul')
            }


            })

            $("#logOut3").on("click", {
                session.user = null
                def buffer=BufferSeats.findAll()
                if(buffer){
                    buffer.each{buff ->
                    def buf = BufferSeats.get(buff.id)
                    buf.delete()
                }
                redirect(uri:'/login.zul')
            }


            })



            //==============================================================
        def results = Amount.findAll()
        
        int sumpri = 0;
        int i =0;
        if(results){
                //$("grid > rows").detach()
                for(c in results)
                    $("grid > rows").append{
                                row{
                                    label(value:c.movieName)
                                    label(value:c.showtime)
                                    label(value:c.theaTer)
                                    label(value:c.seat)
                                    label(value:c.price)
                                    i=i+c.price
                                }
                    }
        }
        sumpri =i

        //===============================================================
        //def movie = new Movie(movId:"12",movType:"Action",movName:"spiderman",movSuperintendent:"asn",movDetail:"fdhsfgjsfjg",movCost:"movCost",movDate:"movDate",movDateEnd:"movDateEnd",movPicture640:"movPicture640",movPicture140:"movPicture140",promotion:"Empty",longTime: 234 ,theaters:theaters,shows:shows)
        //def theaters = new Theater(theaterId:"qqwwee",shows:shows,seats:seats,bufferSeats:bufferSeats,movies:movies)
        //def shows = new Show(showDay:new Date(),showTime:"showTime",theaters:theaters,movies:movies)
        //def seats = new Seats(seatNumber:'k1',time:"time",theaters:theaters,amount:amount)
        
        // initialize components here

        def results2 = BufferSeats.findAll()

        $('#moviename1').val(results2[0].theaters.movies.movName)

        


        $('#moviename2').val(results2[0].theaters.movies.movType)
        $('#blanch').val("Team13")
        $('#runt').val(results2[0].bTime)
        int sumprice = 120;

        if(results2){
                //$("grid > rows").detach()
                String b=""
                int i1=0;
                for(c in results2){
                    def a = c.bSeatNumber
                    b=b+a+", "
                    i1++;
                }
                sumprice=sumprice*i1;
                $('#seat').val(b)
                $('#bi').val(i1)
        }
        $('#plant').val(results2[0].theaters.theaterId)
        $('#promotion').val(results2[0].theaters.movies.promotion)

        if(session.statusSeats=="ปกติ"){
                if(results2[0].theaters.movies.promotion=="Sale_50%"){
                    sumprice=sumprice/2
                    $('#sum').val(sumprice)
                }else{
                    $('#sum').val(sumprice)
                }
        }else{
            $('#sum').val("0")
        }

        $('#IDPnuknanSearch').val(sumpri)
        $('#namePanukngan').val(session.user.firstName + " " + session.user.lastName)
        $('#livePanukngan').val(session.user.address + " " + session.user.moo + " "+session.user.county)
        $('#telePhPanukngan').val(session.user.phone)

        //=====================================================================================================
    

        
        //=====================================================================================================


        $('#send').on('click',{
            $('#mov').val(results2[0].theaters.movies.movName)
            $('#rob').val(results2[0].bTime)
            String s1 = $('#seat').getText()

            $('#teenung').val(s1)
            $('#rong').val(results2[0].theaters.theaterId)
            if(session.statusSeats=="ปกติ"){
                $('#mony').val(sumprice)
            }else{
                $('#mony').val("0")
            }
            String ss1=""
            for(c in results2){
                    def a = c.bSeatNumber
                    def seats1 = Seats.findBySeatNumberAndTimeAndMovName("${a}",results2[0].bTime,results2[0].theaters.movies.movName)
                    seats1.id
                    ss1 = ss1+" , "+seats1.id
                    
                }
           // def seats1 = Seats.findBySeatNumberAndTime()

            $('#idsit').val(ss1)

            $('#mov2').val(results2[0].theaters.movies.movName)
            $('#rob2').val(results2[0].bTime)
            $('#teenung2').val(s1)
            $('#rong2').val(results2[0].theaters.theaterId)
            if(session.statusSeats=="ปกติ"){
                $('#mony2').val(sumprice)
            }else{
                $('#mony2').val("0")
            }

            //==================================================================================

            if(results2[0].theaters.movies.promotion=="Empty"){
                $('#pro1').setVisible(false)
                $('#pro2').setVisible(false)
                $('#pro3').setVisible(false)
                $('#pro4').setVisible(false)
                $('#pro5').setVisible(false)
                $('#pro6').setVisible(false)
                $('#pro7').setVisible(false)
                $('#pro8').setVisible(false)

            }
            if(results2[0].theaters.movies.promotion=="Sale_50%"){
                $('#pro1').setVisible(false)
                $('#pro2').setVisible(false)
                $('#pro3').setVisible(false)
                //$('#pro4').setVisible(false)
                $('#pro5').setVisible(false)
                $('#pro6').setVisible(false)
                $('#pro7').setVisible(false)
                //$('#pro8').setVisible(false)

            }
            if(results2[0].theaters.movies.promotion=="Free_PopCorn"){
                $('#pro1').setVisible(false)
                $('#pro2').setVisible(false)
                //$('#pro3').setVisible(false)
                $('#pro4').setVisible(false)
                $('#pro5').setVisible(false)
                $('#pro6').setVisible(false)
                //$('#pro7').setVisible(false)
                $('#pro8').setVisible(false)

            }
            if(results2[0].theaters.movies.promotion=="Free_Coke_and_Hanami"){
                //$('#pro1').setVisible(false)
                //$('#pro2').setVisible(false)
                $('#pro3').setVisible(false)
                $('#pro4').setVisible(false)
                //$('#pro5').setVisible(false)
                //$('#pro6').setVisible(false)
                $('#pro7').setVisible(false)
                $('#pro8').setVisible(false)

            }
            

            //=================================================================================
            $('#C').setSelected(true)
         //====================================================================================================   
            def amount = new Amount(
                price:sumprice,
                name:session.user.firstName + " " + session.user.lastName,
                movieName:results2[0].theaters.movies.movName,
                showtime:results2[0].bTime,
                theaTer:results2[0].theaters.theaterId,
                seat:$('#seat').getText(),
                individual:session.user
                )
            amount.save()
            $("grid > rows").append{
                                row{
                                    label(value:results2[0].theaters.movies.movName)
                                    label(value:results2[0].bTime)
                                    label(value:results2[0].theaters.theaterId)
                                    label(value:s1)
                                    label(value:sumprice)
                                }
                    }
        //===================================================================================================
        })

        $('#clear').on('click',{
            def buffer=BufferSeats.findAll()
            if(buffer){
                buffer.each{buff ->
                def buf = BufferSeats.get(buff.id)
                buf.delete()
}
                redirect(uri:'/showTimesTicket.zul')
            }

        })

        $('#bak').on('click',{
            def buffer=BufferSeats.findAll()
            if(buffer){
                buffer.each{buff ->
                def buf = BufferSeats.get(buff.id)
                buf.delete()
}
                redirect(uri:'/showTimesTicket.zul')
            }
        })
        $('#bak2').on('click',{
           def buffer=BufferSeats.findAll()
            if(buffer){
                buffer.each{buff ->
                def buf = BufferSeats.get(buff.id)
                buf.delete()
}
               $('#B').setSelected(true) 
            }
        })
        $('#bun').on('click',{
           def buffer=BufferSeats.findAll()
            if(buffer){
                buffer.each{buff ->
                def buf = BufferSeats.get(buff.id)
                buf.delete()
}
                redirect(uri:'/showTimesTicket.zul')
            }
            redirect(uri:'/showTimesTicket.zul')
        })

//=================================================================


//==================================================================
        

        }
        
    }
}
