import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Hotel } from '../model/hotel/hotel';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoomsListService {

  baseURL:string="http://localhost:8080/api/hotel";

  constructor(private http: HttpClient) {  
  }

  
  getAllHotels(){

    var token= "study "+ localStorage.getItem('token');
    console.log("-----------------"+token);
    const headers = new HttpHeaders({Authorization:token});       
     return this.http.get<any[]>(this.baseURL+"/all",{headers});
  }

  getAllHotel(id:number){

    var token= "study "+ localStorage.getItem('token');
    console.log("-----------------"+token);
    const headers = new HttpHeaders({Authorization:token});       
     return this.http.get<any>(this.baseURL+"/"+id,{headers});
  }

  getHotelAvailableRoomsCount(id:any,date:Date){

    var token= "study "+ localStorage.getItem('token');
    
    console.log("-----------------"+token);
    const headers = new HttpHeaders({Authorization:token});    
    //return this.http.get<any>(this.baseURL+"/api/hotel/count?"+"date="+date+"&hotelId="+id,{headers});
    return this.http.get<any>(this.baseURL+"/booking/count?date="+date+"&hotelId="+id,{headers});
  }

  postBookingDetails(booking:any): Observable<any> {

    var token= "study "+ localStorage.getItem('token');
    const headers = new HttpHeaders({Authorization:token}); 
    return this.http.post(this.baseURL+"/booking", booking,{headers:headers,responseType: 'text'});
 }

 postBookingCheckOut(id:number): Observable<any> {

  var token= "study "+ localStorage.getItem('token');
  const headers = new HttpHeaders({Authorization:token}); 
  console.log(token);
  return this.http.get<any>(this.baseURL+"/booking/checkout-user/"+id,{headers});
}

 getBookingDetailsByUser(name:string){

  var token= "study "+ localStorage.getItem('token');
  
  console.log("-----------------"+token);
  const headers = new HttpHeaders({Authorization:token});    
  //return this.http.get<any>(this.baseURL+"/api/hotel/count?"+"date="+date+"&hotelId="+id,{headers});
  return this.http.get<any>(this.baseURL+"/booking/user/"+name,{headers});
}

}
