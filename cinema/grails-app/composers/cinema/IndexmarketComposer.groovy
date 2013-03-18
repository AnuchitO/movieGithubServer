package cinema

import org.zkoss.zk.grails.composer.*
import org.zkoss.zk.ui.Executions
import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class IndexmarketComposer extends GrailsComposer {
    
    def afterCompose = { window ->
        
         if (!session['user'])
            redirect(uri:'/login.zul')
        else {
            window.visible = true

            $("#logonName").val(session.user.firstName + " " + session.user.lastName)
           

            $("#logout").on("click", {
                session.user = null
                redirect(uri:'/login.zul')

            })

           
        }
        //===========================================
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
        //===========================================

        def x = Sales.findAll([sort:'buyCount', order:'desc'])
        def i
        if(x){
        i = x.buyCount[0]+1
        }else{
        i=1;
        }
        def branch
        $("#nextbtn").on("click", {
                redirect(uri:'totalmarket.zul')
            })
        

       $("#inputbtn1").on("click", {
            if($('#b1')[0].getText().size()==0){
                alert("กรุณากรอกจำนวนสินค้า")
            }
            else{

                def b1 = $('#b1')[0].getText()
                int t=Integer.valueOf(b1);
                def y = t*20
                def imp1 = new Sales(buyCount:i , salesProduct:"Hanami" , salesAmount:b1,salesprice:y ,date:new Date())
                imp1.save()
                $('#b1').val("")
                 addToGrid(imp1)
                    

            }   
            })
        $("#inputbtn2").on("click", {
            if($('#b2')[0].getText().size()==0){
                alert("กรุณากรอกจำนวนสินค้า")
            }
            else{

                def b2 = $('#b2')[0].getText()
                int t=Integer.valueOf(b2);
                def y = t*20
                def imp2 = new Sales(buyCount:i , salesProduct:"LAYS" , salesAmount:b2,salesprice:y,date:new Date())
                imp2.save()
                $('#b2').val("")
                 addToGrid(imp2)
                    

            }   
            })
        $("#inputbtn3").on("click", {
            if($('#b3')[0].getText().size()==0){
                alert("กรุณากรอกจำนวนสินค้า")
            }
            else{

                def b3 = $('#b3')[0].getText()
                int t=Integer.valueOf(b3);
                def y = t*20
                def imp3 = new Sales(buyCount:i , salesProduct:"SNAKJACK" , salesAmount:b3,salesprice:y,date:new Date())
                imp3.save()
                $('#b3').val("")
                 addToGrid(imp3)
                    

            }   
            })
        $("#inputbtn4").on("click", {
            if($('#b4')[0].getText().size()==0){
                alert("กรุณากรอกจำนวนสินค้า")
            }
            else{

                def b4 = $('#b4')[0].getText()
                int t=Integer.valueOf(b4);
                def y = t*20
                def imp4 = new Sales(buyCount:i , salesProduct:"TARO" , salesAmount:b4,salesprice:y,date:new Date())
                imp4.save()
                $('#b4').val("")
                 addToGrid(imp4)
                    

            }   
            })
         $("#inputbtn5").on("click", {
            if($('#b5')[0].getText().size()==0){
                alert("กรุณากรอกจำนวนสินค้า")
            }
            else{

                def b5 = $('#b5')[0].getText()
                int t=Integer.valueOf(b5);
                def y = t*10
                def imp5 = new Sales(buyCount:i , salesProduct:"JUBJUB" , salesAmount:b5,salesprice:y,date:new Date())
                imp5.save()
                $('#b5').val("")
                 addToGrid(imp5)
                    

            }   
            })
          $("#inputbtn6").on("click", {
            if($('#b6')[0].getText().size()==0){
                alert("กรุณากรอกจำนวนสินค้า")
            }
            else{

                def b6 = $('#b6')[0].getText()
                int t=Integer.valueOf(b6);
                def y = t*35
                def imp6 = new Sales(buyCount:i , salesProduct:"POPCORN" , salesAmount:b6,salesprice:y,date:new Date())
                imp6.save()
                $('#b6').val("")
                 addToGrid(imp6)
                    

            }   
            })
           $("#inputbtn7").on("click", {
            if($('#b7')[0].getText().size()==0){
                alert("กรุณากรอกจำนวนสินค้า")
            }
            else{

                def b7 = $('#b7')[0].getText()
                int t=Integer.valueOf(b7);
                def y = t*15
                def imp7 = new Sales(buyCount:i , salesProduct:"COKE" , salesAmount:b7,salesprice:y,date:new Date())
                imp7.save()
                $('#b7').val("")
                 addToGrid(imp7)
                    

            }   
            })
            $("#inputbtn8").on("click", {
            if($('#b8')[0].getText().size()==0){
                alert("กรุณากรอกจำนวนสินค้า")
            }
            else{

                def b8 = $('#b8')[0].getText()
                int t=Integer.valueOf(b8);
                def y = t*10
                def imp8 = new Sales(buyCount:i , salesProduct:"WATER" , salesAmount:b8,salesprice:y,date:new Date())
                imp8.save()
                $('#b8').val("")
                 addToGrid(imp8)
                    

            }   
            })

             $("#savebtn").on("click", {
               $("grid rows").detach()
               $("grid").append{rows()
               $("#total").val("")
                }
               i++; 
            })

         
           
        }

        def addToGrid(data) {
        def X = Sales.findAllByBuyCount(data.buyCount)
        def price = 0
        $('grid > rows > row').detach()
        for(f in X){
            price = price + f.salesprice
        $('grid > rows').append{
                        row (){                         
                            label( value: f.salesProduct) 
                            label( value: f.salesAmount)
                            label( value: f.salesprice)
                                                
                            }
                        }
       }
       

        def price1 = price
        $("#total").val(price1)


        }
}
    

