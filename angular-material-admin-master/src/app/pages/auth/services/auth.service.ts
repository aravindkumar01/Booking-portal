import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

import { User } from '../models';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

   baseURL:string="http://localhost:8080";

  constructor(private http: HttpClient) {

  
  }
  
  login(user:any){
 

    return this.http.post(this.baseURL+"/token/generate-token", user,{responseType: 'json'});
  }

 sign(user:any): Observable<any> {

    return this.http.post(this.baseURL+"/signup", user,{responseType: 'text'});
 }

  public signOut(): void {
    localStorage.removeItem('token');
  }

  public getUser(): Observable<User> {
    return of({
      name: 'John',
      lastName: 'Smith'
    });
  }
}
