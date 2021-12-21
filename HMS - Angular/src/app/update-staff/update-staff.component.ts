import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Staff } from '../staff';
import { StaffService } from '../staff.service';

@Component({
  selector: 'app-update-staff',
  templateUrl: './update-staff.component.html',
  styleUrls: ['./update-staff.component.css']
})
export class UpdateStaffComponent implements OnInit {

  code!: number;
  staff: Staff = new Staff();

  constructor(private staffService: StaffService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.code = this.route.snapshot.params['code'];

    this.staffService.getStaffById(this.code).subscribe(data =>{
      this.staff = data;
    },error=> console.log(error));
  }

  onSubmit(){
    this.staffService.updateStaff(this.code, this.staff).subscribe( data =>{
      this.goToStaffList();
    },error => console.log(error));
  }

  goToStaffList(){
    this.router.navigate(['/staff']);
  }

}
