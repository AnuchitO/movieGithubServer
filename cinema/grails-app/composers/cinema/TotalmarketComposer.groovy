package cinema

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class TotalmarketComposer extends GrailsComposer {

    def afterCompose = { window ->
        $("#backbtn").on("click", {
				redirect(uri:'indexmarket.zul')
			})
         def X = Sales.findAll()
       	 $('#row2 > row').detach()
        for(f in X){
        $('#row2').append{
                        row (){  
                            label( value: f.date)                  
                            label( value: f.salesProduct) 
                            label( value: f.salesAmount)
                            label( value: f.salesprice)
                                                
                            }
                        }
       }
    }
}
