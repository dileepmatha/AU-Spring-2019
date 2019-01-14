import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmplistcomponentComponent } from './emplistcomponent.component';

describe('EmplistcomponentComponent', () => {
  let component: EmplistcomponentComponent;
  let fixture: ComponentFixture<EmplistcomponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmplistcomponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmplistcomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
