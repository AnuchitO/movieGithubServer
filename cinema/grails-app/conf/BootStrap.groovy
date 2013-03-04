import cinema.*
class BootStrap {

    def init = { servletContext ->

    	def movie
    	def seats
        def account

        account = new Individual(
            firstName:"apichat",
            lastName:"eakwongsa",
            number:"123",
            date:"123",
            status:"123",
            address:"123",
            moo:"123",
            district:"123",
            canton:"123",
            county:"123",
            post:"123",
            phone:"123",
            email:"123",
            degree:"123",
            major:"123",
            university:"123",
            position:"123",
            userId:"admin",
            password:"admin",
            rePassword:"admin"
            ).save()

    	movie = new Movie(
    		movId:"0000",
		 	movType:"Drama",
		 	movName:'Demo',
		 	movSuperintendent:"pad Nong",
		 	movDetail:"Love",
		 	movCost:"2M",
		 	movDate:"1/1/1111",
			movDateEnd:"1/2/1111",
		 	movPicture640:"http://www.bloggang.com/data/treehousedream/picture/1200725803.jpg",
		 	movPicture140:"http://www.bloggang.com/data/treehousedream/picture/1200725803.jpg",
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
