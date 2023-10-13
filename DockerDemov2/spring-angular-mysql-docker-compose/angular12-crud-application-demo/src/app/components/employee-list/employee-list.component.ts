import { Component, OnInit, ViewChild } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

import { Employee } from '../../model/employee.model';
import { EmployeeService } from '../../service/employee.service';
import { ApiResponse } from '../../model/api.response';

import * as $ from 'jquery';
import 'datatables.net'

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Employee[] = [];

  constructor(private employeeService: EmployeeService, private router: Router) {
    setTimeout(function() {
      $(function() {
        $('#example').DataTable();
      })
    });
  }

  ngOnInit(): void {
    this.employeeService.getEmployees().subscribe(
      employees => {
        this.employees = employees;
        console.log('Employés récupérés :', employees);
      },
      error => console.error(error)
    );
  }

  deleteEmployee(id: number | undefined) {
    if (id !== undefined) {
    this.employeeService.deleteEmployee(id).subscribe(data => {
      console.log(data);
      this.employeeService.getEmployees().subscribe(
        employees => {
          this.employees = employees;
          console.log('Employés récupérés :', employees);
        },
        error => console.error(error)
      );
    }, error => {
      console.log(error);
    });
  }
  }
  updateEmployee(id: number | undefined) {
    if (id !== undefined) {
    this.router.navigate(['update', id]);
    }
  }
}
