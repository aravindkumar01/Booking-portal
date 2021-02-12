import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RoomsListService } from '../rooms-list/service/rooms-list.service';
import { Constants } from '../model/constants';

@Component({
  selector: 'app-customer-booking-history',
  templateUrl: './customer-booking-history.component.html',
  styleUrls: ['./customer-booking-history.component.css']
})
export class CustomerBookingHistoryComponent implements OnInit {

  constructor(private router: Router,private service:RoomsListService) { }

  hotels:any[];
  ngOnInit(): void {

    this.service.getBookingDetailsByUser(Constants.username).subscribe(data=>{

      this.hotels= data;
       console.log(this.hotels);
    });
  }



  checkOut(id:any){

   
    this.service.postBookingCheckOut(id).subscribe(data=>{
       if(data){
         alert("Checkout done!");
         
         window.location.reload();
       }
    });
  }
}
