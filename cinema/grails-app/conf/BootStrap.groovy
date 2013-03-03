import cinema.Movie
class BootStrap {

    def init = { servletContext ->

    	def movie
    	def seats

    	movie = new Movie(
    		movId:"0000",
		 	movType:"Drama",
		 	movName:"Demo",
		 	movSuperintendent:"pad Nong",
		 	movDetail:"Love",
		 	movCost:"2M",
		 	movDate:"1/1/1111",
			movDateEnd:"1/2/1111",
		 	movPicture640:"./image/demo640",
		 	movPicture140:"./image/demo140",
			longTime:120	
    	).save()



    //seats= new Seats(seatNumber:"AA",tel:"123456",amount:null,rooms:null)
 	//if (seats.validate()) {
    //    seats.save()
    // }else println seats.errors














    }
    def destroy = {
    }
}
