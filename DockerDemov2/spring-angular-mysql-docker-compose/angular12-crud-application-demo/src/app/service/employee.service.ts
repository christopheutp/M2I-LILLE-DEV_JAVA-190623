import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { ApiResponse } from '../model/api.response';
import { Employee } from '../model/employee.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl: string = environment.baseUrl + 'employees';
  constructor(private http: HttpClient) { }

  getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.baseUrl);
  }

  getEmployeeById(id: number): Observable<any> {
    return this.http.get(this.baseUrl + id);
  }

  createEmployee(employee: Employee): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl, employee);
  }

  updateEmployee(id: number, employee: Employee): Observable<ApiResponse> {
    return this.http.put<ApiResponse>(this.baseUrl + employee.id, employee);
  }

  deleteEmployee(id: number): Observable<ApiResponse> {
    return this.http.delete<ApiResponse>(this.baseUrl + id);
  }
}
