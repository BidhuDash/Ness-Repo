import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { error } from 'console';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})

export class UpdateEmployeeComponent implements OnInit {
    id: number;
    employee :Employee;
  
  constructor(private route: ActivatedRoute, private router:Router,private employeeService: EmployeeService ) { }

  ngOnInit(){
    this.employee = new Employee();

    this.id =this.route.snapshot.params['id'];

    this.employeeService.getEmployee(this.id)
      .subscribe(data =>{
        console.log(data);
        this.employee= data;
      },
        error= console.log(error));
  }
  upadateEmployee(){
    this.employeeService.upadateEmployee(this.id,this.employee)
      .subscribe(data => {
        console.log(data);
        this.employee = new Employee();
        this.gotoList();

      },
        error=console.log(error));
  }
  onSubmit(){
    this.upadateEmployee;
  }

  gotoList(){
    this.router.navigate(['/employees']);
  }
  

}
