import { Component, OnInit } from '@angular/core';
import { Employee } from "../models/employee.model";
import { Attribute } from "../models/attribute.model";
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.scss']
})

export class EmployeesComponent implements OnInit {

  employees: Employee[];
  employee: Employee;
  totalAttributes: Attribute[];
  attrListMap: any;


  constructor(private http: HttpClient) {
    this.employees = [];
    this.totalAttributes = [];
    this.employee = new Employee();
    this.attrListMap = {};
  }

  ngOnInit(): void {
    // getEmployees();
    let options = { 'Access-Control-Allow-Origin': '*' };
    let requestOptions = { headers: new HttpHeaders(options) };
    this.http.get<Employee[]>('http://localhost:8080/api/employees', requestOptions).subscribe(response => {
      this.employees = response;
    })
    this.http.get<Attribute[]>('http://localhost:8080/api/attributes', requestOptions).subscribe(response => {
      this.totalAttributes = response;
    })

  }

  onSubmit(): void {

    let options = { 'Access-Control-Allow-Origin': '*' };
    let requestOptions = { headers: new HttpHeaders(options) };
    if (this.employee.id) {
      this.http.put<Employee>('http://localhost:8080/api/employees', this.employee, requestOptions).subscribe(response => { })
      this.http.delete('http://localhost:8080/api/employees-attribute/' + this.employee.id, requestOptions).subscribe(() => {
        let tempList: number[] = [];
        for (let i = 0; i < Object.keys(this.attrListMap).length; i++) {
          if (this.attrListMap[Object.keys(this.attrListMap)[i]]) {
            let x: number = +Object.keys(this.attrListMap)[i];
            tempList.push(x);
          }
        }
        this.http.post('http://localhost:8080/api/employees-attribute/' + this.employee.id, tempList, requestOptions).subscribe(() => { })
      })
      //deletebyId on pivot nad on response http.post with list containing id with true value from attrListMap
    } else {
      this.http.post<Employee>('http://localhost:8080/api/employees', this.employee, requestOptions).subscribe(response => {
        this.employees.push(response);
      })
    }

  }

  editEmployee(id: number): void {
    this.attrListMap = {};
    let options = {
      'Access-Control-Allow-Origin': '*',
      'Content-Type': 'text/plain'
    };
    let requestOptions = { headers: new HttpHeaders(options) };
    for (let i = 0; i < this.employees.length; i++) {
      if (this.employees[i].id == id) {
        this.employee = this.employees[i];
        this.employee.attributes = [];
      }
    }
    this.http.get<number[]>('http://localhost:8080/api/employees-attribute/' + id, requestOptions).subscribe(response => {
      for (let i = 0; i < this.totalAttributes.length; i++) {
        this.attrListMap[this.totalAttributes[i].id] = false;
      }
      for (let i = 0; i < response.length; i++) {
        this.attrListMap[response[i]] = true;
      }
    })
  }

  deleteEmployee(): void {
    let options = { 'Access-Control-Allow-Origin': '*' };
    let requestOptions = { headers: new HttpHeaders(options) };
    this.http.delete('http://localhost:8080/api/employees/' + this.employee.id, requestOptions).subscribe(() => {
      this.employees.forEach((value, index) => {
        if (value.id == this.employee.id) this.employees.splice(index, 1)
      })
    })
  }

  clearEmployee(): void {
    this.employee = new Employee();
  }

  getEmployees(): Employee[] {
    return [];
  }
  getAttributes(): Attribute[] {
    return [];
  }
}

