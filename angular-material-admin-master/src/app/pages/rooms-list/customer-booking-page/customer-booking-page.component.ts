import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingDetails } from '../model/booking-details/booking-details';
import { Hotel } from '../model/hotel/hotel';
import { RoomsListService } from '../service/rooms-list.service';
import { Constants } from '../../model/constants';
import { IfStmt } from '@angular/compiler';

@Component({
  selector: 'app-customer-booking-page',
  templateUrl: './customer-booking-page.component.html',
  styleUrls: ['./customer-booking-page.component.css']
})
export class CustomerBookingPageComponent implements OnInit {

  constructor(private route: ActivatedRoute,private service:RoomsListService,private router: Router) { }
id:number;
booking:BookingDetails=new BookingDetails();
hotel:Hotel;
status:string;
count:number;
  ngOnInit(): void {

    this.id=+this.route.snapshot.params['id'];

    this.service.getAllHotel(this.id).subscribe(data=>{

      this.hotel= data;
       console.log(this.hotel);
    });
  }



  getRooms():void{

    console.log("get room:: "+this.booking.arrivalDate);

 

    this.service.getHotelAvailableRoomsCount(this.id,this.booking.arrivalDate).subscribe(data=>{     
       console.log(data);
       this.count=data;
    });
  }


  bookRoom(){

    if(this.count<=this.booking.rooms){      
      this.status="Please enter less then or equal rooms:"+this.count;
      return false;
    }

    
    this.booking.username=Constants.username;
    this.booking.hotelId=this.id;
      this.service.postBookingDetails(this.booking).subscribe(data=>{

        alert(data);
        if(data=="saved"){
            this.booking=new BookingDetails();
            this.router.navigate(['/customer-history']);
        }
     });
  }
}
