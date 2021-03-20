import { Attribute } from './attribute.model';

export class Employee {
    id: number;
    name: string;
    birthdate: string;
    car: boolean;
    homeaddress: string;
    attributes: Attribute[];

    constructor() {
        this.id = null;
        this.name = null;
        this.birthdate = null;
        this.car = false;
        this.homeaddress = null;
        this.attributes = [];
    }
}