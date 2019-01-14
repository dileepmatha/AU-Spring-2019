import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { App1ComponentComponent } from './app1-component/app1-component.component';
import { FormsModule} from '@angular/forms';
import { Service1Service } from './service1.service';
import { MyngIfDirective } from './myng-if.directive';
import { EmpcomponentComponent } from './empcomponent/empcomponent.component';
import { DeptcomponentComponent } from './deptcomponent/deptcomponent.component';
import { EmplistcomponentComponent } from './emplistcomponent/emplistcomponent.component';
import { NameEditorComponent } from './name-editor/name-editor.component';
import { Form2Component } from './form2/form2.component';

@NgModule({
  declarations: [
    AppComponent,
    App1ComponentComponent,
    MyngIfDirective,
    EmpcomponentComponent,
    DeptcomponentComponent,
    EmplistcomponentComponent,
    NameEditorComponent,
    Form2Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [Service1Service],
  bootstrap: [AppComponent]
})
export class AppModule { }
