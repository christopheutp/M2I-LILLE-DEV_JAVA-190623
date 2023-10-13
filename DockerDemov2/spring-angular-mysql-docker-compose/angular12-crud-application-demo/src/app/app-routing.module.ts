import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CreateEmployeeComponent } from './components/create-employee/create-employee.component';
import { EmployeeListComponent } from './components/employee-list/employee-list.component';
import { UpdateEmployeeComponent } from './components/update-employee/update-employee.component';

const routes: Routes = [
    { path: '', redirectTo: 'employee', pathMatch: 'full' },
    { path: 'add', component: CreateEmployeeComponent },
    { path: 'employees', component: EmployeeListComponent },
    { path: 'update/:id', component: UpdateEmployeeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }