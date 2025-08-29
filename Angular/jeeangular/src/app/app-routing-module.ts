import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Home } from './home/home';
import { Addstudent } from './student/addstudent/addstudent';
import { Allstudent } from './student/allstudent/allstudent';

const routes: Routes = [

  {path: '', component:Home},
  {path: 'addstudent', component:Addstudent},
  {path: 'allstudent', component:Allstudent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
