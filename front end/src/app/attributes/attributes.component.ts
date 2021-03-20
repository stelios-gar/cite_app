import { Component, OnInit } from '@angular/core';
import { Attribute } from "../models/attribute.model";
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Component({
    selector: 'app-attributes',
    templateUrl: './attributes.component.html',
    styleUrls: ['./attributes.component.scss']
})
export class AttributesComponent implements OnInit {

    attributes: Attribute[];
    attribute: Attribute;
    constructor(private http: HttpClient) {
        this.attributes = [];
        this.attribute = new Attribute();
    }

    ngOnInit(): void {
        let options = { 'Access-Control-Allow-Origin': '*' };
        let requestOptions = { headers: new HttpHeaders(options) };
        this.http.get<Attribute[]>('http://localhost:8080/api/attributes', requestOptions).subscribe(response => {
            this.attributes = response;
        })
    }

    onSubmit(): void {
        console.log(this.attribute);
        let options = { 'Access-Control-Allow-Origin': '*' };
        let requestOptions = { headers: new HttpHeaders(options) };
        if (this.attribute.id) {
            this.http.put<Attribute>('http://localhost:8080/api/attributes', this.attribute, requestOptions).subscribe(response => { })
        } else {
            this.http.post<Attribute>('http://localhost:8080/api/attributes', this.attribute, requestOptions).subscribe(response => {
                this.attributes.push(response);
            })
        }
    }

    editAttribute(id: number): void {
        for (let i = 0; i < this.attributes.length; i++) {
            if (this.attributes[i].id == id) {
                this.attribute = this.attributes[i];
            }
        }
    }

    deleteAttribute(): void {
        let options = { 'Access-Control-Allow-Origin': '*' };
        let requestOptions = { headers: new HttpHeaders(options) };
        this.http.delete('http://localhost:8080/api/attributes/' + this.attribute.id, requestOptions).subscribe(() => {
            this.attributes.forEach((value, index) => {
                if (value.id == this.attribute.id) this.attributes.splice(index, 1)
            })
        })
    }

    clearAttribute(): void {
        this.attribute = new Attribute();
    }



}