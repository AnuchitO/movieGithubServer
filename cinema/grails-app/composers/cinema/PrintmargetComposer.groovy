package cinema

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class PrintmargetComposer extends GrailsComposer {

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

       				 def X = Sales.findAll()
                     def price = 0
                     def amount = 0

                     $('#row2 > row').detach()
                    for(f in X){
                        price = price + f.salesprice
                        amount = amount + f.salesAmount
                    $('#row2').append{
                                    row (){  
                                        label( value: f.date.format("dd MMMM yyyy"))                  
                                        label( value: f.salesProduct) 
                                        label( value: f.salesAmount)
                                        label( value: f.salesprice)
                                                            
                                        }
                                        $("#dataprint").val(f.date.format("dd MMMM yyyy"))
                                    }
                   }
                   def priceTotal = price
                   $("#total").val(priceTotal)
                   def amountTotal = amount
                   $("#total2").val(amountTotal)
                  

    }
}
