package cinema

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class IndexmarketComposer extends GrailsComposer {
def puproduct
    def afterCompose = { window ->

    	println($("#row1"))
        
        $("#nextbtn").on("click", {
				redirect(uri:'totalmarket.zul')
			})
        $("#inputbtn1").on("click", {
        	if($('#b1')[0].getText().size()==0){
        		alert("กรุณากรอกจำนวนสินค้า")
        	}
        	else{
        		def b1 = $('#b1')[0].getText()
        		alert(b1)
        		$('#b1').val("")
        		$('#row1 > row').detach()
        		$('#row1').append{
						row (){							
							label( value: "HANAMI")	
							label( value: b1)
												
							}
						}
					

			}	
			})
         $("#inputbtn2").on("click", {
        	if($('#b2')[0].getText().size()==0){
        		alert("กรุณากรอกจำนวนสินค้า")
        	}
        	else{
        		def b2 = $('#b2')[0].getText()
        		alert(b2)
        		$('#b2').val("")
        		$('#row1 > row').detach()
        		$('#row1').append{
						row (){							
							label( value: "LAYS")	
							label( value: b2)
												
							}
						}
			}	
			})
          $("#inputbtn3").on("click", {
        	if($('#b3')[0].getText().size()==0){
        		alert("กรุณากรอกจำนวนสินค้า")
        	}
        	else{
        		def b3 = $('#b3')[0].getText()
        		alert(b3)
        		$('#b3').val("")
        		$('#row1 > row').detach()
        		$('#row1').append{
						row (){							
							label( value: "SNACK")	
							label( value: b3)
												
							}
						}
			}	
			})
           $("#inputbtn4").on("click", {
        	if($('#b4')[0].getText().size()==0){
        		alert("กรุณากรอกจำนวนสินค้า")
        	}
        	else{
        		def b4 = $('#b4')[0].getText()
        		alert(b4)
        		$('#b4').val("")
        		$('#row1 > row').detach()
        		$('#row1').append{
						row (){							
							label( value: "TARO")	
							label( value: b4)
												
							}
						}
			}	
			})
            $("#inputbtn5").on("click", {
        	if($('#b5')[0].getText().size()==0){
        		alert("กรุณากรอกจำนวนสินค้า")
        	}
        	else{
        		def b5 = $('#b5')[0].getText()
        		alert(b5)
        		$('#b5').val("")
        		$('#row1 > row').detach()
        		$('#row1').append{
						row (){							
							label( value: "JUBJUB")	
							label( value: b5)
												
							}
						}
			}	
			})
			 $("#inputbtn6").on("click", {
        	if($('#b6')[0].getText().size()==0){
        		alert("กรุณากรอกจำนวนสินค้า")
        	}
        	else{
        		def b6 = $('#b6')[0].getText()
        		alert(b6)
        		$('#b6').val("")
        		$('#row1 > row').detach()
        		$('#row1').append{
						row (){							
							label( value: "POPCORN")	
							label( value: b6)
												
							}
						}
			}	
			})
			  $("#inputbtn7").on("click", {
        	if($('#b7')[0].getText().size()==0){
        		alert("กรุณากรอกจำนวนสินค้า")
        	}
        	else{
        		def b7 = $('#b7')[0].getText()
        		alert(b7)
        		$('#b7').val("")
        		$('#row1 > row').detach()
        		$('#row1').append{
						row (){							
							label( value: "COKE")	
							label( value: b7)
												
							}
						}
			}	
			})
			   $("#inputbtn8").on("click", {
        	if($('#b8')[0].getText().size()==0){
        		alert("กรุณากรอกจำนวนสินค้า")
        	}
        	else{
        		def b8 = $('#b8')[0].getText()
        		alert(b8)
        		$('#b8').val("")
        		$('#row1 > row').detach()
        		$('#row1').append{
						row (){							
							label( value: "Water")	
							label( value: b8)
												
							}
						}
			}	
			})

    }
}
