import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeesComponent } from './employees/employees.component';
import { MenuComponent } from './menu/menu.component';
import { AttributesComponent } from './attributes/attributes.component';
import { MapComponent } from './map/map.component';



const routes: Routes = [
  { path: '', redirectTo: '/menu', pathMatch: 'full' },
  { path: 'menu', component: MenuComponent },
  { path: 'employees', component: EmployeesComponent },
  { path: 'attributes', component: AttributesComponent },
  { path: 'map', component: MapComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
