import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DeptcomponentComponent } from './deptcomponent/deptcomponent.component';
import { EmplistcomponentComponent } from './emplistcomponent/emplistcomponent.component';
import { EmpcomponentComponent } from './empcomponent/empcomponent.component';
import { NameEditorComponent } from './name-editor/name-editor.component';
import { Form2Component } from './form2/form2.component';
const routes: Routes = [
  {path:'department', component: DeptcomponentComponent },
  {path:'employee', component: EmpcomponentComponent },
  {path:'employee/:id', component: EmplistcomponentComponent},
  {path:'form1', component: NameEditorComponent},
  {path:'form2', component:Form2Component}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
