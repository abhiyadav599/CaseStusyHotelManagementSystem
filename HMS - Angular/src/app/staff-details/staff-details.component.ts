import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Staff } from '../staff';
import { StaffService } from '../staff.service';

@Component({
  selector: 'app-staff-details',
  templateUrl: './staff-details.component.html',
  styleUrls: ['./staff-details.component.css']
})
export class StaffDetailsComponent implements OnInit {

  code!: number
  staff!: Staff

  constructor(private route: ActivatedRoute, private staffService: StaffService) { }

  ngOnInit(): void {
    this.code = this.route.snapshot.params['code'];

    this.staff = new Staff();
    this.staffService.getStaffById(this.code).subscribe( data => {
      this.staff = data;
    });
  }

}
