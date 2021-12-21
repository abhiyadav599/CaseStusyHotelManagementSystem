import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Guest } from './guest';

@Injectable({
  providedIn: 'root'
})
export class GuestService {

  private baseURL = "http://localhost:8094/receptionist/guest";
  // private baseURL1 = "http://localhost:8094/guest/guestList";
  constructor(private httpClient: HttpClient) { }

    getGuestList(): Observable<Guest[]>{
      return this.httpClient.get<Guest[]>(`${this.baseURL}`);
    }

    createGuest(guest: Guest): Observable<Object>{
      return this.httpClient.post(`${this.baseURL}`,guest);
    }

    getGuestById(id: number): Observable<Guest>{
      return this.httpClient.get<Guest>(`${this.baseURL}/${id}`);
    }

    updateGuest(id: number, guest: Guest): Observable<Object>{
      return this.httpClient.put(`${this.baseURL}/${id}`, guest);
    }

    deleteGuest(id: number): Observable<Object>{
      return this.httpClient.delete(`${this.baseURL}/${id}`);
    }

}
 