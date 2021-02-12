import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Hotel } from './model/hotel/hotel';
import { RoomsListService } from './service/rooms-list.service';

@Component({
  selector: 'app-rooms-list',
  templateUrl: './rooms-list.component.html',
  styleUrls: ['./rooms-list.component.css']
})
export class RoomsListComponent implements OnInit {

  constructor(private router: Router,private service:RoomsListService) { }

  hotels:Hotel[];
  ngOnInit(): void {
    
    this.service.getAllHotels().subscribe(data=>{

      this.hotels= data;
       console.log(this.hotels);
    });

  }

  counter(i: number) {
    return new Array(i);
}

  gotoBooking(id:number) {
    //alert(id);
    this.router.navigate(['/customer/booking/'+id]);


  }

}
