import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Staff } from './staff';

@Injectable({
  providedIn: 'root'
})
export class StaffService {

  private baseURL = "http://localhost:8095/manager/staff";

  constructor(private httpClient: HttpClient) { }
  
    getStaffList(): Observable<Staff[]>{
      return this.httpClient.get<Staff[]>(`${this.baseURL}`)
    }

    createStaff(staff: Staff): Observable<Object>{
      return this.httpClient.post(`${this.baseURL}`,staff);
    }

    getStaffById(code: number): Observable<Staff>{
      return this.httpClient.get<Staff>(`${this.baseURL}/${code}`);
    }

    updateStaff(code: number, staff: Staff): Observable<Object>{
      return this.httpClient.put(`${this.baseURL}/${code}`, staff);
    }

    deleteStaff(code: number): Observable<Object>{
      return this.httpClient.delete(`${this.baseURL}/${code}`);
    }

}
