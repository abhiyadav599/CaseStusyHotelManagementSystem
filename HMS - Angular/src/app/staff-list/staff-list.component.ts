import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Staff } from '../staff';
import { StaffService } from '../staff.service';

@Component({
  selector: 'app-staff-list',
  templateUrl: './staff-list.component.html',
  styleUrls: ['./staff-list.component.css']
})
export class StaffListComponent implements OnInit {

  staff!: Staff[];

  constructor(private router: Router,
    private staffService: StaffService) { }

  ngOnInit(): void {
    this.getStaff();
  }

  private getStaff(){
    this.staffService.getStaffList().subscribe(data => {
      this.staff = data;
    });
  }

  updateStaff(code: number){
    this.router.navigate(['update-staff', code]);
  }

  deleteStaff(code: number){
    this.staffService.deleteStaff(code).subscribe( data => {
      console.log(data);
      this.getStaff();
    })
  }

  staffDetails(code: number){
    this.router.navigate(['staff-details', code]);
  }

}
