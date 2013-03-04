import cinema.*
class BootStrap {

    def init = { servletContext ->

    	def movie
    	def seats
        def account1
		def account2
		def account3
		def account4
        def room

        account1 = new Individual(
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
            position:"Ticker",
            userId:"admin1",
            password:"admin1",
            rePassword:"admin1"
            ).save()
			
		account2 = new Individual(
            firstName:"โอเด้ง",
            lastName:"โชติชัย",
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
            position:"Market",
            userId:"admin2",
            password:"admin2",
            rePassword:"admin2"
            ).save()
		account3 = new Individual(
            firstName:"ต้อม",
            lastName:"นะ",
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
            position:"Room",
            userId:"admin3",
            password:"admin3",
            rePassword:"admin3"
            ).save()
		account4 = new Individual(
            firstName:"เก๋",
            lastName:"โหด",
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
            position:"Deposit",
            userId:"admin4",
            password:"admin4",
            rePassword:"admin4"
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

        def movie2 = new Movie(
            movId:"0001",
            movType:"Action",
            movName:"COCO",
            movSuperintendent:"9Deng",
            movDetail:"BOOM",
            movCost:"3M",
            movDate:"1/2/1111",
            movDateEnd:"1/3/1111", 
            longTime:160   
        ).save()

        def movie3 = new Movie(
            movId:"0002",
            movType:"SiFi",
            movName:"Core",
            movSuperintendent:"Kopeeno",
            movDetail:"Earth",
            movCost:"2.5M",
            movDate:"1/3/1111",
            movDateEnd:"1/4/1111", 
            longTime:180   
        ).save()

        room = new Rooms(
            roomId:"Room1",
            movie:movie
        ).save()

        room = new Rooms(
            roomId:"Room2",
            movie:movie2
        ).save()

        room = new Rooms(
            roomId:"Room3",
            movie:movie3
        ).save()



    //seats= new Seats(seatNumber:"AA",tel:"123456",amount:null,rooms:null)
 	//if (seats.validate()) {
    //    seats.save()
    // }else println seats.errors














    }
    def destroy = {
    }
}
