import { Component, OnInit } from '@angular/core';
import { Employee } from "../models/employee.model";
import { Attribute } from "../models/attribute.model";
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
    selector: 'app-map',
    templateUrl: './map.component.html',
    styleUrls: ['./map.component.scss']
})
export class MapComponent implements OnInit {

    employees: Employee[];
    totalAttributes: Attribute[];
    empObjs: Employee[];

    constructor(private http: HttpClient) {
        this.employees = [];
        this.totalAttributes = [];
        this.empObjs = [];
    }
    ngOnInit(): void {
        let options = { 'Access-Control-Allow-Origin': '*' };
        let requestOptions = { headers: new HttpHeaders(options) };
        this.http.get<Attribute[]>('http://localhost:8080/api/attributes', requestOptions).subscribe(response => {
            this.totalAttributes = response;
        })
        this.http.get<Employee[]>('http://localhost:8080/api/employees', requestOptions).subscribe(response => {
            this.employees = response;
        })
    }

    viewEmpByAttrId(id: number): void {
        let options = { 'Access-Control-Allow-Origin': '*' };
        let requestOptions = { headers: new HttpHeaders(options) };
        this.http.get<number[]>('http://localhost:8080/api/employees-attribute/attr/' + id, requestOptions).subscribe(response => {
            this.empObjs = [];
            for (let i = 0; i < response.length; i++) {
                for (let j = 0; j < this.employees.length; j++) {
                    if (response[i] == this.employees[j].id) {
                        this.empObjs.push(this.employees[j]);
                    }
                }
            }
        })
    }

}
